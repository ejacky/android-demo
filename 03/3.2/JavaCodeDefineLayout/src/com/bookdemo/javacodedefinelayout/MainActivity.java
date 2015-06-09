package com.bookdemo.javacodedefinelayout;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {
	private LinearLayout layout;
	private Button btnClick;
	private TextView tvShow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��ʹ��XML�����ļ�����Activity��������ͼ
//		setContentView(R.layout.activity_main);
		// ����һ�����Բ��ֶ���
		layout=new LinearLayout(this);
		// ָ�����Բ��ַ���Ϊ��ֱ
		layout.setOrientation(LinearLayout.VERTICAL);
		// ָ����Ϊƥ�丸����
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		// ����һ����ť����
		btnClick=new Button(this);
		btnClick.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		// ָ������ʾ�ı�
		btnClick.setText("Say hello");
		// Ϊ��ť��ӵ����Ӧ������
		btnClick.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if(tvShow!=null){
					tvShow.setText("Hello Android");
				}
			}
		});
		
		// ����һ���ı�չʾ�ؼ�
		tvShow=new TextView(this);
		tvShow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		// �Ѷ����UI�ؼ���ӵ����ֶ�����
		layout.addView(btnClick);
		layout.addView(tvShow);
		// ָ��Activity��������ͼΪ��������Բ��ֶ���
		setContentView(layout);
	}
}
