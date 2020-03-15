package com.example.paging.models;

import java.util.List;

public class ServiceResponse {


    private List<Banner> banners;
    private List<HotDeal> hotDeals;

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<HotDeal> getHotDeals() {
        return hotDeals;
    }

    public void setHotDeals(List<HotDeal> hotDeals) {
        this.hotDeals = hotDeals;
    }
}
