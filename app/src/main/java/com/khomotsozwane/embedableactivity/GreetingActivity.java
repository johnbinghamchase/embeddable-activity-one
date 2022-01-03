package com.khomotsozwane.embedableactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.khomotsozwane.embedableactivity.models.Post;
import com.khomotsozwane.embedableactivity.service.Functions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GreetingActivity extends AppCompatActivity {

    public TextView errorText;
    public TextView postText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        errorText = findViewById(R.id.error);
        postText = findViewById(R.id.post);

        Functions.fetchPostByID("1").enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                errorText.setVisibility(View.GONE);
                postText.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                errorText.setText(t.getMessage());
                postText.setVisibility(View.GONE);
            }
        });
    }
}