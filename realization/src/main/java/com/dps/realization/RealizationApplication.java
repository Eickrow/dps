package com.dps.realization;

import com.dps.elasticsearch.ElasticsearchAutoConfiguration;
import com.dps.elasticsearch.api.ElasticsearchAPI;
import com.dps.elasticsearch.bean.Elasticsearch;
import com.dps.realization.elasticsearch.ElasticsearchTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@SpringBootApplication
@Import(ElasticsearchAutoConfiguration.class)
public class RealizationApplication implements CommandLineRunner {
    @Autowired
    private ElasticsearchTester elasticsearchTester;

    public static void main(String[] args) {
        SpringApplication.run(RealizationApplication.class, args);
    }

    public void run(String... strings) throws Exception {
        elasticsearchTester.add();
        elasticsearchTester.bulkAdd();
    }
}
