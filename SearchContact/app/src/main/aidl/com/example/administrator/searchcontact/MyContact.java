package com.example.administrator.searchcontact;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/11/6 0006.
 */

public class MyContact implements Parcelable {
    public String Name;
    public String Phone;

    public MyContact(){}
    public MyContact(String name , String phone)
    {
        Name = name;
        Phone = phone;
    }
    protected MyContact(Parcel in)
    {
        Name = in.readString();
        Phone = in.readString();
    }

    public static final Creator<MyContact> CREATOR = new Creator<MyContact>()
    {
        @Override
        public MyContact createFromParcel(Parcel in)
        {
            return new MyContact(in);
        }

        @Override
        public MyContact[] newArray(int size)
        {
            return new MyContact[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(Name);
        dest.writeString(Phone);
    }
}
