package com.bookdemo.xmlfiledefinelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {
	private TextView tv_show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ΪActivityָ��������ͼ
		setContentView(R.layout.activity_main);
		// �ҵ��ı���ʾ�ؼ�
		tv_show=(TextView) findViewById(R.id.tv_show);		
	}
	
	/**
	 * ��ť�ؼ���Ӧ�ĵ���¼�
	 * @param v ��ǰ��������¼���View
	 */
	public void btnClick(View v){
		tv_show.setText("Hello Android");
	}
}
