package com.softcell.datascience.model.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by datalake on 4/1/18.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedStats {

    @JsonProperty("field")
    private String fieldName;
    private String statsType;
}
