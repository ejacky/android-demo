package com.bookdemo.callsystemcamera;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SysCameraActivity extends Activity {
	private Button btn_StartCamera, btn_StartCameraInGallery;
	private ImageView iv_CameraImg;

	private static final String TAG = "main";
	private static final String FILE_PATH = "/sdcard/syscamera.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_syscamera);

		btn_StartCamera = (Button) findViewById(R.id.btn_StartCamera);
		btn_StartCameraInGallery = (Button) findViewById(R.id.btn_StartCameraInGallery);
		iv_CameraImg = (ImageView) findViewById(R.id.iv_CameraImg);

		btn_StartCamera.setOnClickListener(click);
		btn_StartCameraInGallery.setOnClickListener(click);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			
			Intent intent = null;
			switch (v.getId()) {
			// ָ�����������Ƭ�����ַ
			case R.id.btn_StartCamera:
				intent = new Intent();
				// ָ������ϵͳ�����Action
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				// �����ļ���ַ�����ļ�
				File file = new File(FILE_PATH);
				if (file.exists()) {
					file.delete();
				}
				// ���ļ���ַת����Uri��ʽ
				Uri uri = Uri.fromFile(file);
				// ����ϵͳ���������Ƭ��ɺ�ͼƬ�ļ��Ĵ�ŵ�ַ
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				startActivityForResult(intent, 0);
				break;
			// ��ָ�����������Ƭ�����ַ
			case R.id.btn_StartCameraInGallery:
				intent = new Intent();
				// ָ������ϵͳ�����Action
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				startActivityForResult(intent, 1);
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "ϵͳ���������ɣ�resultCode="+resultCode);
		
		if (requestCode == 0) {
			File file = new File(FILE_PATH);
			Uri uri = Uri.fromFile(file);
			iv_CameraImg.setImageURI(uri);
		} else if (requestCode == 1) {
			Log.i(TAG, "Ĭ��content��ַ��"+data.getData());
			iv_CameraImg.setImageURI(data.getData());
		}
	}
}
