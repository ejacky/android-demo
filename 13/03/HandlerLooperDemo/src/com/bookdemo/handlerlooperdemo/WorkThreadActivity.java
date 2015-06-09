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
		
		// ��UI�߳��п���һ�������߳�
		new Thread(new Runnable() {			
			@Override
			public void run() {
				// �ڹ����߳��г�ʼ��һ��Looper����
				Looper.prepare();
				handler=new Handler(){
					@Override
					public void handleMessage(Message msg) {
						super.handleMessage(msg);
						// ��UI�̷߳���������Ϣ��ʾ����Ļ�ϡ�
						Log.i("main", "what="+msg.what+","+msg.obj);
						Toast.makeText(WorkThreadActivity.this, "what="+msg.what+","+msg.obj, Toast.LENGTH_SHORT).show();
					}
				};	
				// �Ѹղų�ʼ����Looper��������������ѭ����Ϣ���е���Ϣ
				Looper.loop();
			}
		}).start();
		
		btnSendToWorkUI=(Button)findViewById(R.id.btnSendToWorkUI);
		
		btnSendToWorkUI.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// onClick������������UI�߳��ϵ� 
				Message msg=Message.obtain();
				msg.what=1;
				msg.obj="�����߳��з�����Ϣ��";
				// �����߳��з�����Ϣ
				handler.sendMessage(msg);
			}
		});
	}	
}
