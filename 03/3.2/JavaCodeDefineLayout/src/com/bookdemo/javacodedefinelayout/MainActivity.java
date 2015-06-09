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
		// 不使用XML布局文件定义Activity的内容视图
//		setContentView(R.layout.activity_main);
		// 定义一个线性布局对象
		layout=new LinearLayout(this);
		// 指定线性布局方向为垂直
		layout.setOrientation(LinearLayout.VERTICAL);
		// 指定其为匹配父窗口
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		// 定义一个按钮对象
		btnClick=new Button(this);
		btnClick.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		// 指定其显示文本
		btnClick.setText("Say hello");
		// 为按钮添加点击响应监听器
		btnClick.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if(tvShow!=null){
					tvShow.setText("Hello Android");
				}
			}
		});
		
		// 定义一个文本展示控件
		tvShow=new TextView(this);
		tvShow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		// 把定义的UI控件添加到布局对象中
		layout.addView(btnClick);
		layout.addView(tvShow);
		// 指定Activity的内容视图为定义的线性布局对象
		setContentView(layout);
	}
}
