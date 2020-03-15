package com.example.paging.service;

import com.example.paging.models.ServiceResponse;

import retrofit2.Call;

public class RepositoryImpl implements RepositoryInterface {

    private RepositoryInterface repositoryInterface;

    public RepositoryImpl(RepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public Call<ServiceResponse> fetchCampaigns(int page) {
        return repositoryInterface.fetchCampaigns(page);
    }
}
