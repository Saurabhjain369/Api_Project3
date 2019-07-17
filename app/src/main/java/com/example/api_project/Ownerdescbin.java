package com.example.api_project;

import android.os.Parcel;
import android.os.Parcelable;

public class Ownerdescbin implements Parcelable {

    String pimg;
    String oname;
    String followers;
    String following;
    String publicrepo;
    String publicrepolink;

    public Ownerdescbin(String pimg, String oname, String followers, String following, String publicrepo, String publicrepolink) {
        this.pimg = pimg;
        this.oname = oname;
        this.followers = followers;
        this.following = following;
        this.publicrepo = publicrepo;
        this.publicrepolink = publicrepolink;
    }


    public static final Creator<Ownerdescbin> CREATOR = new Creator<Ownerdescbin>() {
        @Override
        public Ownerdescbin createFromParcel(Parcel in) { return new Ownerdescbin(in);
        }

        @Override
        public Ownerdescbin[] newArray(int size) {
            return new Ownerdescbin[size];
        }
    };

    public Ownerdescbin(Parcel in) {
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

    public String getPublicrepo() {
        return publicrepo;
    }

    public void setPublicrepo(String publicrepo) {
        this.publicrepo = publicrepo;
    }

    public String getPublicrepolink() {
        return publicrepolink;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public static Creator<Ownerdescbin> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(pimg);
        parcel.writeString(oname);
        parcel.writeString(followers);
        parcel.writeString(following);
        parcel.writeString(publicrepo);
        parcel.writeString(publicrepolink);


    }

    public void setPublicrepolink(String publicrepolink) {
        this.publicrepolink = publicrepolink;
    }




}
