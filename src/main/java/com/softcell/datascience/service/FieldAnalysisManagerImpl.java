package com.softcell.datascience.service;

import com.softcell.datascience.model.request.client.BaseRequest;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.model.response.*;
import com.softcell.datascience.model.response.Error;
import com.softcell.datascience.model.response.Response.Builder;
import com.softcell.datascience.model.request.client.Request;
;
import com.softcell.datascience.util.DataScienceUtil;
import com.softcell.datascience.util.HttpTransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    MongoTemplate mongoTemplate;





 //   @Override
    public Object getFieldAnalysis(Request<TermAnalysisRequest> query) throws IOException {
        Builder response = new Response.Builder();

      //  httpTransportationService.postRequest(util.getUrl(), util.buildJsonString(query), MediaType.APPLICATION_JSON_UTF8_VALUE.toString();

        TermAnalysisRequest sortedRequestObject = query.getRequestBody();
        Object QueryObj = builder.buildTermAnalysisQuery(sortedRequestObject);


        String chaidGraphJson = httpTransportationService.postRequest(util.getUrl(),
                util.buildJsonString(builder.buildTermAnalysisQuery(sortedRequestObject)), MediaType.APPLICATION_JSON_UTF8_VALUE.toString());
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

    @Override
    public Response getFieldProperty(Request<BaseRequest> request) {
        return null;
    }

    @Override
    public Response saveFieldProperty(FieldsProperty request) {

        boolean flag=true;
        if(flag==true) {
            Builder response = new Response.Builder();
            mongoTemplate.save(request,"FieldDetails");
            response.payload(new Payload<>(request));
            Status status=new Status();
            response.status(status);
            status.setStatusValue(HttpStatus.OK.name());
            return response.build();}
        else
        {
            Builder response = new Response.Builder();
            Status status=new Status();
            status.setStatusValue(HttpStatus.FAILED_DEPENDENCY.name());
            response.status(status);
            return response.build();
        }

       // return null;
    }

    private boolean checkNotNull(FieldsProperty request)
    {
        boolean flag=true;
        Map<String,String> hash=new HashMap<>();
        hash=(Map<String, String>) request;

        for(Map.Entry<String, String> keyValue:hash.entrySet())
        {
            System.out.println("demoCheck");
            System.out.println("length++++++"+keyValue.getValue().toString().length());
            System.out.println("####################"+keyValue.getValue().toString());
            if(keyValue.getValue().equals("")) {
                flag= false;
                break;
            }
            else {
                continue;
            }


        }
        return flag;

    }

}
