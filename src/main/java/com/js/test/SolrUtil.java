package com.js.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;

public class SolrUtil {
    public static SolrTemplate getTemplate(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("springmvc/spring-solr.xml");
        return (SolrTemplate) app.getBean("solrTemplate");

    }
}
