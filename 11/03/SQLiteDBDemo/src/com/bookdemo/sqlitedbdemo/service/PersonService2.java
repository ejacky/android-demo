package com.bookdemo.sqlitedbdemo.service;

import java.util.List;
import java.util.Map;

import android.content.ContentValues;

public interface PersonService2 {

	public boolean addPerson(ContentValues values);

	public boolean deletePerson(String whereClause, String[] whereArgs);

	public boolean updatePerson(ContentValues values, String whereClause,
			String[] whereArgs);

	public Map<String, String> viewPerson(String selection,
			String[] selectionArgs);

	public List<Map<String, String>> listPersonMaps(String selection,
			String[] selectionArgs);
}
