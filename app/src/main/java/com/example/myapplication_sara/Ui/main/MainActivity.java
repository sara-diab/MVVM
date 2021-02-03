package com.example.myapplication_sara.Ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication_sara.Model.PostModel;
import com.example.myapplication_sara.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    postViewModel postViewModel;
    Image image ;
    postAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity name
        final String TAG = MainActivity.class.getSimpleName();
        Log.d("ActivityName", TAG );

        //نلاحظ أننا نستخدم في الإنشاء ViewModelProviders, وهي ستقوم بحفظ وتخزين ViewModel ل activity  المعطى
        // بمعنى, في حال حدثت حالة configChanges -كتغير orientation- ل activity
        // سيقوم  class ViewModelProviders بتخزين بيانات ViewModel
        postViewModel = ViewModelProviders.of(this).get(postViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        postAdapter adapter = new postAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        postViewModel.postsMutableLiveData.observe(this, new  Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
               int count= adapter.getItemCount();

            }
        });


    }


}