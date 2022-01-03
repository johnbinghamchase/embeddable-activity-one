package com.khomotsozwane.embedableactivity.service;

import com.khomotsozwane.embedableactivity.models.Post;

import java.util.List;

import retrofit2.Call;

public class Functions {

    public static Call<List<Post>> fetchPosts(){
        return ApiClient.getApiService().getPosts();
    }

    public static Call<Post> fetchPostByID(String id){
        return ApiClient.getApiService().getPostByID(id);
    }
}
