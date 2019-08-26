package com.yrtelf.gthubreposmvvmjava.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OwnerResource implements Parcelable {

    private String login;
    private String avatar_url;


    protected OwnerResource(Parcel in) {
        login = in.readString();
        avatar_url = in.readString();
    }

    public static final Creator<OwnerResource> CREATOR = new Creator<OwnerResource>() {
        @Override
        public OwnerResource createFromParcel(Parcel in) {
            return new OwnerResource(in);
        }

        @Override
        public OwnerResource[] newArray(int size) {
            return new OwnerResource[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(avatar_url);
    }
}
