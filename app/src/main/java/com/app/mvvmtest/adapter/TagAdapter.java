package com.app.mvvmtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.jadgroup.recyclerviewlivedata.R;
//import com.jadgroup.recyclerviewlivedata.model.User;

import com.app.mvvmtest.R;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.RecyclerViewViewHolder> {

    List<String> tagsList;

    public TagAdapter(List<String> tagsList) {
        this.tagsList = tagsList;
    }


    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tags_view, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {

        String tag = tagsList.get(position);
        holder.tvTag.setText(tag);
    }

    @Override
    public int getItemCount() {
        return tagsList.size();
    }


    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvTag;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tvTag);

        }
    }
}
