package com.yrtelf.gthubreposmvvmjava.model;

import android.text.TextUtils;

public class RepoResource {

    private String name;
    private String stargazers_count;
    private boolean has_star;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(String stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public boolean isHas_star() {
        if(TextUtils.equals(stargazers_count,"0")){
            return false;
        }
        return true;
    }

    public void setHas_star(boolean has_star) {
        this.has_star = has_star;
    }
}
