package com.softcell.datascience.model.request.client;

import java.util.Date;
import java.util.Set;

/**
 * Created by datalake on 27/12/17.
 */
public class BaseRequest {

    private Set<String> institutionId;
    private Set<String> products;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseRequest{");
        sb.append("institutionId=").append(institutionId);
        sb.append(", products=").append(products);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }

    public Set<String> getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Set<String> institutionId) {
        this.institutionId = institutionId;
    }

    public Set<String> getProducts() {
        return products;
    }

    public void setProducts(Set<String> products) {
        this.products = products;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
