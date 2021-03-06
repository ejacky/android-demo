package com.bookdemo.aidlservicecustdemo.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class User implements Parcelable {

	private final static String TAG = "main";
	private int id;
	private String username;
	private String password;

	public User() {
		super();
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {

		User us = (User) o;
		if (this.username.equals(us.username)
				&& this.password.equals(us.password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		Log.i(TAG, "Service：User被序列化----用户：" + username);
		dest.writeInt(id);
		dest.writeString(username);
		dest.writeString(password);
	}

	public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}

		@Override
		public User createFromParcel(Parcel source) {
			User user = new User(source.readInt(), source.readString(),
					source.readString());
			Log.i(TAG, "Service：User被反序列化----用户：" + user.username);
			return user;
		}
	};
}
