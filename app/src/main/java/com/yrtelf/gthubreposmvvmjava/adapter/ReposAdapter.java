package com.yrtelf.gthubreposmvvmjava.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.yrtelf.gthubreposmvvmjava.model.RepoResource;
import com.yrtelf.gthubreposmvvmjava.viewmodel.GithubReposViewModel;
import com.yrtelf.gthubreposmvvmjava.BR;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder>  {

    private int layoutId;
    private List<RepoResource> repoResources;
    private GithubReposViewModel viewModel;

    public ReposAdapter(@LayoutRes int layoutId, GithubReposViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return repoResources == null ? 0 : repoResources.size();
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setRepoResources(List<RepoResource> repoResources) {
        this.repoResources = repoResources;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(GithubReposViewModel viewModel, Integer position) {
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }

}
