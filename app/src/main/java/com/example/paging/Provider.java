package com.example.paging;

import com.example.paging.endpoint.URLS;
import com.example.paging.retrofit.RetrofitProvider;
import com.example.paging.service.RepositoryImpl;
import com.example.paging.service.RepositoryInterface;

public class Provider {

    public static RepositoryImpl getRepository() {
        RepositoryInterface repositoryInterface = RetrofitProvider.getInstance(URLS.BASE_URL)
                .create(RepositoryInterface.class);

        RepositoryImpl repository = new RepositoryImpl(repositoryInterface);

        return repository;
    }
}
