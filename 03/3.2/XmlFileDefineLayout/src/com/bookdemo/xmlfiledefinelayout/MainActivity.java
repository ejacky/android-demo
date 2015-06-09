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
		// 为Activity指定内容视图
		setContentView(R.layout.activity_main);
		// 找到文本显示控件
		tv_show=(TextView) findViewById(R.id.tv_show);		
	}
	
	/**
	 * 按钮控件响应的点击事件
	 * @param v 当前触发点击事件的View
	 */
	public void btnClick(View v){
		tv_show.setText("Hello Android");
	}
}
