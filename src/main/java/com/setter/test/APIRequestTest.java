package com.setter.test;




import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.HashMap;
import java.util.Map;

public class APIRequestTest {

    private UriBuilder uri;
    private Map<String, String> params = new HashMap<String, String>();
    private Map<String, String> headers = new HashMap<String, String>();
    private MediaType contentType = MediaType.APPLICATION_XML_TYPE;
    private MediaType acceptType;
    private String httpMethod;
    private String body;

    private APIRequestTest(String uri, String method){
        this.uri = UriBuilder.fromUri(uri);
        this.httpMethod = method;
    }

    public static APIRequestTest GET(String uri){
        return new APIRequestTest(uri, HttpMethod.GET);
    }

    public static APIRequestTest POST(String uri){
        return new APIRequestTest(uri, HttpMethod.POST);
    }

    public static APIRequestTest PUT(String uri){
        return new APIRequestTest(uri, HttpMethod.PUT);
    }

    public static APIRequestTest DELETE(String uri){
        return new APIRequestTest(uri, HttpMethod.DELETE);
    }

    public static APIRequestTest HEAD(String uri){
        return new APIRequestTest(uri, HttpMethod.HEAD);
    }

    public APIRequestTest path(String value){
        this.uri.path(value);
        return this;
    }

    public APIRequestTest param(String key, String value){
        params.put(key, value);
        return this;
    }

    public APIRequestTest type(MediaType type){
        this.contentType = type;
        return this;
    }

    public APIRequestTest accept(MediaType type){
        this.acceptType = type;
        return this;
    }

    public APIRequestTest header(String key, String value){
        headers.put(key, value);
        return this;
    }

    public APIRequestTest body(String body){
        this.body = body;
        return this;
    }



}
