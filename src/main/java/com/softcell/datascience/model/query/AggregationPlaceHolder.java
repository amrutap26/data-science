package com.softcell.datascience.model.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by datalake on 2/1/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AggregationPlaceHolder {

    @JsonProperty("terms")
    private Term term;
    @JsonProperty("range")
    private RangeBucket range;
    @JsonProperty("stats")
    private  Stats stats;
    @JsonProperty("aggs")
    private Aggregation aggregations;
}
