package com.bookdemo.textviewhtmldemo;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 通过Id获得两个TextView控件
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);

		// 设置需要显示的字符串
		String html = "<font color ='red'>Hello android</font><br/>";
		html += "<font color='#0000ff'><big><i>Hello android</i></big></font><p>";
		html += "<big><a href='http://www.baidu.com'>百度</a></big>";
		// 使用Html.fromHtml,把含HTML标签的字符串转换成可显示的文本样式
		CharSequence charSequence = Html.fromHtml(html);
		// 通过setText给TextView赋值
		textView1.setText(charSequence);
		// 设定一个点击的响应
		textView1.setMovementMethod(LinkMovementMethod.getInstance());

		String text = "我的URL:http://www.cnblogs.com/plokmju/\n";
		text += "我的email:plokmju@sina.com\n";
		text += "我的电话：+86 010-12345678";
		// 因为textView2中有autoLink=”all“的属性设定，所以会自动识别对应的连接，点击出发对应的Android程序
		textView2.setText(text);
	}
}
