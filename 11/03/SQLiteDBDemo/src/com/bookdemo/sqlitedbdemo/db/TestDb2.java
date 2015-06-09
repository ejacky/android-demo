package com.bookdemo.sqlitedbdemo.db;

import java.util.List;
import java.util.Map;

import com.bookdemo.sqlitedbdemo.dao.PersonDao2;
import com.bookdemo.sqlitedbdemo.service.PersonService2;

import android.content.ContentValues;
import android.test.AndroidTestCase;
import android.util.Log;

public class TestDb2 extends AndroidTestCase {
	private final String TAG = "main";

	public TestDb2() {
		// TODO Auto-generated constructor stub
	}

	public void addPerson() {
		PersonService2 service2 = new PersonDao2(getContext());
		ContentValues values1 = new ContentValues();
		values1.put("name", "张龙");
		values1.put("address", "beijing");
		values1.put("sex", "male");
		boolean flag = service2.addPerson(values1);
		ContentValues values2 = new ContentValues();
		values2.put("name", "赵虎");
		values2.put("address", "shanghai");
		values2.put("sex", "male");
		flag = flag&&service2.addPerson(values2);
		ContentValues values3 = new ContentValues();
		values3.put("name", "王朝");
		values3.put("address", "HK");
		values3.put("sex", "male");
		flag = flag&&service2.addPerson(values3);
		ContentValues values4 = new ContentValues();
		values4.put("name", "王朝");
		values4.put("address", "HK");
		values4.put("sex", "male");
		flag = flag&&service2.addPerson(values4);
		Log.i(TAG, "----------->>" + flag);
	}
	
	public void deletePerson() {
		PersonService2 service2 = new PersonDao2(getContext());
		boolean flag = service2.deletePerson(" id =?", new String[]{"1"});
		Log.i(TAG, "----------->>" + flag);
	}
	
	public void updatePerson(){
		PersonService2 service2 = new PersonDao2(getContext());
		ContentValues values = new ContentValues();
		values.put("name", "张三"); 
		values.put("address", "上海");
		values.put("sex", "男");
		boolean flag=service2.updatePerson(values, " id=? ", new String[]{"2"});
		Log.i(TAG, "----------->>" + flag);
	}
	
	public void viewPerson(){
		PersonService2 service2 = new PersonDao2(getContext());
		Map<String, String> map=service2.viewPerson(" id=? ", new String[]{"2"});
		Log.i(TAG, "----------->>" + map.toString());
	}
	public void listPerson(){
		PersonService2 service2 = new PersonDao2(getContext());
		List<Map<String, String>> list=service2.listPersonMaps(null,null);
		Log.i(TAG, "----------->>" + list.toString());
	}
}
