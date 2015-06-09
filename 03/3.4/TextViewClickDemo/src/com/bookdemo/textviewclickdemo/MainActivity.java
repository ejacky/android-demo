package com.bookdemo.textviewclickdemo;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private TextView clickTextView1, clickTextView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		clickTextView1 = (TextView) this.findViewById(R.id.clickTextView1);
		clickTextView2 = (TextView) this.findViewById(R.id.clickTextView2);
		// 使用SpannableString包装字符串
		SpannableString spannableString1 = new SpannableString(
				"响应其中TextView的点击事件");
		SpannableString spannableString2 = new SpannableString(
				"响应其中TextView的click事件");
		// 通过setSpan设定文本块响应的点击事件
		spannableString1.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				// 显示消息
				Toast.makeText(MainActivity.this, "‘TextView’\n被点击了",
						Toast.LENGTH_SHORT).show();
			}
		}, 4, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		spannableString2.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "‘click’\n被点击了",
						Toast.LENGTH_SHORT).show();
			}
		}, 13, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// 对TextView文本进行赋值
		clickTextView1.setText(spannableString1);
		// 设置点击响应
		clickTextView1.setMovementMethod(LinkMovementMethod.getInstance());
		clickTextView2.setText(spannableString2);
		clickTextView2.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
