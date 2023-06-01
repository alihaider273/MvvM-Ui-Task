package com.app.mvvmtest.ui;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.app.mvvmtest.viewmodel.MainViewModel;
import com.app.mvvmtest.R;
import com.app.mvvmtest.adapter.PostAdapter;
import com.app.mvvmtest.model.Post;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    Context context;
    MainViewModel viewModel;
    RecyclerView recyclerView;
    PostAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        recyclerViewAdapter = new PostAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(this, userListUpdateObserver);
    }
    Observer<List<Post>> userListUpdateObserver = new Observer<List<Post>>() {
        @Override
        public void onChanged(List<Post> postArrayList) {
            recyclerViewAdapter.updateUserList(postArrayList);
        }
    };

}