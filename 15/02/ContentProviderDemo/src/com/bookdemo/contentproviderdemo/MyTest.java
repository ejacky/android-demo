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
	 * ��Person���в���һ������
	 */
	public void insert() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");

		ContentValues values = new ContentValues();
		values.put("name", "Demo");
		values.put("address", "HK");
		Uri returnuir = contentResolver.insert(uri, values);
		Log.i(TAG, "JUnit-->>�������ݳɹ������ص�Uri��" + returnuir.toString());
	}

	/**
	 * ��Person����ɾ��һ������
	 */
	public void delete() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person/2");
		int resultCount = contentResolver.delete(uri, null, null);
		Log.i(TAG, "JUnit-->>ɾ�����ݳɹ�����Ӧ������" + resultCount);
	}

	/**
	 * ��Person����ɾ����������������
	 */
	public void deletes() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");
		String where = "address=?";
		String[] where_args = { "HK" };
		int resultCount = contentResolver.delete(uri, where, where_args);
		Log.i(TAG, "JUnit-->>ɾ�����ݳɹ�����Ӧ������" + resultCount);
	}

	/**
	 * ��Person���и���һ����������������
	 */
	public void update() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person/2");
		ContentValues values = new ContentValues();
		values.put("name", "����");
		values.put("address", "�Ϻ�");
		int resultCount = contentResolver.update(uri, values, null, null);
		Log.i(TAG, "JUnit-->>�������ݳɹ�����Ӧ������" + resultCount);
	}

	/**
	 * ��Person����·�����������������
	 */
	public void updates() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");
		ContentValues values = new ContentValues();
		values.put("name", "����");
		values.put("address", "����");
		String where = "address=?";
		String[] where_args = { "beijing" };
		int resultCount = contentResolver
				.update(uri, values, where, where_args);
		Log.i(TAG, "JUnit-->>�������ݳɹ�����Ӧ������" + resultCount);
	}

	/**
	 * ��Person���ѯ����
	 */
	public void query() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person/2");
		Cursor cursor = contentResolver.query(uri, null, null, null, null);
		while (cursor.moveToNext()) {
			Log.i(TAG,
					"JUnit-->>��ѯ���ݳɹ���"
							+ cursor.getString(cursor.getColumnIndex("name"))
							+ "");
		}
	}

	/**
	 * ��Person���ѯ��������������
	 */
	public void querys() {
		ContentResolver contentResolver = getContext().getContentResolver();
		Uri uri = Uri
				.parse("content://com.bookdemo.contentproviderdemo.PersonProvider/person");
		String where = "address=?";
		String[] where_args = { "����" };
		Cursor cursor = contentResolver.query(uri, null, where, where_args,
				null);
		while (cursor.moveToNext()) {
			Log.i(TAG,
					"JUnit-->>��ѯ���ݳɹ���"
							+ cursor.getString(cursor.getColumnIndex("name"))
							+ "");
		}
	}
}
