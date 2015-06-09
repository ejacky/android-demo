package com.bookdemo.buttonimagetextdemo;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.Button;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MainActivity extends Activity {
	private Button btn_Sty;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 获取按钮控件
		btn_Sty = (Button) findViewById(R.id.btn_Sty);
		// 生成SpannableString，用于图片的载体
		SpannableString spannebleLeft = new SpannableString("left");
		// 得到图片资源的Bitmap对象
		Bitmap bitmapleft = BitmapFactory.decodeResource(getResources(),
				R.drawable.image1);
		ImageSpan imageSpanLeft = new ImageSpan(MainActivity.this, bitmapleft);
		// 设置使用图片替换文本块
		spannebleLeft.setSpan(imageSpanLeft, 0, 4,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		SpannableString spannebleRight = new SpannableString("right");
		Bitmap bitmapRight = BitmapFactory.decodeResource(getResources(),
				R.drawable.image2);
		ImageSpan imageSpanRight = new ImageSpan(MainActivity.this, bitmapRight);
		spannebleRight.setSpan(imageSpanRight, 0, 5,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// 把生成的SpannableString追加到按钮上
		btn_Sty.append(spannebleLeft);
		btn_Sty.append("aLi");
		btn_Sty.append(spannebleRight);
	}
}
