package com.bookdemo.loadermanagerdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

public class MyTest extends AndroidTestCase {

	public MyTest() {
	}
	
	public void add(){
		ContentResolver contentResolver=getContext().getContentResolver();
		ContentValues values=new ContentValues();
		values.put("name", "Tim");
		Uri url=Uri.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
		contentResolver.insert(url, values);
	}
	
	public void delete(){
		ContentResolver contentResolver=getContext().getContentResolver();
		Uri url=Uri.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student/1");
		contentResolver.delete(url, null, null);		
	}
	
	public void query(){
		ContentResolver contentResolver=getContext().getContentResolver();
		ContentValues values=new ContentValues();
		values.put("name", "Tim");
		Uri url=Uri.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
		Cursor cursor=contentResolver.query(url, null, null, null, null);
		while(cursor.moveToNext()){
			Log.i("main", "---->>"+cursor.getString(cursor.getColumnIndex("name")));
			
		}
	}
}
