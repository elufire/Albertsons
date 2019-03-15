package com.example.albertsons;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.albertsons.databinding.ItemBinding;
import com.example.albertsons.databinding.VariationsItemBinding;

import java.util.ArrayList;

public class RecyclerVariationsAdapter extends RecyclerView.Adapter<RecyclerVariationsAdapter.ViewHolder>{

    ArrayList<Var> vars;

    public RecyclerVariationsAdapter(ArrayList<Var> passedVars){
        vars = passedVars;
    }


    @NonNull
    @Override
    public RecyclerVariationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        VariationsItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.variations_item, viewGroup, false);

        RecyclerVariationsAdapter.ViewHolder viewHolder = new RecyclerVariationsAdapter.ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVariationsAdapter.ViewHolder viewHolder, int position) {
        Var var = vars.get(position);
        viewHolder.variationsItemBinding.setVar(var);
    }

    @Override
    public int getItemCount() {
        return vars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        VariationsItemBinding variationsItemBinding;
        public ViewHolder(@NonNull VariationsItemBinding variationsItemBinding) {
            super(variationsItemBinding.getRoot());
            this.variationsItemBinding = variationsItemBinding;
        }
    }
}
