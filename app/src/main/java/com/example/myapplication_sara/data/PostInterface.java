package com.example.myapplication_sara.data;

import com.example.myapplication_sara.Model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostModel>> getPosts();
}
