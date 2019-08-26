package com.yrtelf.gthubreposmvvmjava.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {

    private ObservableField<String> avatarUrl = new ObservableField<>();
    private ObservableField<String> ownerName = new ObservableField<>();
    private ObservableField<String> repoName = new ObservableField<>();
    private ObservableField<String> openIssueCount = new ObservableField<>();
    private ObservableField<String> starCount = new ObservableField<>();

    public ObservableField<String> getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl.set(avatarUrl);
    }

    public ObservableField<String> getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName.set(ownerName);
    }

    public ObservableField<String> getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName.set(repoName);
    }

    public ObservableField<String> getOpenIssueCount() {
        return openIssueCount;
    }

    public void setOpenIssueCount(String openIssueCount) {
        this.openIssueCount.set(openIssueCount);
    }

    public ObservableField<String> getStarCount() {
        return starCount;
    }

    public void setStarCount(String starCount) {
        this.starCount.set(starCount);
    }
}
