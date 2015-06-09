package com.bookdemo.sqlitedbdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {
	private static String name = "mydb.db";
	private static int version = 1;

	public DbOpenHelper(Context context) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 创建person表
		String sql = "create table person(id integer primary key autoincrement,name varchar(64),address varchar(64),sex varchar(8))";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 为person表添加年龄字段age
//		String sql="alter table person add age integer";
//		db.execSQL(sql);
	}
}
