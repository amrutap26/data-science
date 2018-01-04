package com.softcell.datascience.model.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bucket {
    private String key;
    private long from;
    private long to;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getFrom() {
		return from;
	}
	public void setFrom(long from) {
		this.from = from;
	}
	public long getTo() {
		return to;
	}
	public void setTo(long to) {
		this.to = to;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bucket [key=");
		builder.append(key);
		builder.append(", from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append("]");
		return builder.toString();
	}
    
    
    
}
