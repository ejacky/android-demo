package com.bookdemo.edittextinsertimagedemo;

import java.util.Random;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MainActivity extends Activity {
	private Button btn_InImg;
	private EditText et_Image;
	// ��ȡDrawable��Դ��Id����
	private final int[] DRAW_IMG_ID = { R.drawable.image0, R.drawable.image1,
			R.drawable.image2, R.drawable.image3, R.drawable.image4,
			R.drawable.image5, R.drawable.image6, R.drawable.image7,
			R.drawable.image8, R.drawable.image9 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_InImg = (Button) findViewById(R.id.btn_InImg);
		et_Image = (EditText) findViewById(R.id.et_Image);

		btn_InImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ����һ��0-9�������
				int random = new Random().nextInt(9);
				// ͨ��bitmapFactory���λͼ��Դ
				Bitmap bit = BitmapFactory.decodeResource(getResources(),
						DRAW_IMG_ID[random]);
				// һ��ImageSpan�����ڲ���Ĵ�Ŵ������ͼƬ
				ImageSpan imageSpan = new ImageSpan(MainActivity.this, bit);
				SpannableString spannableString = new SpannableString("img");
				// ��img�ı����滻��ImageͼƬ
				spannableString.setSpan(imageSpan, 0, 3,
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				// ��ͼƬ��ӵ��ı���ĩβ
				et_Image.append(spannableString);
			}
		});
	}
}
