package com.bookdemo.asynctaskdemo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AsyncTaskActivity extends Activity {
	private Button btnDown;
	private ImageView ivImage;
	// ���ص�ͼƬ��ַ
	private static String image_path = "http://images.cnblogs.com/cnblogs_com/plokmju/550907/o_hand.jpg";
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDown = (Button) findViewById(R.id.btnDown);
		ivImage = (ImageView) findViewById(R.id.ivImage);

		// ����һ���������Ի���
		dialog = new ProgressDialog(this);
		dialog.setTitle("��ʾ");
		dialog.setMessage("�������أ����Ժ�...");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCancelable(false);

		btnDown.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ִ��һ���첽���񣬲���ͼƬ��ַ�Բ�������ʽ���ݽ�ȥ
				new MyTask().execute(image_path);
			}
		});
	}

	// ��String���͵Ĳ�����Integer��ʾ������Ϣ��Bitmap��ʾ�첽���񷵻�һ��λͼ
	public class MyTask extends AsyncTask<String, Integer, Bitmap> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// ��ʾ�������Ի���
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			// ���ý��ȶԻ���Ľ���ֵ
			dialog.setProgress(values[0]);
		}
		//��ɸ���UI����
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			// ���ٶԻ���
			dialog.dismiss();
			//����ImageView����ʾͼƬ
			ivImage.setImageBitmap(result);
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			// ���ʱ�Ĳ���������ͼƬ��Դ
			Bitmap bitmap = null;
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			InputStream inputStream = null;
			try {
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(params[0]);
				HttpResponse httpResponse = httpClient.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					inputStream = httpResponse.getEntity().getContent();
					long file_length = httpResponse.getEntity()
							.getContentLength();
					int len = 0;
					byte[] data = new byte[1024];
					int total_length = 0;
					// ���ֽڵķ�ʽ��ȡͼƬ����
					while ((len = inputStream.read(data)) != -1) {
						total_length += len;
						// �������
						int values = (int) ((total_length / (float) file_length) * 100);
						// ����������Ϣ
						publishProgress(values);
						outputStream.write(data, 0, len);
					}
					byte[] result = outputStream.toByteArray();
					bitmap = BitmapFactory.decodeByteArray(result, 0,
							result.length);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// �ر�������
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (Exception e2) {
				}
			}
			return bitmap;
		}
	}
}
