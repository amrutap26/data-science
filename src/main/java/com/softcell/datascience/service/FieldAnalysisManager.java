package com.softcell.datascience.service;

import com.softcell.datascience.model.request.client.BaseRequest;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.model.response.FieldsProperty;
import com.softcell.datascience.model.response.Response;
import com.softcell.datascience.model.request.client.Request;

import java.io.IOException;
import java.util.List;

/**
 * Created by datalake on 27/12/17.
 */
public interface FieldAnalysisManager {

     public Object getFieldAnalysis(Request<TermAnalysisRequest> request)throws IOException;;
     public Response getFieldProperty(Request<BaseRequest> request);
     public Response saveFieldProperty(FieldsProperty request);
}
