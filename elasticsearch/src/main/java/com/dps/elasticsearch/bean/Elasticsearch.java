package com.dps.elasticsearch.bean;

import org.elasticsearch.common.xcontent.XContentBuilder;

public class Elasticsearch {
    private String index;
    private String type;
    private String id;
    private XContentBuilder source;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public XContentBuilder getSource() {
        return source;
    }

    public void setSource(XContentBuilder source) {
        this.source = source;
    }
}
