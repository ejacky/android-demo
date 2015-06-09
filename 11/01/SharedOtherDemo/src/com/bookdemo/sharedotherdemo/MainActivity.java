package com.bookdemo.sharedotherdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnWrite, btnRead;
	private EditText etName, etAge, etHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etName = (EditText) findViewById(R.id.etName);
		etAge = (EditText) findViewById(R.id.etAge);
		etHeight = (EditText) findViewById(R.id.etHeight);

		btnWrite = (Button) findViewById(R.id.btnWrite);
		btnRead = (Button) findViewById(R.id.btnRead);

		btnWrite.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					// 得到页面控件的输入值
					String name = etName.getText().toString();
					int age = Integer.parseInt(etAge.getText().toString());
					float height = Float.parseFloat(etHeight.getText()
							.toString());
					// 获取目标包下的Context
					Context targetContext = createPackageContext(
							"com.bookdemo.sharedpreferencesdemo",
							CONTEXT_IGNORE_SECURITY);
					// 获取SharedPreferences对象
					SharedPreferences preferences = targetContext
							.getSharedPreferences("userInfo",
									MODE_WORLD_WRITEABLE);
					// 获取Editor对象
					Editor editor = preferences.edit();
					editor.putString("name", name);
					editor.putInt("age", age);
					editor.putFloat("height", height);
					// 提交数据
					editor.commit();
					Toast.makeText(getApplicationContext(), "写入成功",
							Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnRead.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					// 获取目标包下的Context
					Context targetContext = createPackageContext(
							"com.bookdemo.sharedpreferencesdemo",
							CONTEXT_IGNORE_SECURITY);
					// 获取SharedPreferences对象
					SharedPreferences preferences = targetContext
							.getSharedPreferences("userInfo", MODE_WORLD_WRITEABLE);
					// 读取数据
					String name = preferences.getString("name", "");
					int age = preferences.getInt("age", -1);
					float height = preferences.getFloat("height", -1);
					// 显示读取的数据
					Toast.makeText(getApplicationContext(),
							"name:" + name + "\nage:" + age + "\nheight:" + height,
							Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
