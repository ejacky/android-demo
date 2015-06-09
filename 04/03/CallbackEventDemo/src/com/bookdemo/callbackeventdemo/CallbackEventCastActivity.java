package com.bookdemo.callbackeventdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CallbackEventCastActivity extends Activity {
	private TouchButton touchButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		
		touchButton=(TouchButton) findViewById(R.id.touchButton);
		
		touchButton.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					Log.i("main", "TouchButton�Ļ����¼�������������OnTouch������");
				}				
				return 	false;
			}
		});
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i("main", "Activity��ӦOnTouch�¼�");
		}			
		return super.onTouchEvent(event);
	}
}
