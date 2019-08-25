

package com.yrtelf.gthubreposmvvmjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.yrtelf.gthubreposmvvmjava.databinding.ActivityGithubReposBinding;
import com.yrtelf.gthubreposmvvmjava.viewmodel.GithubReposViewModel;

public class GithubReposActivity extends AppCompatActivity {

    private GithubReposViewModel githubReposViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_repos);
        ActivityGithubReposBinding activityGithubReposBinding = DataBindingUtil.setContentView(this,R.layout.activity_github_repos);
        githubReposViewModel = ViewModelProviders.of(this).get(GithubReposViewModel.class);
        githubReposViewModel.init();
        activityGithubReposBinding.setViewModel(githubReposViewModel);
    }





}
