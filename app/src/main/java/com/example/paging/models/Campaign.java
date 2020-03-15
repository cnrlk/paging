package com.example.paging.models;


import android.os.Build;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DiffUtil;

import com.example.paging.utils.Converter;

import java.text.ParseException;

public class Campaign {

    private HotDeal hotDeal;
    private Banner banner;

    public Campaign(Banner banner, HotDeal hotDeal) {
        this.banner = banner;
        this.hotDeal = hotDeal;
    }

    public HotDeal getHotDeal() {
        return hotDeal;
    }

    public void setHotDeal(HotDeal hotDeal) {
        this.hotDeal = hotDeal;
    }

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public static DiffUtil.ItemCallback<Campaign> DIFF_CALLBACK = new DiffUtil.ItemCallback<Campaign>() {
        @Override
        public boolean areItemsTheSame(@NonNull Campaign oldItem, @NonNull Campaign newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Campaign oldItem, @NonNull Campaign newItem) {
            return false;
        }
    };

    public String getHotDealTitle(int position) {
        return hotDeal.getTitle().concat(" #").concat(String.valueOf(position+1));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getRemainingTime() {
        String remaining = "";

        try {
            remaining = Converter.getRemaining(Converter.parseToDate(hotDeal.getExpirationDate()).getTime() - DateUtils.DAY_IN_MILLIS);
        } catch (ParseException e) {
            e.printStackTrace();
            remaining = hotDeal.getExpirationDate();
        }

        return remaining;
    }

}
