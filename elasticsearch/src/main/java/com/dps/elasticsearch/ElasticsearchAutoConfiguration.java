package com.dps.elasticsearch;

import com.dps.elasticsearch.api.ElasticsearchAPI;
import com.dps.elasticsearch.bean.Elasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@ComponentScan(basePackages = {"com.dps.elasticsearch.api", "com.dps.elasticsearch.configure"})
public class ElasticsearchAutoConfiguration {
}
