package com.yrtelf.gthubreposmvvmjava.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class RepoResource implements Parcelable {

    private String name;
    private String stargazers_count;
    private boolean has_star;
    private OwnerResource owner;
    private String open_issues_count;


    protected RepoResource(Parcel in) {
        name = in.readString();
        stargazers_count = in.readString();
        open_issues_count = in.readString();
        has_star = in.readByte() != 0;
        owner = in.readParcelable(OwnerResource.class.getClassLoader());
    }

    public static final Creator<RepoResource> CREATOR = new Creator<RepoResource>() {
        @Override
        public RepoResource createFromParcel(Parcel in) {
            return new RepoResource(in);
        }

        @Override
        public RepoResource[] newArray(int size) {
            return new RepoResource[size];
        }
    };

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


    public OwnerResource getOwnerResource() {
        return owner;
    }

    public void setOwnerResource(OwnerResource ownerResource) {
        this.owner = ownerResource;
    }

    public String getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(String open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(stargazers_count);
        dest.writeString(open_issues_count);
        dest.writeByte((byte) (has_star ? 1 : 0));
        dest.writeParcelable(this.owner,flags);
    }
}
