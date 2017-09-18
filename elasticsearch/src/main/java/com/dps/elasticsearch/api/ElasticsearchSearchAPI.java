package com.dps.elasticsearch.api;

import org.springframework.stereotype.Service;

public class ElasticsearchSearchAPI {
//     * 使用QueryBuilder
//     * termQuery("key", obj) 完全匹配
//     * termsQuery("key", obj1, obj2..)   一次匹配多个值
//     * matchQuery("key", Obj) 单个匹配, field不支持通配符, 前缀具高级特性
//     * multiMatchQuery("text", "field1", "field2"..);  匹配多个字段, field有通配符也行
//     * matchAllQuery();         匹配所有文件

//        QueryBuilder queryBuilder = QueryBuilders.termQuery("user", "kimchy", "wenbronk", "vini");
//        QueryBuilders.termsQuery("user", new ArrayList<String>().add("kimchy"));
//        QueryBuilder queryBuilder = QueryBuilders.matchQuery("user", "kimchy");
//        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("kimchy", "user", "message", "gender");
//        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
/**************************************************************************************************************/
//     * 组合查询
//     * must(QueryBuilders)    :   AND
//     * mustNot(QueryBuilders) :   NOT
//     * should:                :   OR
//        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
//                .must(QueryBuilders.termQuery("user", "kimchy"))
//                .mustNot(QueryBuilders.termQuery("message", "nihao"))
//                .should(QueryBuilders.termQuery("gender", "male"));
/**************************************************************************************************************/
//      * 只查询一个id的
//      * QueryBuilders.idsQuery(String...type).ids(Collection<String> ids)
/**************************************************************************************************************/
//     * 包裹查询, 高于设定分数, 不计算相关性
//         QueryBuilder queryBuilder = QueryBuilders.constantScoreQuery(QueryBuilders.termQuery("name", "kimchy")).boost(2.0f);
/**************************************************************************************************************/
//     * disMax查询
//     * 对子查询的结果做union, score沿用子查询score的最大值,
//     * 广泛用于muti-field查询
//      QueryBuilder queryBuilder = QueryBuilders.disMaxQuery()
//        .add(QueryBuilders.termQuery("user", "kimch"))  // 查询条件
//        .add(QueryBuilders.termQuery("message", "hello"))
//        .boost(1.3f)
//        .tieBreaker(0.7f);
/**************************************************************************************************************/
//     * 模糊查询
//     * 不能用通配符, 不知道干啥用
//        QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("user", "kimch");
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
/**************************************************************************************************************/
}
