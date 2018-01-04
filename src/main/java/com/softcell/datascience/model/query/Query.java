package com.softcell.datascience.model.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Query {
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("aggs")
    private Aggregation aggregation;
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Aggregation getAggregation() {
		return aggregation;
	}
	public void setAggregation(Aggregation aggregation) {
		this.aggregation = aggregation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Query [size=");
		builder.append(size);
		builder.append(", aggregation=");
		builder.append(aggregation);
		builder.append("]");
		return builder.toString();
	}

    
    
    
}
