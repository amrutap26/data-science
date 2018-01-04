package com.softcell.datascience;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softcell.datascience.model.request.client.Bucket;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.rest.constants.AggregationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by datalake on 28/12/17.
 */
public class TestTermAnalysis {

    public static void main(String[] args) throws JsonProcessingException {
        Request<TermAnalysisRequest> termAnalysisRequestRequest=new Request<>();
         TermAnalysisRequest termAnalysisRequest=new TermAnalysisRequest();
        List<Bucket>buckets=new ArrayList();
        Bucket bucket1= new Bucket();
        Bucket bucket2= new Bucket();

        bucket1.setKey("city");
        bucket2.setKey("state");
        buckets.add(bucket1);
        buckets.add(bucket2);
        termAnalysisRequest.setBuckets(buckets);
        termAnalysisRequest.setAggType(AggregationType.stats.name());
        termAnalysisRequest.setDataType("Number");
        termAnalysisRequest.setFieldName("");

        termAnalysisRequestRequest.setRequestBody(termAnalysisRequest);

        ObjectMapper objectMapper=new ObjectMapper();

        System.out.println(objectMapper.writeValueAsString(termAnalysisRequestRequest));


    }

}
