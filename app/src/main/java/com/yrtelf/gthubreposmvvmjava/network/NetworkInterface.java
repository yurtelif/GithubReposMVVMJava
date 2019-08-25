package com.yrtelf.gthubreposmvvmjava.network;

import com.yrtelf.gthubreposmvvmjava.model.RepoResource;

import java.util.ArrayList;
import java.util.ResourceBundle;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface NetworkInterface {

    @GET("/users/yurtelif/repos")
    Call<ArrayList<RepoResource>> getUserRepos();

}
