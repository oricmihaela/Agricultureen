package com.example.lv1.agri;

import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable {


    //login/signup details
    private String mail;
    private String password;

    public UserData(String mail, String password) {
        this.mail = mail;
        this.password = password;
        Creator creator = new Creator() {
            @Override
            public Object createFromParcel(Parcel source) {
                return null;
            }

            @Override
            public Object[] newArray(int size) {
                return new Object[0];
            }
        };
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
