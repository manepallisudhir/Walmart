package com.example.manep.walmart.networkcalls;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String baseUrl, Context context){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
