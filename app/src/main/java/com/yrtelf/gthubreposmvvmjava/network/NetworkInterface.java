package com.yrtelf.gthubreposmvvmjava.network;

import com.yrtelf.gthubreposmvvmjava.model.RepoResource;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkInterface {

    @GET("users/{user}/repos")
    Call<ArrayList<RepoResource>> getUserRepos(@Path("user") String user);

}
