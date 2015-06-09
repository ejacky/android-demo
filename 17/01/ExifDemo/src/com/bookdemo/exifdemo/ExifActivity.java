package com.bookdemo.exifdemo;

import android.media.ExifInterface;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExifActivity extends Activity {
	private Button btn_readExifInLog;
	private final static String TAG = "main";
	private Button btn_saveExif;
	private Button btn_readExif;
	private EditText et_attr;
	private EditText et_value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_readExifInLog = (Button) findViewById(R.id.btn_readExifInLog);
		btn_saveExif = (Button) findViewById(R.id.btn_saveExif);
		btn_readExif = (Button) findViewById(R.id.btn_readExif);
		et_attr = (EditText) findViewById(R.id.et_attr);
		et_value = (EditText) findViewById(R.id.et_value);

		btn_saveExif.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					// tag
					String strAttr = et_attr.getText().toString().trim();
					// tag-value
					String strValue = et_value.getText().toString().trim();

					if (TextUtils.isEmpty(strAttr)
							|| TextUtils.isEmpty(strValue)) {
						Toast.makeText(ExifActivity.this, "请填写属性及值",
								Toast.LENGTH_SHORT).show();
						return;
					}
					// 获取图片Exif
					ExifInterface exif = new ExifInterface("/sdcard/a.jpg");
					// 保存指定tag的值
					exif.setAttribute(strAttr,strValue);
					// 把Exif信息写入目标图片
					exif.saveAttributes();
					Toast.makeText(ExifActivity.this, "Exif信息保存成功",
							Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btn_readExif.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					// tag
					String strAttr = et_attr.getText().toString().trim();

					if (TextUtils.isEmpty(strAttr)) {
						Toast.makeText(ExifActivity.this, "请填写属性",
								Toast.LENGTH_SHORT).show();
						return;
					}
					
					// 获取图片Exif
					ExifInterface exif = new ExifInterface("/sdcard/a.jpg");
					// 获取指定tag的属性值
					String strValue = exif.getAttribute(strAttr);
					if (!TextUtils.isEmpty(strValue)) {
						Toast.makeText(ExifActivity.this, strAttr+"="+strValue,
								Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(ExifActivity.this, "图片Exif中没有属性值为"+strAttr+"的信息",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btn_readExifInLog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					ExifInterface exifInterface = new ExifInterface(
							"/sdcard/a.jpg");
					String FFNumber = exifInterface
							.getAttribute(ExifInterface.TAG_APERTURE);
					String FDateTime = exifInterface
							.getAttribute(ExifInterface.TAG_DATETIME);
					String FExposureTime = exifInterface
							.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
					String FFlash = exifInterface
							.getAttribute(ExifInterface.TAG_FLASH);
					String FFocalLength = exifInterface
							.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
					String FImageLength = exifInterface
							.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
					String FImageWidth = exifInterface
							.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
					String FISOSpeedRatings = exifInterface
							.getAttribute(ExifInterface.TAG_ISO);
					String FMake = exifInterface
							.getAttribute(ExifInterface.TAG_MAKE);
					String FModel = exifInterface
							.getAttribute(ExifInterface.TAG_MODEL);
					String FOrientation = exifInterface
							.getAttribute(ExifInterface.TAG_ORIENTATION);
					String FWhiteBalance = exifInterface
							.getAttribute(ExifInterface.TAG_WHITE_BALANCE);

					Log.i(TAG, "FFNumber:" + FFNumber);
					Log.i(TAG, "FDateTime:" + FDateTime);
					Log.i(TAG, "FExposureTime:" + FExposureTime);
					Log.i(TAG, "FFlash:" + FFlash);
					Log.i(TAG, "FFocalLength:" + FFocalLength);
					Log.i(TAG, "FImageLength:" + FImageLength);
					Log.i(TAG, "FImageWidth:" + FImageWidth);
					Log.i(TAG, "FISOSpeedRatings:" + FISOSpeedRatings);
					Log.i(TAG, "FMake:" + FMake);
					Log.i(TAG, "FModel:" + FModel);
					Log.i(TAG, "FOrientation:" + FOrientation);
					Log.i(TAG, "FWhiteBalance:" + FWhiteBalance);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
