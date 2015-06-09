package com.bookdemo.callbackeventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

public class TouchButton extends Button {
	private Context context;

	public TouchButton(Context context , AttributeSet set) {
		super(context,set);
		this.context = context;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// 重写Button上的触摸事件
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i("main", "TouchButton响应了OnTouch事件");
			Toast.makeText(context, "您触摸了按钮", Toast.LENGTH_SHORT).show();
		}
		return false;
	}
}
