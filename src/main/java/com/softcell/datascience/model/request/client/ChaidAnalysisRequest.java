package com.softcell.datascience.model.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*{
       "data-point-name": "cibilScore",
           "data-point-type": "numeric",
           "level": 2,
           "buckets": [
       {
           "key": "500-600",
               "from": 500,
               "to": 600
       },
       {
           "key": "600-700",
               "from": 600,
               "to": 700
       },
       {
           "key": "700-800",
               "from": 700,
               "to": 800
       }
   ]
   }*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChaidAnalysisRequest {
    private String fieldName;
    private String fieldType;
    private Integer level;
    private Integer size;
    private List<Bucket> buckets;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<Bucket> getBuckets() {
		return buckets;
	}
	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChaidAnalysisRequest [fieldName=");
		builder.append(fieldName);
		builder.append(", fieldType=");
		builder.append(fieldType);
		builder.append(", level=");
		builder.append(level);
		builder.append(", size=");
		builder.append(size);
		builder.append(", buckets=");
		builder.append(buckets);
		builder.append("]");
		return builder.toString();
	}
    
    
    
    
    
    
    
}
