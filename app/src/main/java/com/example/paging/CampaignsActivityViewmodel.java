package com.example.paging;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.paging.models.Banner;
import com.example.paging.models.Campaign;
import com.example.paging.models.HotDeal;
import com.example.paging.widget.CampaignDataSourceFactory;

import java.util.List;

public class CampaignsActivityViewmodel extends BaseObservable {

    private LiveData<PagedList<Campaign>> pagedListLiveData;


    public CampaignsActivityViewmodel() {
        init();
    }

    private List<HotDeal> hotDeals;
    private List<Banner> banners;

    private void init() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setEnablePlaceholders(false)
                .setMaxSize(100)
                .setPrefetchDistance(10)
                .build();

        CampaignDataSourceFactory dataSourceFactory = new CampaignDataSourceFactory();

        pagedListLiveData = new LivePagedListBuilder<>(dataSourceFactory, config).build();

    }

    public LiveData<PagedList<Campaign>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    public void setPagedListLiveData(LiveData<PagedList<Campaign>> pagedListLiveData) {
        this.pagedListLiveData = pagedListLiveData;
    }

    public List<HotDeal> getHotDeals() {
        return hotDeals;
    }

    public void setHotDeals(List<HotDeal> hotDeals) {
        this.hotDeals = hotDeals;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

}
