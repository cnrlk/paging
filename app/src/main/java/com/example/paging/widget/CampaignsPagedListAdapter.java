package com.example.paging.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paging.R;
import com.example.paging.databinding.PairCapaignsLayoutBinding;
import com.example.paging.models.Campaign;
import com.squareup.picasso.Picasso;

public class CampaignsPagedListAdapter extends PagedListAdapter<Campaign, CampaignsPagedListAdapter.CampaignsViewHolder> {

    public CampaignsPagedListAdapter() {
        super(Campaign.DIFF_CALLBACK);

    }


    @NonNull
    @Override
    public CampaignsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PairCapaignsLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.pair_capaigns_layout, parent,false);

        return new CampaignsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignsViewHolder holder, int position) {
        holder.binding.setCampaign(getItem(position));
        holder.binding.setPosition(position);
        Picasso.get().load(getItem(position).getBanner().getImage().getUrl())
                .into(holder.binding.imageBanner);

    }

    @Nullable
    @Override
    protected Campaign getItem(int position) {
        return super.getItem(position);
    }

    class CampaignsViewHolder extends RecyclerView.ViewHolder {

        PairCapaignsLayoutBinding binding;

        CampaignsViewHolder(PairCapaignsLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

    }
}
