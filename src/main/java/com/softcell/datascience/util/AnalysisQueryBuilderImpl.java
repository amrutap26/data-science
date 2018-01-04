package com.softcell.datascience.util;

import com.softcell.datascience.model.query.*;
import com.softcell.datascience.model.request.client.Bucket;
import com.softcell.datascience.model.request.client.ChaidAnalysisRequest;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by datalake on 29/12/17.
 */
@Service
public class AnalysisQueryBuilderImpl  implements AnalysisQueryBuilder {


//    public Query buildChaidQuery(ChaidAnalysisRequest request) {
//
//        Query query = new Query();
//
//        query.setAggregation(getAggregationObject());
//        query.getAggregation().setPlaceHolder(getPlaceHolder(request));
//
//
//        //
//
//        System.out.println("Elastic Query "+query);
//
//        return query;
//    }


    private Aggregation getAggregationObject() {
        return new Aggregation();
    }

    private PlaceHolder getPlaceHolder(TermAnalysisRequest termAnalysisRequest) {
        PlaceHolder placeHolder;


        if (termAnalysisRequest.getDataType().equals("numeric")) {
            placeHolder = PlaceHolder.builder()
                    .range(RangeBucket.builder()
                            .field(termAnalysisRequest.getFieldName())
                            .keyed(true)
                            .ranges(getRanges(termAnalysisRequest.getBuckets()))
                            .build())
                    .build();
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

    @Override
    public Object buildTermAnalysisQuery(TermAnalysisRequest termAnalysisRequest) {
        Query query = new Query();
        System.out.println(" ENTRY__________Elastic Query "+query);

        query.setAggregation(getAggregationObject());

        System.out.println(" INTERVAL__________Elastic Query "+query);

        query.getAggregation().setPlaceHolder(getPlaceHolder(termAnalysisRequest));


        //

        System.out.println("Elastic Query "+query);

        return query;
    }
}
