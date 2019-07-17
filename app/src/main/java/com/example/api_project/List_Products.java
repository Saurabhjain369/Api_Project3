package com.example.api_project;

import android.os.Parcel;
import android.os.Parcelable;

public class List_Products implements Parcelable {
    String name;
    String id;
    String ownerdetails;
    String link;
    String pimg;
    String followers;
    String following;
    String cont;

    public List_Products(String name, String id, String ownerdetails, String link, String pimg, String followers, String following, String cont) {
        this.name = name;
        this.id = id;
        this.ownerdetails = ownerdetails;
        this.link = link;
        this.pimg = pimg;
        this.followers = followers;
        this.following = following;
        this.cont = cont;
    }


    protected List_Products(Parcel in) {

        name = in.readString();
        id = in.readString();
        ownerdetails = in.readString();
        link=in.readString();
        pimg=in.readString();
        followers=in.readString();
        following=in.readString();
        cont=in.readString();




    }

    public static final Creator<List_Products> CREATOR = new Creator<List_Products>() {
        @Override
        public List_Products createFromParcel(Parcel in) {
            return new List_Products(in);
        }

        @Override
        public List_Products[] newArray(int size) {
            return new List_Products[size];
        }
    };

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getId() {
        return id;
    }

    public String getOwnerdetails() {
        return ownerdetails;
    }

    public String getname()
    {
        return name;
    }

    public void setname(String name)
    {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwnerdetails(String ownerdetails) {
        this.ownerdetails = ownerdetails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(ownerdetails);
        dest.writeString(link);
        dest.writeString(pimg);
        dest.writeString(followers);
        dest.writeString(following);

        dest.writeString(cont);

    }
}

