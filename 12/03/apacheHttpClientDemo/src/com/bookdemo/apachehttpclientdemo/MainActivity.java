package com.bookdemo.apachehttpclientdemo;

import com.bookdemo.httpUtils.AndroidHttpClientUtils;
import com.bookdemo.httpUtils.httpClientUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {

	private Button btnLogin,btnAndroidHttpClient;
	 
	private EditText username,password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLogin=(Button)findViewById(R.id.btnLogin);
		username=(EditText)findViewById(R.id.editText1);
		password=(EditText)findViewById(R.id.editText2);
		
		
		 btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String un=username.getText().toString();
				String pw=password.getText().toString();
				// 重新开启一条工作线程完成登录操作
				new Thread(new httpClientUtils(un,pw)).start();
			}
		});
		 
		 btnAndroidHttpClient=(Button)findViewById(R.id.btnAndrodHttpClient);
		 btnAndroidHttpClient.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String un=username.getText().toString();
				String pw=password.getText().toString();				
				// 重新开启一条工作线程完成登录操作
				new Thread(new AndroidHttpClientUtils(un,pw)).start();
			}
		});	
	}
}
