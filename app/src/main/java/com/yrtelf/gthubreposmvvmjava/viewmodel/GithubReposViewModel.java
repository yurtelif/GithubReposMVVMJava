package com.yrtelf.gthubreposmvvmjava.viewmodel;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.yrtelf.gthubreposmvvmjava.R;
import com.yrtelf.gthubreposmvvmjava.adapter.ReposAdapter;
import com.yrtelf.gthubreposmvvmjava.model.RepoResource;
import com.yrtelf.gthubreposmvvmjava.network.GithubApi;
import com.yrtelf.gthubreposmvvmjava.network.NetworkInterface;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubReposViewModel extends ViewModel {

    private ObservableField<ArrayList<RepoResource>> repoResources = new ObservableField<>();
    private ObservableField<String> username = new ObservableField<>();
    private ReposAdapter reposAdapter;

    public ObservableField<ArrayList<RepoResource>> getRepoResources() {
        return repoResources;
    }

    public void init(){
        reposAdapter = new ReposAdapter(R.layout.repos_list_item, this);
    }

    public void setRepoResources(ArrayList<RepoResource> repoResources) {
        this.repoResources.set(repoResources);
    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public void setUsername(ObservableField<String> username) {
        this.username = username;
    }

    public void setReposToAdapter(ArrayList<RepoResource> repoResources){
        this.reposAdapter.setRepoResources(repoResources);
        this.reposAdapter.notifyDataSetChanged();
    }


    public ReposAdapter getReposAdapter() {
        return reposAdapter;
    }

    public RepoResource getRepoResourcesAt(Integer index) {
        if (getRepoResources() != null &&
                index != null &&
                getRepoResources().get().size() > index) {
            return getRepoResources().get().get(index);
        }
        return null;
    }

    public void getRepos(View view){

        NetworkInterface networkInterface = GithubApi.getRetrofitInstance().create(NetworkInterface.class);

        Call<ArrayList<RepoResource>> call = networkInterface.getUserRepos(username.get());

        call.enqueue(new Callback<ArrayList<RepoResource>>() {
            @Override
            public void onResponse(Call<ArrayList<RepoResource>> call, Response<ArrayList<RepoResource>> response) {
                setRepoResources(response.body());
                setReposToAdapter(getRepoResources().get());
            }

            @Override
            public void onFailure(Call<ArrayList<RepoResource>> call, Throwable t) {

            }
        });

    }

}
