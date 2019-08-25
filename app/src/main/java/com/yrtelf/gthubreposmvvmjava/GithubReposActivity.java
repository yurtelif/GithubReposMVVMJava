

package com.yrtelf.gthubreposmvvmjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

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
        activityGithubReposBinding.setViewModel(githubReposViewModel);
        githubReposViewModel.init();
        setupList();
        activityGithubReposBinding.recyclerView.setAdapter(githubReposViewModel.getReposAdapter());
    }

    private void setupList(){
        githubReposViewModel.getRepos();

    }




    /*

    private void setupBindings(Bundle savedInstanceState) {
        ActivityDogBreedsBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_dog_breeds);
        viewModel = ViewModelProviders.of(this).get(DogBreedsViewModel.class);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        activityBinding.setModel(viewModel);
        setupListUpdate();

    }

    private void setupListUpdate() {
        viewModel.loading.set(View.VISIBLE);
        viewModel.fetchList();
        viewModel.getBreeds().observe(this, new Observer<List<DogBreed>>() {
            @Override
            public void onChanged(List<DogBreed> dogBreeds) {
                viewModel.loading.set(View.GONE);
                if (dogBreeds.size() == 0) {
                    viewModel.showEmpty.set(View.VISIBLE);
                } else {
                    viewModel.showEmpty.set(View.GONE);
                    viewModel.setDogBreedsInAdapter(dogBreeds);
                }
            }
        });
        setupListClick();
    }

    private void setupListClick() {
        viewModel.getSelected().observe(this, new Observer<DogBreed>() {
            @Override
            public void onChanged(DogBreed dogBreed) {
                if (dogBreed != null) {
                    Toast.makeText(DogBreedsActivity.this, "You selected a " +dogBreed.getBreed(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
     */



}
