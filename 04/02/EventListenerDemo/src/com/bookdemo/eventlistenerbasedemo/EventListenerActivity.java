package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventListenerActivity extends Activity {
	private Button btn_event;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eventlistener);
		// һ����ť������ڴ�Ϊ�¼�Դ
		btn_event = (Button) findViewById(R.id.btnEvent);
		btn_event.setOnClickListener(click);
	}
		
	// ����¼����¼�������
	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// ����¼����¼�������
			Toast.makeText(EventListenerActivity.this, "��ť�������", Toast.LENGTH_SHORT)
					.show();
		}
	};
}
