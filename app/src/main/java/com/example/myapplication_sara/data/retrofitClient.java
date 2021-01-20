package com.example.myapplication_sara.data;

import com.example.myapplication_sara.Model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient  {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static retrofitClient INSTANCE;

    public retrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static retrofitClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new retrofitClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }
}
