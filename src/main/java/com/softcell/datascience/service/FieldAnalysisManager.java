package com.softcell.datascience.service;

import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.model.response.Response;
import com.softcell.datascience.model.request.client.Request;

import java.io.IOException;
import java.util.List;

/**
 * Created by datalake on 27/12/17.
 */
public interface FieldAnalysisManager {

     public Object getFieldAnalysis(Request<TermAnalysisRequest> request)throws IOException;;

}
