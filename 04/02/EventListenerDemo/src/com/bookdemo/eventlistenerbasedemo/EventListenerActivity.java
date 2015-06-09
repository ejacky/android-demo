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
		// 一个按钮组件，在此为事件源
		btn_event = (Button) findViewById(R.id.btnEvent);
		btn_event.setOnClickListener(click);
	}
		
	// 点击事件的事件监听器
	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// 点击事件的事件处理器
			Toast.makeText(EventListenerActivity.this, "按钮被点击了", Toast.LENGTH_SHORT)
					.show();
		}
	};
}
