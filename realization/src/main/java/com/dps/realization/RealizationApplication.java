package com.dps.realization;

import com.dps.elasticsearch.ElasticsearchAutoConfiguration;
import com.dps.realization.elasticsearch.ElasticsearchTester;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.*;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@SpringBootApplication
@Import(ElasticsearchAutoConfiguration.class)
public class RealizationApplication implements CommandLineRunner {
    @Autowired
    private ElasticsearchTester elasticsearchTester;

    @Resource(name = "transportClient")
    private TransportClient transportClient;

    public static void main(String[] args) {
        SpringApplication.run(RealizationApplication.class, args);
    }

    public void run(String... strings) throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1);
//        map.put("msgA", "this is a index");
//        map.put("createdTime", new Date());
//        transportClient.prepareIndex("a", "2017-09-18", "1a").setSource(map).get();
//        map.put("id", 1);
//        map.put("msgB", "this is b index");
//        map.put("createdTime", new Date());
//        transportClient.prepareIndex("b", "2017-09-18", "1b").setSource(map).get();
        SearchResponse response = transportClient.prepareSearch("a", "b")
//                .setTypes("2017-09-18")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("id", "1"))                 // Query
                .get();
        Arrays.asList(response.getHits().getHits()).forEach(hit->{
            System.out.println(hit.getSourceAsString());
        });
    }
}
