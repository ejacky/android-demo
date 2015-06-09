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
		//�������URIɸѡ
		URI_MATCHER.addURI("com.bookdemo.contentproviderdemo.PersonProvider",
				"person", PERSONS);
		//ʹ��ͨ���#��ƥ����������
		URI_MATCHER.addURI("com.bookdemo.contentproviderdemo.PersonProvider",
				"person/#", PERSON);	
	}

	public PersonProvider() {

	}	

	@Override
	public boolean onCreate() {
		// ��ʼ��һ�����ݳ־ò�
		personDAO = new PersonDAO(getContext());
		return true;
	}
	
	/**
	 * ��������
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Uri resultUri = null;
		//����Uri������Code
		int flag = URI_MATCHER.match(uri);
		if (flag == PERSONS) {
			long id = personDAO.insertPerson(values);
			Log.i(TAG, "ContentProvider-->>����ɹ�, id="+id);
			resultUri = ContentUris.withAppendedId(uri, id);
		}
		return resultUri;
	}

	/**
	 * ɾ������
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int count = -1;
		try {
			int flag = URI_MATCHER.match(uri);
			switch (flag) {
			case PERSON:
				// delete from student where id=?
				//�������ݣ�ʹ��ContentUris�������������β��Id
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
		Log.i(TAG, "ContentProvider-->>ɾ���ɹ�����Ӧ������"+count);
		return count;
	}

	/**
	 * ��������
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
		Log.i(TAG, "ContentProvider-->>���³ɹ�����Ӧ������"+count);
		return count;
	}

	/**
	 * ��ѯ����
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
		Log.i(TAG, "ContentProvider-->>��ѯ�ɹ�����Ӧ������"+cursor.getCount());
		return cursor;
	}


	@Override
	public String getType(Uri uri) {
		int flag = URI_MATCHER.match(uri);
		String type = null;
		switch (flag) {
		case PERSON:
			type = "vnd.android.cursor.item/person";
			Log.i(TAG, "ContentProvider-->>getType���أ�vnd.android.cursor.item/person");
			break;
		case PERSONS:
			type = "vnd.android.cursor.dir/persons";
			Log.i(TAG, "ContentProvider-->>getType���أ�vnd.android.cursor.dir/persons");
			break;
		}
		return type;
	}
}
