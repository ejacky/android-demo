package com.bookdemo.jsonparser;

import java.util.List;
import java.util.Map;

import com.bookdemo.domain.Person;
import com.bookdemo.http.HttpUtils;
import com.bookdemo.jsonUtils.JsonTools;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JsonParserActivity extends Activity implements OnClickListener {

	private String path_url = "http://192.168.1.109:8888/bookdemo/returnJson?JsonData=";
	private Button person, personList, stringList, dicList;
	private String path = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		person = (Button) findViewById(R.id.person);
		personList = (Button) findViewById(R.id.personList);
		stringList = (Button) findViewById(R.id.stringList);
		dicList = (Button) findViewById(R.id.dicList);
		person.setOnClickListener(this);
		personList.setOnClickListener(this);
		stringList.setOnClickListener(this);
		dicList.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.person:
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					// 解析Person对象的Json数据
					path = path_url + "Person";
					String jsonString = HttpUtils.getJsonContent(path);
					Person person = JsonTools.getPerson(jsonString);
					Log.i("main", person.toString());
				}
			});
			thread.start();
			break;
		case R.id.personList:
			Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					// 解析List<Person>对象的Json数据
					path = path_url + "PersonList";
					String jsonString = HttpUtils.getJsonContent(path);
					List<Person> persons = JsonTools.getPersonList(jsonString);
					for(Person p:persons)
					{
						Log.i("main",  p.toString());
					}					
				}
			});
			thread1.start();
			break;
		case R.id.stringList:
			Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					// 解析List<String>对象的Json数据
					path = path_url + "StringList";
					String jsonString = HttpUtils.getJsonContent(path);
					List<String> strings = JsonTools.getStringList(jsonString);
					for(String s:strings)
					{
						Log.i("main",  s);
					}					
				}
			});
			thread2.start();
			break;
		case R.id.dicList:
			Thread thread3 = new Thread(new Runnable() {
				@Override
				public void run() {
					// 解析List<Map<String, Object>>对象的Json数据
					path = path_url + "DicList";
					String jsonString = HttpUtils.getJsonContent(path);
					List<Map<String, Object>> maps = JsonTools.getMapList(jsonString);
					for(Map<String, Object> m:maps)
					{
						Log.i("main",  m.toString());
					}					
				}
			});
			thread3.start();
			break;
		}
	}
}
