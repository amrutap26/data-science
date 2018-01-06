package com.softcell.datascience;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softcell.datascience.model.coreModel.FieldDetails;
import com.softcell.datascience.model.request.client.Request;
import com.softcell.datascience.model.request.client.TermAnalysisRequest;
import com.softcell.datascience.model.response.FieldsProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by datalake on 4/1/18.
 */
public class testFieldsPropertis {


    public static void main(String[] args) throws JsonProcessingException {
      //  Request<FieldsProperty> fieldsPropertyRequest=new Request<>();
        FieldsProperty fieldsProperty = new FieldsProperty();
        FieldDetails listelment=new FieldDetails();
        FieldDetails listelment2=new FieldDetails();
       List<FieldDetails> fieldDetails=new ArrayList<>();
        Set<String> productList=new HashSet<>();
        productList.add("CD");
        productList.add("DPL");
        listelment.setType("TEXT");
        listelment.setUrl("/termstats/");
        listelment.setLevel(0);
        fieldDetails.add(listelment);
        listelment2.setName("age");
        listelment2.setType("number");
        listelment2.setUrl("/termstats/");
        listelment2.setLevel(1);
        fieldDetails.add(listelment2);

        fieldsProperty.setFieldDetails(fieldDetails);
        fieldsProperty.setInstitutionId("4019");
        fieldsProperty.setProducts(productList);
        fieldsProperty.setFieldDetails(fieldDetails);
       // fieldsPropertyRequest.setRequestBody(fieldsProperty);

        ObjectMapper objectMapper=new ObjectMapper();

        System.out.println(objectMapper.writeValueAsString(fieldsProperty));

    }

}
