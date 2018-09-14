package com.example.manep.walmart.networkcalls;

import com.example.manep.walmart.models.ProductDetailsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("walmartproducts/{pageNumber}/{pageSize}")
    Call<ProductDetailsData> getRetroProductDetails(@Path("pageNumber") String pageNo , @Path("pageSize") String pageSize);
}
