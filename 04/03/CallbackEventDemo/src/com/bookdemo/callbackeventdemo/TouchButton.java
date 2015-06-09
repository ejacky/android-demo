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
		// ��дButton�ϵĴ����¼�
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i("main", "TouchButton��Ӧ��OnTouch�¼�");
			Toast.makeText(context, "�������˰�ť", Toast.LENGTH_SHORT).show();
		}
		return false;
	}
}
