package com.bookdemo.eventlistenerbasedemo;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ButtonClickListener implements OnClickListener {
	private Context context;
	public ButtonClickListener(Context context) {
		// ���������Ķ���
		this.context=context;
	}

	@Override
	public void onClick(View v) {
		// ʵ��View.OnClickListener ����¼�������
		switch (v.getId()) {
		case R.id.btnClick1:
			Toast.makeText(context, "����˰�ť1",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnClick2:
			Toast.makeText(context, "����˰�ť2",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}
