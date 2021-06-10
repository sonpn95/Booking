package com.example.room.models.response;

public class jwtresponse {
    private final String jwt;

    public  jwtresponse(String jwt){
        this.jwt=jwt;
    }
    public String getJwt(){
        return jwt;
    }
}
