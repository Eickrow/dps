package com.dps.realization.elasticsearch;

import com.dps.elasticsearch.api.ElasticsearchAPI;
import com.dps.elasticsearch.bean.Elasticsearch;
import org.elasticsearch.action.bulk.BulkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Component
public class ElasticsearchTester {
    @Autowired
    private ElasticsearchAPI elasticsearchAPI;

    public void add() throws IOException {
        elasticsearchAPI.save(build());
    }

    public void bulkAdd() throws IOException {
        List<Elasticsearch> elasticsearchList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            elasticsearchList.add(build());
        }
        elasticsearchAPI.save(elasticsearchList);
    }

    private Elasticsearch build() throws IOException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Elasticsearch elasticsearch = new Elasticsearch();
        elasticsearch.setIndex("test");
        elasticsearch.setType("test");
        elasticsearch.setId(uuid);
        elasticsearch.setSource(jsonBuilder()
                .startObject()
                .field("no", uuid)
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject());
        return elasticsearch;
    }
}
