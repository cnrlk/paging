package com.example.paging.widget;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.paging.Provider;
import com.example.paging.models.Campaign;
import com.example.paging.service.RepositoryImpl;

public class CampaignDataSourceFactory extends DataSource.Factory<Integer, Campaign> {

    private MutableLiveData<CampaignsPagedDataSource> liveData;
    private RepositoryImpl repository;

    public CampaignDataSourceFactory() {
        repository = Provider.getRepository();
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<CampaignsPagedDataSource> getLiveData() {
        return liveData;
    }

    public void setLiveData(MutableLiveData<CampaignsPagedDataSource> liveData) {
        this.liveData = liveData;
    }

    @NonNull
    @Override
    public DataSource<Integer, Campaign> create() {
        CampaignsPagedDataSource dataSource = new CampaignsPagedDataSource(repository);
        liveData.postValue(dataSource);
        return dataSource;
    }
}
