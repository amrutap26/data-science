package com.softcell.datascience.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softcell.datascience.model.query.*;
import com.softcell.datascience.model.request.client.Bucket;
import com.softcell.datascience.model.request.client.ChaidAnalysisRequest;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.rest.constants.AggregationType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by datalake on 2/1/18.
 */

@Component
public class AnalyticsQueryBulder {

    int i = 0;
    int j = 0;

    public static <K, V> void add(LinkedHashMap<K, V> map, int index, K key, V value) {
        assert (map != null);
        assert !map.containsKey(key);
        assert (index >= 0) && (index < map.size());

        int i = 0;
        List<Map.Entry<K, V>> rest = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (i++ >= index) {
                rest.add(entry);
            }
        }
        map.put(key, value);
        for (int j = 0; j < rest.size(); j++) {
            Map.Entry<K, V> entry = rest.get(j);
            map.remove(entry.getKey());
            map.put(entry.getKey(), entry.getValue());
        }
    }


    private Aggregation getAggregationObject() {
        return new Aggregation();
    }

    private PlaceHolder getPlaceHolder(TermAnalysisRequest termAnalysisRequest) {

        PlaceHolder placeHolder=null;
        AggregationPlaceHolder aggregationPlaceHolder;


        if (termAnalysisRequest.getDataType().equals("numeric")) {

           if( termAnalysisRequest.getAggType().equals(AggregationType.stats.name())){
                placeHolder = PlaceHolder.builder()
                        .stats(Stats.builder().fieldName(termAnalysisRequest.getFieldName())
                                .build())
                        .build();
            }
            if( termAnalysisRequest.getAggType().equals(AggregationType.extended_stats.name())){
                placeHolder = PlaceHolder.builder()
                        .extended_stats(ExtendedStats.builder().fieldName(termAnalysisRequest.getFieldName())
                                .build())
                        .build();
            }

            if( termAnalysisRequest.getAggType().equals(AggregationType.terms.name())) {

            placeHolder = PlaceHolder.builder()
                    .range(RangeBucket.builder()
                            .field(termAnalysisRequest.getFieldName())
                            .keyed(true)
                            .ranges(getRanges(termAnalysisRequest.getBuckets()))
                            .build())
                    .build();
            }

        } else {
            placeHolder = PlaceHolder.builder()
                    .term(Term.builder()
                            .field(StringUtils.join(termAnalysisRequest.getFieldName(), ".keyword"))
                            //  .size(null != chaidAnalysisRequest.getSize() && chaidAnalysisRequest.getSize() > 0 ? chaidAnalysisRequest.getSize() : 1000)
                            .build())
                    .build();
        }
        return placeHolder;
    }



    private List<Range> getRanges(List<Bucket> buckets) {
        List<Range> ranges = new ArrayList<>();
        for (Bucket bucket : buckets) {
            ranges.add(Range.builder()
                    .from(bucket.getFrom())
                    .to(bucket.getTo())
                    .key(bucket.getKey())
                    .build());
        }
        return ranges;
    }

   // @Override
    public Object buildTermAnalysisQuery(TermAnalysisRequest termAnalysisRequest) {
        Query query = new Query();

        query.setSize(0);
        int index = 0;

        if (index == 0) {

            query.setAggregation(getAggregationObject());

            query.getAggregation().setPlaceHolder(getPlaceHolder(termAnalysisRequest));

        }
            return query;

    }

    public Object getParseObject(String json, Request<TermAnalysisRequest> requestList) {
        Map top = new LinkedHashMap();
        Gson gson = new GsonBuilder().create();
        System.out.println("+++++++++" + json.contains("placeHolder"));
        LinkedHashMap innerMap = gson.fromJson(json, LinkedHashMap.class);
        innerMap.keySet();

      //  json.replaceFirst("placeHolder",requestList.getRequestBody().getAggType());

        Map hits = (Map) innerMap.get("hits");

        Map o = (Map) innerMap.get("aggregations");


        o.put("name",requestList.getRequestBody().getFieldName());

        Object object = o.get("placeHolder");

        Object node = null;
        if (object != null) {
            Object buckets = ((Map) object).get("buckets");
        //    node = getNode(buckets, requestList);

          node=  o;
           /* top.put("name", "totalApplication");
            top.put("doc_count", hits.get("total"));
            top.put("parent", node);*/
        }
        if (node != null) {
            System.out.println("+++++++++"+gson.toJson(node));
        }
        return node;
    }

    public Object getNode(Object object, List<ChaidAnalysisRequest> requestList) {
        List<Map<String, Object>> listObject = new ArrayList<>();
        Map<String, Object> resultMap;
        if (object instanceof List) {
            List<Object> innerList = (List) object;
            for (Object innerObject : innerList) {
                resultMap = new HashMap<>();
                if (innerObject instanceof Map) {
                    Map tempMap = (Map) innerObject;
                    if (i == requestList.size()) {
                        tempMap.put("name", requestList.get(j).getFieldName());
                        int tempCount = j;
                        tempCount--;
                        tempMap.put("parent", requestList.get(tempCount).getFieldName());

                    } else {
                        tempMap.put("name", requestList.get(i).getFieldName());
                    }

                    if (i == 0) {
                        tempMap.put("parent", null);
                    } else if (i < requestList.size()) {
                        int tempCount = i;
                        tempCount--;
                        tempMap.put("parent", requestList.get(tempCount).getFieldName());
                    }
                    innerObject = tempMap;
                    if (i < requestList.size()) {
                        i++;
                    }

                }
                Object temp = ((Map) innerObject).get("placeHolder");
                if (temp != null) {
                    Object bucket = ((Map) temp).get("buckets");
                    Object node = getNode(bucket, requestList);
                    if (node != null) {
                        resultMap.putAll(((Map) innerObject));
                        resultMap.put("placeHolder", node);
                        listObject.add(resultMap);
                    }
                } else {
                    resultMap.putAll((Map) innerObject);
                    listObject.add(resultMap);
                    if (i == requestList.size()) {
                        j = i;
                    }
                    j--;
                }
            }
        } else if (object instanceof Map) {
            Map<String, Object> map = (Map) object;
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                resultMap = new HashMap<>();
                Map<String, Object> innerLoopMap = (Map) map.get(key);
                //
                if (i == requestList.size()) {
                    innerLoopMap.put("name", requestList.get(j).getFieldName());
                    int tempCount = j;
                    tempCount--;
                    innerLoopMap.put("parent", requestList.get(tempCount).getFieldName());

                } else {
                    innerLoopMap.put("name", requestList.get(i).getFieldName());
                }

                if (i == 0) {
                    innerLoopMap.put("parent", null);
                } else if (i < requestList.size()) {
                    int tempCount = i;
                    tempCount--;
                    innerLoopMap.put("parent", requestList.get(tempCount).getFieldName());
                }
                if (i < requestList.size()) {
                    i++;
                }


                //
                Object temp = innerLoopMap.get("placeHolder");
                if (temp != null) {
                    Object bucket = ((Map) temp).get("buckets");
                    Object node = getNode(bucket, requestList);
                    resultMap.put("placeHolder", node);
                    Object o = map.get(key);
                    if (o instanceof Map) {
                        Map o1 = (Map) o;
                        o1.put("key", key);
                        o1.remove("placeHolder");
                        resultMap.putAll((Map) o1);
                    }
                    listObject.add(resultMap);
                } else {
                    resultMap.putAll(innerLoopMap);
                    listObject.add(resultMap);
                    if (i == requestList.size()) {
                        j = i;
                    }
                    j--;
                }
            }
        }
        return listObject.isEmpty() ? null : listObject;
    }

}
