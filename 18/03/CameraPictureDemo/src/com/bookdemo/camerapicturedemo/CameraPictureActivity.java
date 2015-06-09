package com.bookdemo.camerapicturedemo;

import java.io.File;
import java.io.FileOutputStream;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;

public class CameraPictureActivity extends Activity {
	protected static final String TAG = "main";
	private Camera mCamera;
	private CameraPreview mPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ���Camera����
		mCamera = getCameraInstance();

		// ����Ԥ���࣬����Camera�����������ӵ����沼����
		mPreview = new CameraPreview(this, mCamera);
		FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		preview.addView(mPreview);


		Button captureButton = (Button) findViewById(R.id.button_capture);
		captureButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ڲ���ͼƬǰ�����Զ��Խ�
				mCamera.autoFocus(new AutoFocusCallback() {
					
					@Override
					public void onAutoFocus(boolean success, Camera camera) {
						// �۽���ɣ���Camera����ͼƬ
						mCamera.takePicture(null, null, mPicture);
					}
				});				
			}
		});
	}

	/** ����豸�Ƿ����CameraӲ�� */
	private boolean checkCameraHardware(Context context) {
		if (context.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA)) {
			// ����
			return true;
		} else {
			// ������
			return false;
		}
	}

	/** ��һ��Camera */
	public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(); 
		} catch (Exception e) {
			Log.d(TAG, "��Cameraʧ��ʧ��");
		}
		return c; 
	}

	private PictureCallback mPicture = new PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// ��ȡJpegͼƬ����������sd����
			File pictureFile = new File("/sdcard/" + System.currentTimeMillis()
					+ ".jpg");
			try {
				FileOutputStream fos = new FileOutputStream(pictureFile);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				Log.d(TAG, "����ͼƬʧ��");
			}
		}
	};

	@Override
	protected void onDestroy() {
		// ����Camera��Դ
		if(mCamera!=null){
			mCamera.stopPreview();
			mCamera.release();
			mCamera=null;
		}
		super.onDestroy();
	}	
}
