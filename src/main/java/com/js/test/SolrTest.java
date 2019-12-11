package com.js.test;

import org.junit.jupiter.api.Test;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.List;


public class SolrTest {
   private SolrTemplate template = SolrUtil.getTemplate();

    @Test
    public void tiaojian(){
        Query query = new SimpleQuery("*:*");
        Criteria contains = new Criteria("title").contains("solr");
        query.addCriteria(contains);
        ScoredPage<TbItem> tbItems = template.queryForPage(query, TbItem.class);
        List<TbItem> content = tbItems.getContent();
        for(TbItem i : content){
            System.out.println(i);
        }
    }

    public void sousuo(){
        TbItem byId = template.getById(3, TbItem.class);
        System.out.println(byId);
    }
    public void fenye(){
        Query query = new SimpleQuery("*:*");
        //索引开始
        query.setOffset(0);
        //每次查询的条目数
        query.setRows(20);
        ScoredPage<TbItem> tbItems = template.queryForPage(query, TbItem.class);
        System.out.println(tbItems.getTotalPages()+"aaa");
        List<TbItem> content = tbItems.getContent();
        for (TbItem i : content){
            System.out.println(i);
        }
    }
    public void Add(){
        for (long i = 0; i < 50 ; i++){
            TbItem item = new TbItem();
            item.setId(i);
            item.setTitle("solrTest"+i);
            item.setCategory("solr");
            item.setBrand("solr");
            item.setSellerId("solr");
            template.saveBean(item);
            template.commit();
            System.out.println("tianjia"+i);
        }

    }
}
