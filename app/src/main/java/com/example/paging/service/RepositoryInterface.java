package com.example.paging.service;

import com.example.paging.models.ServiceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoryInterface {

    @GET("campaigns/{page}")
    Call<ServiceResponse> fetchCampaigns(@Query("page") int page);
}
