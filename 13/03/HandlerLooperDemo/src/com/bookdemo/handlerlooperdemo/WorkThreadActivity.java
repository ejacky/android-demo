package com.bookdemo.handlerlooperdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WorkThreadActivity extends Activity {
	private Button btnSendToWorkUI;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.looper_activity2);
		
		// 在UI线程中开启一个工作线程
		new Thread(new Runnable() {			
			@Override
			public void run() {
				// 在工作线程中初始化一个Looper对象
				Looper.prepare();
				handler=new Handler(){
					@Override
					public void handleMessage(Message msg) {
						super.handleMessage(msg);
						// 把UI线程发送来的消息显示到屏幕上。
						Log.i("main", "what="+msg.what+","+msg.obj);
						Toast.makeText(WorkThreadActivity.this, "what="+msg.what+","+msg.obj, Toast.LENGTH_SHORT).show();
					}
				};	
				// 把刚才初始化的Looper对象运行起来，循环消息队列的消息
				Looper.loop();
			}
		}).start();
		
		btnSendToWorkUI=(Button)findViewById(R.id.btnSendToWorkUI);
		
		btnSendToWorkUI.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// onClick方法是运行在UI线程上的 
				Message msg=Message.obtain();
				msg.what=1;
				msg.obj="向子线程中发送消息！";
				// 向工作线程中发送消息
				handler.sendMessage(msg);
			}
		});
	}	
}
