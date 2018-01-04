package com.softcell.datascience.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softcell.datascience.config.Config;
import com.softcell.datascience.config.ElasticSearchConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataScienceUtil {

    @Autowired
    private Config config;
    ElasticSearchConfig elasticSearchConfig=new ElasticSearchConfig();

    public String getUrl() {
      //  ElasticSearchConfig elasticSearchConfig = config.elasticSearchConfig();

        elasticSearchConfig.setClusterName("elasticsearch");
        elasticSearchConfig.setIndexDoc("elasticsearch/test");
        elasticSearchConfig.setNodes("localhost:9200");

        System.out.println("***************"+elasticSearchConfig.getClusterName());
        return StringUtils.join("http://", elasticSearchConfig.getNodes(), "/", elasticSearchConfig.getIndexDoc(), "/_search");
    }

//    public String getUrl1() {
//        ElasticSearchConfig elasticSearchConfig = config.elasticSearchConfig();
//        return StringUtils.join("http://", elasticSearchConfig.getNodes()[0], "/", elasticSearchConfig.getIndexDoc(), "/_search");
//    }

    public String buildJsonString(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}
