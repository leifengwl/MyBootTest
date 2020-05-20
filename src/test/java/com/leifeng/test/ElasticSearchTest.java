package com.leifeng.test;

import jdk.internal.instrumentation.Logger;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticSearchTest {


    @Test
    public void createIndex() throws IOException {
        //1、创建一个Settings对象，相当于是一个配置信息。主要配置集群的名称。
        Settings settings = Settings.builder().put("cluster.name","my-elasticsearch").build();
        //2、创建一个客户端Client对象
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9301))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9302))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9303));
        //RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1",9201,"http")));
        //3、使用client对象创建一个索引库
        client.admin().indices().prepareCreate("index_hello2").get();

        //4、关闭client对象
        client.close();

    }

}
















