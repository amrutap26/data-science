package com.softcell.datascience.model.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by datalake on 27/12/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermAnalysisRequest extends BaseRequest {

    private String fieldName;
    private List<Bucket> buckets;
    private String aggType;
    private String dataType;

}
