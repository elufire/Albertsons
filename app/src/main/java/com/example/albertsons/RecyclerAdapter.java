package com.example.albertsons;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.albertsons.databinding.ItemBinding;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Lf> abbrevs;
    LinearLayoutManager linearLayoutManager;
    ViewGroup viewGroupTemp;

    public RecyclerAdapter(ArrayList<Lf> passedAbbrevs){
        abbrevs = passedAbbrevs;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        ItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item, viewGroup, false);
        viewGroupTemp = viewGroup;
        //linearLayoutManager = new LinearLayoutManager(viewGroup.getContext(), LinearLayoutManager.HORIZONTAL, false);
        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int position) {
        Lf lf = abbrevs.get(position);
        viewHolder.itemBinding.setLf(lf);
        viewHolder.itemBinding.rvVariations.setLayoutManager(new LinearLayoutManager(viewGroupTemp.getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerVariationsAdapter recyclerVariationsAdapter = new RecyclerVariationsAdapter(new ArrayList<Var>(lf.getVars()));
        viewHolder.itemBinding.rvVariations.setAdapter(recyclerVariationsAdapter);

    }

    @Override
    public int getItemCount() {
        return abbrevs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}

