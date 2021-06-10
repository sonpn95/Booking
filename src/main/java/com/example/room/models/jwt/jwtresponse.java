package com.example.room.models.jwt;

public class jwtresponse {
    private final String jwt;

    public  jwtresponse(String jwt){
        this.jwt=jwt;
    }
    public String getJwt(){
        return jwt;
    }
}
