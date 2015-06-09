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

		// ��ȡ��ť�ؼ�
		btn_Sty = (Button) findViewById(R.id.btn_Sty);
		// ����SpannableString������ͼƬ������
		SpannableString spannebleLeft = new SpannableString("left");
		// �õ�ͼƬ��Դ��Bitmap����
		Bitmap bitmapleft = BitmapFactory.decodeResource(getResources(),
				R.drawable.image1);
		ImageSpan imageSpanLeft = new ImageSpan(MainActivity.this, bitmapleft);
		// ����ʹ��ͼƬ�滻�ı���
		spannebleLeft.setSpan(imageSpanLeft, 0, 4,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		SpannableString spannebleRight = new SpannableString("right");
		Bitmap bitmapRight = BitmapFactory.decodeResource(getResources(),
				R.drawable.image2);
		ImageSpan imageSpanRight = new ImageSpan(MainActivity.this, bitmapRight);
		spannebleRight.setSpan(imageSpanRight, 0, 5,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// �����ɵ�SpannableString׷�ӵ���ť��
		btn_Sty.append(spannebleLeft);
		btn_Sty.append("aLi");
		btn_Sty.append(spannebleRight);
	}
}
