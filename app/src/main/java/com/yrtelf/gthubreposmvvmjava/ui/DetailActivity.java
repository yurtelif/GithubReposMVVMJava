package com.yrtelf.gthubreposmvvmjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yrtelf.gthubreposmvvmjava.R;
import com.yrtelf.gthubreposmvvmjava.databinding.ActivityDetailBinding;
import com.yrtelf.gthubreposmvvmjava.model.RepoResource;
import com.yrtelf.gthubreposmvvmjava.viewmodel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {

    public static final String REPO_RESOURCE_KEY = "repo.resource.key";

    public static void startDetailActivity(Context context, RepoResource repoResource) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra(REPO_RESOURCE_KEY, repoResource);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActivityDetailBinding activityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        DetailViewModel detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        activityDetailBinding.setViewModel(detailViewModel);
        RepoResource repoResource = getIntent().getParcelableExtra(REPO_RESOURCE_KEY);
        detailViewModel.setAvatarUrl(repoResource.getOwnerResource().getAvatar_url());
        detailViewModel.setOwnerName(repoResource.getOwnerResource().getLogin());
        detailViewModel.setRepoName(repoResource.getName());
        detailViewModel.setOpenIssueCount(getString(R.string.open_issue_count)+repoResource.getOpen_issues_count());
        detailViewModel.setStarCount(getString(R.string.star_count)+repoResource.getStargazers_count());

    }
}
