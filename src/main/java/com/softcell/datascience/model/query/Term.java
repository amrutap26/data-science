package com.softcell.datascience.model.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "field",
        "size"
})
@ToString
@EqualsAndHashCode
public class Term {
    @JsonProperty("field")
    private String field;

    @JsonProperty("size")
    private Integer size;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Term [field=");
		builder.append(field);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}
    
    
    
}
