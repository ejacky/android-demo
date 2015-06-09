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
				// 不读取像素数组到内存中，仅读取图片的信息
				opts.inJustDecodeBounds = true;
				BitmapFactory.decodeFile("/sdcard/a.jpg", opts);
				// 从Options中获取图片的分辨率
				int imageHeight = opts.outHeight;
				int imageWidth = opts.outWidth;

				// 获取Android屏幕的服务
				WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
				// 获取屏幕的分辨率，getHeight()、getWidth已经被废弃掉了
				// 应该使用getSize()，但是这里为了向下兼容所以依然使用它们
				int windowHeight = wm.getDefaultDisplay().getHeight();
				int windowWidth = wm.getDefaultDisplay().getWidth();

				// 计算采样率
				int scaleX = imageWidth / windowWidth;
				int scaleY = imageHeight / windowHeight;
				int scale = 1;
				// 采样率依照最大的方向为准
				if (scaleX > scaleY && scaleY >= 1) {
					scale = scaleX;
				}
				if (scaleX < scaleY && scaleX >= 1) {
					scale = scaleY;
				}

				// false表示读取图片像素数组到内存中，依照设定的采样率
				opts.inJustDecodeBounds = false;
				// 设置采样率
				opts.inSampleSize = scale;
				// 按照其采样率，加载大分辨率的图片
				Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/a.jpg", opts);
				iv_bigimage.setImageBitmap(bitmap);

			}
		});
	}
}
