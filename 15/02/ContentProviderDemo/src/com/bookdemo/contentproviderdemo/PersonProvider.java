package com.bookdemo.contentproviderdemo;

import com.bookdemo.dao.PersonDAO;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class PersonProvider extends ContentProvider {

	private final String TAG = "main";
	private PersonDAO personDAO = null;
	private static final UriMatcher URI_MATCHER = new UriMatcher(
			UriMatcher.NO_MATCH);
	private static final int PERSON = 1;
	private static final int PERSONS = 2;
	static {
		//添加两个URI筛选
		URI_MATCHER.addURI("com.bookdemo.contentproviderdemo.PersonProvider",
				"person", PERSONS);
		//使用通配符#，匹配任意数字
		URI_MATCHER.addURI("com.bookdemo.contentproviderdemo.PersonProvider",
				"person/#", PERSON);	
	}

	public PersonProvider() {

	}	

	@Override
	public boolean onCreate() {
		// 初始化一个数据持久层
		personDAO = new PersonDAO(getContext());
		return true;
	}
	
	/**
	 * 插入数据
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Uri resultUri = null;
		//解析Uri，返回Code
		int flag = URI_MATCHER.match(uri);
		if (flag == PERSONS) {
			long id = personDAO.insertPerson(values);
			Log.i(TAG, "ContentProvider-->>插入成功, id="+id);
			resultUri = ContentUris.withAppendedId(uri, id);
		}
		return resultUri;
	}

	/**
	 * 删除数据
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int count = -1;
		try {
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case PERSON:
				// delete from student where id=?
				//单条数据，使用ContentUris工具类解析出结尾的Id
				long id = ContentUris.parseId(uri);
				String where_value = "id = ?";
				String[] args = { String.valueOf(id) };
				count = personDAO.deletePerson(where_value, args);
				break;
			case PERSONS:
				count = personDAO.deletePerson(selection, selectionArgs);				
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.i(TAG, "ContentProvider-->>删除成功，响应行数："+count);
		return count;
	}

	/**
	 * 更新数据
	 */
	@Override	
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count = -1;
		try {			
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case PERSON:
				long id = ContentUris.parseId(uri);
				String where_value = " id = ?";
				String[] args = { String.valueOf(id) };
				count = personDAO.updatePerson(values, where_value, args);
				break;
			case PERSONS:
				count = personDAO.updatePerson(values, selection,
						selectionArgs);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.i(TAG, "ContentProvider-->>更新成功，响应行数："+count);
		return count;
	}

	/**
	 * 查询数据
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
		try {
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case PERSON:
				long id = ContentUris.parseId(uri);
				String where_value = " id = ?";
				String[] args = { String.valueOf(id) };
				cursor = personDAO.queryPersons(where_value, args);
				break;
			case PERSONS:
				cursor = personDAO.queryPersons(selection, selectionArgs);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.i(TAG, "ContentProvider-->>查询成功，响应行数："+cursor.getCount());
		return cursor;
	}


	@Override
	public String getType(Uri uri) {
		int flag = URI_MATCHER.match(uri);
		String type = null;
		switch (flag) {
		case PERSON:
			type = "vnd.android.cursor.item/person";
			Log.i(TAG, "ContentProvider-->>getType返回：vnd.android.cursor.item/person");
			break;
		case PERSONS:
			type = "vnd.android.cursor.dir/persons";
			Log.i(TAG, "ContentProvider-->>getType返回：vnd.android.cursor.dir/persons");
			break;
		}
		return type;
	}
}
