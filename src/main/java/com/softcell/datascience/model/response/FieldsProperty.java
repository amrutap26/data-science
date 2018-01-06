package com.softcell.datascience.model.response;

import com.softcell.datascience.model.coreModel.FieldDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * Created by datalake on 4/1/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldsProperty {
   private List<FieldDetails> fieldDetails;
   private String institutionId;
    private Set<String> products;

    public List<FieldDetails> getFieldDetails() {
        return fieldDetails;
    }

    public void setFieldDetails(List<FieldDetails> fieldDetails) {
        this.fieldDetails = fieldDetails;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public Set<String> getProducts() {
        return products;
    }

    public void setProducts(Set<String> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FieldsProperty{");
        sb.append("fieldDetails=").append(fieldDetails);
        sb.append(", institutionId='").append(institutionId).append('\'');
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
