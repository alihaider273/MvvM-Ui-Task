package com.app.mvvmtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mvvmtest.R;
import com.app.mvvmtest.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.RecyclerViewViewHolder> {
    List<Post> postArrayList;
    public PostAdapter() {
        this.postArrayList = new ArrayList<Post>();
    }


    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_view,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        Post post = postArrayList.get(position);
        holder.tvTitle.setText(post.getTitle());
        holder.tvDescription.setText(post.getDescription());
        holder.rvTags.setAdapter(new TagAdapter(post.getTags()));
        holder.rvComments.setAdapter(new CommentsAdapter(post.getComments()));
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public void updateUserList( List<Post> postArrayList) {
        this.postArrayList.clear();
        this.postArrayList = postArrayList;
        notifyDataSetChanged();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvTags;
        RecyclerView rvComments;
       ImageView ivPostImage;
       TextView tvTitle;
       TextView tvDescription;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            rvTags = itemView.findViewById(R.id.rvTags);
            rvComments = itemView.findViewById(R.id.rvComments);
            ivPostImage = itemView.findViewById(R.id.ivPostImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTitle = itemView.findViewById(R.id.tvTitle);

        }
    }
}
