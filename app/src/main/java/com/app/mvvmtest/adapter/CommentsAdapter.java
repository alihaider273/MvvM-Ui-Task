package com.app.mvvmtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mvvmtest.R;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.RecyclerViewViewHolder> {

    List<String> commentList;

    public CommentsAdapter(List<String> commentList) {
        this.commentList = commentList;
    }


    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment_view, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        String tag = commentList.get(position);
        holder.tvComment.setText(tag);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvComment;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvComment = itemView.findViewById(R.id.tvComment);

        }
    }
}
