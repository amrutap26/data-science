package com.softcell.datascience.util;

import com.softcell.datascience.model.query.Query;
import com.softcell.datascience.model.request.client.ChaidAnalysisRequest;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;

import java.util.List;

/**
 * Created by datalake on 29/12/17.
 */
public interface AnalysisQueryBuilder<T> {

    public T buildTermAnalysisQuery(TermAnalysisRequest termAnalysisRequest);
}
