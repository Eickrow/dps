package com.dps.elasticsearch.configure;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticsearchConfiguration {
    @Autowired
    ElasticsearchParam elasticsearchParam;

    @Bean("transportClient")
    public TransportClient transportClient() {
        return createClient();
    }

    private TransportClient createClient() {
        Settings settings = Settings.builder().put("cluster.name", elasticsearchParam.getClusterName()).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        elasticsearchParam.getNodes().stream()
                .map(node -> new InetSocketTransportAddress(getByName(node), 9300))
                .forEach(client::addTransportAddress);
        return client;
    }

    private InetAddress getByName(String node) {
        try {
            return InetAddress.getByName(node);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

}
