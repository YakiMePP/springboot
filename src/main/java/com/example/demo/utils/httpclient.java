package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


import java.util.Map;


public class httpclient {
    //exchange方法，获取get请求
    //@para url:请求url
    //@para headermap 请求header,为空时传null
    public JSONObject httpGet(String url, Map<String,String> headermap){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders requestHeaders=new HttpHeaders();
        if(headermap==null|| headermap.size()==0){
        }else{
            for(Map.Entry<String,String> entry : headermap.entrySet()){
                requestHeaders.add(entry.getKey(),entry.getValue());
            }
        }
        HttpEntity<String> requestEntity=new HttpEntity<String>(null,requestHeaders);
        ResponseEntity<JSONObject> entity=restTemplate.exchange(url, HttpMethod.GET,requestEntity,JSONObject.class);
        JSONObject responsebody =entity.getBody();
        return responsebody;
    }
    //exchange 方法，获取postq请求
    //@para url 请求地址
    //@para para 请求参数 为空时传null
    //headermap 请求头，为空时传null
    public JSONObject httpPost(String url,JSONObject para,Map<String,String> headermap){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders requestHeaders=new HttpHeaders();
        HttpEntity<String> requestEntity;
        if(headermap==null|| headermap.size()==0){
        }else{
            for(Map.Entry<String,String> entry : headermap.entrySet()){
                requestHeaders.add(entry.getKey(),entry.getValue());
            }
        }
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(para==null){
            requestEntity=new HttpEntity<String>(null,requestHeaders);
        }else{
            requestEntity=new HttpEntity<String>(para.toString(),requestHeaders);

        }
        ResponseEntity<JSONObject> entity=restTemplate.exchange(url, HttpMethod.POST,requestEntity,JSONObject.class);

        JSONObject responsebody =entity.getBody();
        return responsebody;
    }






}
