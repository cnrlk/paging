package com.example.paging.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.paging.CampaignsActivityViewmodel;
import com.example.paging.R;
import com.example.paging.databinding.CampaignsActivityBinding;
import com.example.paging.widget.CampaignsPagedListAdapter;

public class CampaignsActivity extends AppCompatActivity {

    private CampaignsActivityViewmodel viewmodel;
    private CampaignsActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.campaigns_activity);
        viewmodel = new CampaignsActivityViewmodel();
        binding.setViewModel(viewmodel);

        init();

    }

    private void init() {
        final CampaignsPagedListAdapter adapter = new CampaignsPagedListAdapter();
        binding.pagedList.setLayoutManager(new LinearLayoutManager(this));
        binding.pagedList.setAdapter(adapter);

        viewmodel.getPagedListLiveData().observe(this, adapter::submitList);

    }
}
