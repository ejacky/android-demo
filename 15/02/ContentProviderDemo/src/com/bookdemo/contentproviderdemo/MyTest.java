package com.bookdemo.contentproviderdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.test.AndroidTestCase;
import android.util.Log;

public class MyTest extends AndroidTestCase {
	private final static String TAG = "main";

	public MyTest() {

	}

	/**
	 * 向Person表中插入一条数据
	 */
	public void insert() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");

		ContentValues values = new ContentValues();
		values.put("name", "Demo");
		values.put("address", "HK");
		Uri returnuir = contentResolver.insert(uri, values);
		Log.i(TAG, "JUnit-->>插入数据成功，返回的Uri：" + returnuir.toString());
	}

	/**
	 * 从Person表中删除一条数据
	 */
	public void delete() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person/2");
		int resultCount = contentResolver.delete(uri, null, null);
		Log.i(TAG, "JUnit-->>删除数据成功，响应行数：" + resultCount);
	}

	/**
	 * 从Person表中删除符合条件的数据
	 */
	public void deletes() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");
		String where = "address=?";
		String[] where_args = { "HK" };
		int resultCount = contentResolver.delete(uri, where, where_args);
		Log.i(TAG, "JUnit-->>删除数据成功，响应行数：" + resultCount);
	}

	/**
	 * 从Person表中更新一条符合条件的数据
	 */
	public void update() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person/2");
		ContentValues values = new ContentValues();
		values.put("name", "李四");
		values.put("address", "上海");
		int resultCount = contentResolver.update(uri, values, null, null);
		Log.i(TAG, "JUnit-->>更新数据成功，响应行数：" + resultCount);
	}

	/**
	 * 从Person表更新符合条件的所有数据
	 */
	public void updates() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");
		ContentValues values = new ContentValues();
		values.put("name", "王五");
		values.put("address", "深圳");
		String where = "address=?";
		String[] where_args = { "beijing" };
		int resultCount = contentResolver
				.update(uri, values, where, where_args);
		Log.i(TAG, "JUnit-->>更新数据成功，响应行数：" + resultCount);
	}

	/**
	 * 从Person表查询数据
	 */
	public void query() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person/2");
		Cursor cursor = contentResolver.query(uri, null, null, null, null);
		while (cursor.moveToNext()) {
			Log.i(TAG,
					"JUnit-->>查询数据成功："
							+ cursor.getString(cursor.getColumnIndex("name"))
							+ "");
		}
	}

	/**
	 * 从Person表查询符合条件的数据
	 */
	public void querys() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");
		String where = "address=?";
		String[] where_args = { "深圳" };
		Cursor cursor = contentResolver.query(uri, null, where, where_args,
				null);
		while (cursor.moveToNext()) {
			Log.i(TAG,
					"JUnit-->>查询数据成功："
							+ cursor.getString(cursor.getColumnIndex("name"))
							+ "");
		}
	}
}
