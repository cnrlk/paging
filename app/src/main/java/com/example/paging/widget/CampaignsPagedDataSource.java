package com.example.paging.widget;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.paging.PageKeyedDataSource;

import com.example.paging.models.Banner;
import com.example.paging.models.Campaign;
import com.example.paging.models.HotDeal;
import com.example.paging.models.ServiceResponse;
import com.example.paging.service.RepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CampaignsPagedDataSource extends PageKeyedDataSource<Integer, Campaign> {

    private RepositoryImpl repository;
    private List<Campaign> campaigns;
    private int pageIndex;

    public CampaignsPagedDataSource(RepositoryImpl repository) {
        this.repository = repository;
        this.campaigns = new ArrayList<>();
    }


    @Override
    public void loadInitial(@NonNull final LoadInitialParams params, @NonNull final LoadInitialCallback callback) {
        repository.fetchCampaigns(pageIndex).enqueue(new Callback<ServiceResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                if (response.isSuccessful()) {
                    List<Banner> banners = response.body().getBanners();
                    List<HotDeal> hotDeals = response.body().getHotDeals();

                    int loopIndex = Math.max(banners.size(), hotDeals.size());
                    for (int i = 0; i < loopIndex; i++) {
                        campaigns.add(new Campaign(banners.size() < i ? null : banners.get(i)
                                , hotDeals.size() < i ? null : hotDeals.get(i)));

                    }

                    pageIndex++;
                    callback.onResult(campaigns,null, 9);
                } else {
                    onFailure(call, new Throwable());
                }
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams params, @NonNull final LoadCallback callback) {
        repository.fetchCampaigns(pageIndex).enqueue(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                if (response.isSuccessful()) {
                    List<Banner> banners = response.body().getBanners();
                    List<HotDeal> hotDeals = response.body().getHotDeals();

                    int loopIndex = Math.max(banners.size(), hotDeals.size());

                    for (int i = 0; i < loopIndex; i++) {
                        campaigns.add(new Campaign(banners.size() < i ? null : banners.get(i)
                                , hotDeals.size() < i ? null : hotDeals.get(i)));

                    }
                    pageIndex++;
                    callback.onResult(campaigns, pageIndex);
                } else {
                    onFailure(call, new Throwable());
                }
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
            }
        });
    }
}
