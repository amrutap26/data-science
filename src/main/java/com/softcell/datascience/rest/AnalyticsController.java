package com.softcell.datascience.rest;

import com.softcell.datascience.model.request.client.BaseRequest;
import com.softcell.datascience.model.request.client.ChaidAnalysisRequest;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.model.response.FieldsProperty;
import com.softcell.datascience.service.AnalyticsManager;
import com.softcell.datascience.service.FieldAnalysisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static com.softcell.datascience.rest.constants.EndPointRefferer.*;
import static com.softcell.datascience.rest.constants.EndPointRefferer.FIELDS_ANALYSIS;
import static com.softcell.datascience.rest.constants.EndPointRefferer.FIELD_ANALYSIS;

@RestController
@RequestMapping(
        value = ANALYTICS,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AnalyticsController {

    @Autowired
    private AnalyticsManager analyticsManager;
    @Autowired
    private FieldAnalysisManager fieldAnalysisManager;

    @PostMapping(value = CHAID)
    public ResponseEntity<?> putBasicData(
            @RequestBody final Object query) throws IOException {
        return new ResponseEntity<>(analyticsManager.doChaidAnalysis(query), HttpStatus.OK);
    }

    @PostMapping(value = DYNAMIC_CHAID)
    public ResponseEntity<?> doAnalysis(
            @RequestBody final List<ChaidAnalysisRequest> query) throws IOException {
        return new ResponseEntity<>(analyticsManager.doDynamicChaidAnalysis(query), HttpStatus.OK);
    }


    @PostMapping(value = FIELD_ANALYSIS)
    public ResponseEntity<?> getField(
            @RequestBody Request<TermAnalysisRequest>request ) throws IOException {
        return new ResponseEntity<>(fieldAnalysisManager.getFieldAnalysis(request), HttpStatus.OK);
    }

/*
    @PostMapping(value = FIELDS_ANALYSIS)
    public ResponseEntity<?> getFields(
            @RequestBody final  Request<TermAnalysisRequest> request) throws IOException {
        return new ResponseEntity<>(analyticsManager.doDynamicChaidAnalysis(query), HttpStatus.OK);
    }
    */


    @PostMapping(value = FIELDS_PROPERTY)
    public ResponseEntity<?> getFieldProperty(
            @RequestBody Request<BaseRequest>request ) throws IOException {
        return new ResponseEntity<>(fieldAnalysisManager.getFieldProperty(request), HttpStatus.OK);
    }

    @PostMapping(value = SAVE_FIELDS_PROPERTY)
    public ResponseEntity<?> saveFieldProperty(
            @RequestBody FieldsProperty request ) throws IOException {
        return new ResponseEntity<>(fieldAnalysisManager.saveFieldProperty(request), HttpStatus.OK);
    }


}
