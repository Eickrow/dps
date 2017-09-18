package com.dps.realization.elasticsearch;

import com.dps.elasticsearch.api.ElasticsearchDocumentAPI;
import com.dps.elasticsearch.bean.Elasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Component
public class ElasticsearchTester {
    @Autowired
    private ElasticsearchDocumentAPI elasticsearchDocumentAPI;

    public void add() throws IOException {
        elasticsearchDocumentAPI.save(build());
    }

    public void bulkAdd() throws IOException {
        List<Elasticsearch> elasticsearchList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            elasticsearchList.add(build());
        }
        elasticsearchDocumentAPI.save(elasticsearchList);
    }

    private Elasticsearch build() throws IOException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Elasticsearch elasticsearch = new Elasticsearch();
        elasticsearch.setIndex("test");
        elasticsearch.setType("test");
        elasticsearch.setId(uuid);
        Map<String,Object> map=new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        elasticsearch.setSource(jsonBuilder()
                .startObject()
                .field("no", 1)
                .field("createdTime", new Date())
                .field("messageCD", "trying out Elasticsearch")
                .field("list",Arrays.asList(123,123,123,312))
                .field("map",map)
                .endObject());
        return elasticsearch;
    }
}
