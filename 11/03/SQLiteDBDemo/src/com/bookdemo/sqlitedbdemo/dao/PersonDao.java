package com.bookdemo.sqlitedbdemo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bookdemo.sqlitedbdemo.db.DbOpenHelper;
import com.bookdemo.sqlitedbdemo.service.PersonService;

public class PersonDao implements PersonService {
	private DbOpenHelper helper = null;

	public PersonDao(Context context) {
		helper = new DbOpenHelper(context);
	}

	@Override
	public boolean addPerson(Object[] params) {
		boolean flag = false;
		SQLiteDatabase database = null;
		try {
			// insert一条数据
			String sql = "insert into person(name,address,sex) values(?,?,?)";
			database = helper.getWritableDatabase();
			// 执行SQL
			database.execSQL(sql, params);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				// finally中关闭数据库
				database.close();
			}
		}
		return flag;
	}

	@Override
	public boolean deletePerson(Object[] params) {
		boolean flag = false;
		SQLiteDatabase database = null;
		try {
			// 删除一条数据
			String sql = "delete from person where id=?";
			database = helper.getWritableDatabase();
			database.execSQL(sql, params);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public boolean updatePerson(Object[] params) {
		boolean flag = false;
		SQLiteDatabase database = null;
		try {
			// 更新一条数据
			String sql = "update person set name=?,address=?,sex=? where id=?";
			database = helper.getWritableDatabase();
			// 执行SQL
			database.execSQL(sql, params);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public Map<String, String> viewPerson(String[] selectionArgs) {
		Map<String, String> map = new HashMap<String, String>();
		SQLiteDatabase database = null;
		try {
			// 查询单条记录
			String sql = "select * from person where id=?";
			// 以只读的形式打开数据库
			database = helper.getReadableDatabase();
			// 执行SQL语句，返回一个游标
			Cursor cursor = database.rawQuery(sql, selectionArgs);

			int colums = cursor.getColumnCount();
			while (cursor.moveToNext()) {
				for (int i = 0; i < colums; i++) {
					String cols_name = cursor.getColumnName(i);
					String cols_value = cursor.getString(cursor
							.getColumnIndex(cols_name));
					if (cols_value == null) {
						cols_value = "";
					}
					map.put(cols_name, cols_value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return map;
	}

	@Override
	public List<Map<String, String>> listPersonMaps(String[] selectionArgs) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String sql = "select * from person";
		SQLiteDatabase database = null;
		try {
			database = helper.getReadableDatabase();
			Cursor cursor = database.rawQuery(sql, selectionArgs);
			int colums = cursor.getColumnCount();
			while (cursor.moveToNext()) {
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 0; i < colums; i++) {
					String cols_name = cursor.getColumnName(i);
					String cols_value = cursor.getString(cursor
							.getColumnIndex(cols_name));
					if (cols_value == null) {
						cols_value = "";
					}
					map.put(cols_name, cols_value);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return list;
	}
}
