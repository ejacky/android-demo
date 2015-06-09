package com.bookdemo.loadbigimg;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class LoadBigImgActivity extends Activity {
	private Button btn_loadimage;
	private ImageView iv_bigimage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_loadimage = (Button) findViewById(R.id.btn_loadimage);
		iv_bigimage = (ImageView) findViewById(R.id.iv_bigimage);

		btn_loadimage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
//				 Bitmap bitmap=BitmapFactory.decodeFile("/sdcard/a.jpg");
//				 iv_bigimage.setImageBitmap(bitmap);

				BitmapFactory.Options opts = new Options();
				// ����ȡ�������鵽�ڴ��У�����ȡͼƬ����Ϣ
				opts.inJustDecodeBounds = true;
				BitmapFactory.decodeFile("/sdcard/a.jpg", opts);
				// ��Options�л�ȡͼƬ�ķֱ���
				int imageHeight = opts.outHeight;
				int imageWidth = opts.outWidth;

				// ��ȡAndroid��Ļ�ķ���
				WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
				// ��ȡ��Ļ�ķֱ��ʣ�getHeight()��getWidth�Ѿ�����������
				// Ӧ��ʹ��getSize()����������Ϊ�����¼���������Ȼʹ������
				int windowHeight = wm.getDefaultDisplay().getHeight();
				int windowWidth = wm.getDefaultDisplay().getWidth();

				// ���������
				int scaleX = imageWidth / windowWidth;
				int scaleY = imageHeight / windowHeight;
				int scale = 1;
				// �������������ķ���Ϊ׼
				if (scaleX > scaleY && scaleY >= 1) {
					scale = scaleX;
				}
				if (scaleX < scaleY && scaleX >= 1) {
					scale = scaleY;
				}

				// false��ʾ��ȡͼƬ�������鵽�ڴ��У������趨�Ĳ�����
				opts.inJustDecodeBounds = false;
				// ���ò�����
				opts.inSampleSize = scale;
				// ����������ʣ����ش�ֱ��ʵ�ͼƬ
				Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/a.jpg", opts);
				iv_bigimage.setImageBitmap(bitmap);

			}
		});
	}
}
