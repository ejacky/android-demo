package com.bookdemo.sqlitedbdemo.db;

import java.util.List;
import java.util.Map;

import com.bookdemo.sqlitedbdemo.dao.PersonDao;
import com.bookdemo.sqlitedbdemo.service.PersonService;

import android.test.AndroidTestCase;
import android.util.Log;

public class TestDb extends AndroidTestCase {
	private final String TAG = "main";

	public TestDb() {
		// TODO Auto-generated constructor stub
	}

	public void createDB() {
		DbOpenHelper helper = new DbOpenHelper(getContext());
		helper.getWritableDatabase();
	}

	public void insertDb() {
		PersonService service = new PersonDao(getContext());
		Object[] params1 = { "张龙", "beijing", "male" };
		boolean flag = service.addPerson(params1);
		Object[] params2 = { "赵虎", "shanghai", "male" };
		flag = flag&&service.addPerson(params2);
		Object[] params3 = { "王朝", "HK", "male" };
		flag = flag&&service.addPerson(params3);
		Object[] params4 = { "马汉", "beijing", "female" };
		flag = flag&&service.addPerson(params4);
		Log.i(TAG, "-----插入数据----->>" + flag);
	}

	public void deleteDb() {
		PersonService service = new PersonDao(getContext());
		Object[] params = { 1 };
		boolean flag = service.deletePerson(params);
		Log.i(TAG, "-----删除数据----->>" + flag);
	}

	public void updateDb() {
		PersonService service=new PersonDao(getContext());
		Object[] params = { "张三", "上海", "男","2" };
		boolean flag=service.updatePerson(params);
		Log.i(TAG, "---------->>" + flag);
	}
	
	public void getDb(){
		PersonService service=new PersonDao(getContext());
		Map<String, String> map = service.viewPerson(new String[]{"2"});
		Log.i(TAG, "---------->>" + map.toString());
	}
	
	public void listDb() {
		PersonService service = new PersonDao(getContext());
		List<Map<String, String>> list = service.listPersonMaps(null);
		Log.i(TAG, "---------->>" + list.toString());
	}
}
