package com.khomotsozwane.embedableactivity.service;

import com.khomotsozwane.embedableactivity.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{id}")
    Call<Post> getPostByID(@Path("id") String id);

}
