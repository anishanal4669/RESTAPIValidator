package com.setter.test;

import org.junit.Assert;

import javax.ws.rs.core.Response;

public class APIResponseTest {

    private Response response;
    private String body;

    public APIResponseTest(Response response){
        this.response = response;
    }

    public APIResponseTest assertStatus(int status){
        Assert.assertEquals(status, response.getStatus());
        return this;
    }

    public APIResponseTest assertBody (String content){
        String body = getBody();
        Assert.assertEquals(content, body);
        return this;
    }

    public APIResponseTest assertBodyContains(String content){
        String body = getBody();
        Assert.assertEquals(true, body.contains(content));
        return this;
    }

    public String getBody(){
        if(body==null){
            return response.readEntity(String.class);
        }
        return body;
    }

    public <T> T getBody(Class<T> t){
        return response.readEntity(t);
    }
}
