package com.dps.elasticsearch.api;

import com.dps.elasticsearch.bean.Elasticsearch;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetRequestBuilder;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElasticsearchAPI {
    @Resource(name = "transportClient")
    private TransportClient transportClient;

    //单个的增删改查

    public IndexResponse save(Elasticsearch elasticsearch) {
        return transportClient.prepareIndex(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()).setSource(elasticsearch.getSource()).get();
    }

    public DeleteResponse delete(Elasticsearch elasticsearch) {
        return transportClient.prepareDelete(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()).get();
    }

    public UpdateResponse update(Elasticsearch elasticsearch) {
        return transportClient.prepareUpdate(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()).setDoc(elasticsearch.getSource()).get();
    }

    public GetResponse get(Elasticsearch elasticsearch) {
        return transportClient.prepareGet(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()).get();
    }


    //批量的增删改查

    public BulkResponse save(List<Elasticsearch> elasticsearchList) {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        elasticsearchList.stream()
                .map(elasticsearch -> transportClient.prepareIndex(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()).setSource(elasticsearch.getSource()))
                .forEach(bulkRequestBuilder::add);
        return bulkRequestBuilder.get();
    }

    public BulkResponse delete(List<Elasticsearch> elasticsearchList) {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        elasticsearchList.stream()
                .map(elasticsearch -> transportClient.prepareDelete(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()))
                .forEach(bulkRequestBuilder::add);
        return bulkRequestBuilder.get();
    }

    public BulkResponse update(List<Elasticsearch> elasticsearchList) {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        elasticsearchList.stream()
                .map(elasticsearch -> transportClient.prepareUpdate(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()).setDoc(elasticsearch.getSource()))
                .forEach(bulkRequestBuilder::add);
        return bulkRequestBuilder.get();
    }

    public MultiGetResponse get(List<Elasticsearch> elasticsearchList) {
        MultiGetRequestBuilder multiGetRequestBuilder = transportClient.prepareMultiGet();
        elasticsearchList.stream()
                .map(elasticsearch -> new MultiGetRequest.Item(elasticsearch.getIndex(), elasticsearch.getType(), elasticsearch.getId()))
                .forEach(multiGetRequestBuilder::add);
        return multiGetRequestBuilder.get();
    }

}
