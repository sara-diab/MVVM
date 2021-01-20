package com.example.myapplication_sara.Ui.main;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.myapplication_sara.Model.PostModel;
import com.example.myapplication_sara.R;

import java.util.ArrayList;
import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.PostViewHolder> {
    private List<PostModel> postList = new ArrayList<>();


    @NonNull
    @Override
    public postAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull postAdapter.PostViewHolder holder, int position) {
        holder.titleTV.setText(postList.get(position).getTitle());
        holder.userTV.setText(postList.get(position).getUserId()+"");
        holder.bodyTV.setText(postList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setList(List<PostModel> moviesList) {
        this.postList = moviesList;
        notifyDataSetChanged();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.title_tv);
            userTV = itemView.findViewById(R.id.userId_tv);
            bodyTV = itemView.findViewById(R.id.body_tv);
        }
    }


        }
