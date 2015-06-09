package com.bookdemo.eventlistenerbasedemo;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ButtonClickListener implements OnClickListener {
	private Context context;
	public ButtonClickListener(Context context) {
		// 保存上下文对象
		this.context=context;
	}

	@Override
	public void onClick(View v) {
		// 实现View.OnClickListener 点击事件监听器
		switch (v.getId()) {
		case R.id.btnClick1:
			Toast.makeText(context, "点击了按钮1",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnClick2:
			Toast.makeText(context, "点击了按钮2",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}
