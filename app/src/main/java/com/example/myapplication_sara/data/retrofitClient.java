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
            Retrofit retrofit = new Retrofit.Builder()   ///bulding
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())  //converter to gson
                    .build();
            postInterface = retrofit.create(PostInterface.class);  //اعرف  interfece
        }

        public static retrofitClient getINSTANCE() {
            //نملأ interface
            if (null == INSTANCE){
                INSTANCE = new retrofitClient();
            }
            return INSTANCE;
        }

    public Call<List<PostModel>> getPosts(){
        return postInterface.getPost();
    }
}
