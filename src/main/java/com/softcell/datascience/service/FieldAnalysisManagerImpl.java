package com.softcell.datascience.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.softcell.datascience.model.request.client.ChaidAnalysisRequest;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.model.response.Payload;
import com.softcell.datascience.model.response.Response;
import com.softcell.datascience.model.response.Response.Builder;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.response.Status;
;
import com.softcell.datascience.model.response.Error;
import com.softcell.datascience.util.AnalysisQueryBuilder;
import com.softcell.datascience.util.DataScienceUtil;
import com.softcell.datascience.util.HttpTransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.softcell.datascience.model.response.Error.*;

/**
 * Created by datalake on 27/12/17.
 */

@Service
public class FieldAnalysisManagerImpl implements FieldAnalysisManager {
    @Autowired
    private HttpTransportationService httpTransportationService;

    @Autowired
    private DataScienceUtil util;

    @Autowired
    private AnalyticsQueryBulder builder;

    @Autowired
    AnalysisQueryBuilder analyticsQueyBuilder;

 //   @Override
    public Object getFieldAnalysis(Request<TermAnalysisRequest> query) throws IOException {
        Builder response = new Response.Builder();

      //  httpTransportationService.postRequest(util.getUrl(), util.buildJsonString(query), MediaType.APPLICATION_JSON_UTF8_VALUE.toString();

        TermAnalysisRequest sortedRequestObject = query.getRequestBody();
        Object QueryObj = builder.buildTermAnalysisQuery(sortedRequestObject);

        String tet = "http://localhost:9200/elasticsearch/test/_search";

        System.out.println("%%%%%%%%%%%%"+tet);
        String chaidGraphJson = httpTransportationService.postRequest(util.getUrl(), util.buildJsonString(builder.buildTermAnalysisQuery(sortedRequestObject)), MediaType.APPLICATION_JSON_UTF8_VALUE.toString());
      //  return builder.getParseObject(chaidGraphJson, sortedRequestObject);

      //  List<ChaidAnalysisRequest> sortedRequestObject = builder.doSorting(query);
     //   String chaidGraphJson = httpTransportationService.postRequest(tet,  QueryObj.toString(), MediaType.APPLICATION_JSON_UTF8_VALUE.toString());
        //return builder.getParseObject(chaidGraphJson, QueryObj);
    if(chaidGraphJson!=null) {
        response.payload(new Payload<>(builder.getParseObject(chaidGraphJson, query)));
        Status status = new Status();
        response.status(status);
    }

    else {

                Status status = new Status.Builder().statusValue(HttpStatus.FAILED_DEPENDENCY.name()).build();
        response.status(status);
                Error error = new Error.Builder().message("TECHINCAL ERROR OCCURED PLEASE CONTACT TO SERVICE PROVIDER ")
                        .build();
        response.error(error);

            }

       /// status.setStatusValue(HttpStatus.OK.name());
        return response.build();

       // return null;

    }
}
