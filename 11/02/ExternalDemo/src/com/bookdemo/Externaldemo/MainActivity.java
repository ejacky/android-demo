package com.bookdemo.Externaldemo;

import java.io.IOException;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private EditText etFilename, etContent;
	private Button btnSave, btnQuery, btnDelete, btnAppend;
	private ListView lvData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etFilename = (EditText) findViewById(R.id.etInternalFilename);
		etContent = (EditText) findViewById(R.id.etInternalContent);
		btnSave = (Button) findViewById(R.id.btnInternalSave);
		btnQuery = (Button) findViewById(R.id.btnInternalQuery);
		btnDelete = (Button) findViewById(R.id.btnInternalDelete);
		btnAppend = (Button) findViewById(R.id.btnInternalAppend);
		lvData = (ListView) findViewById(R.id.lvInternalData);

		btnSave.setOnClickListener(click);
		btnQuery.setOnClickListener(click);
		btnDelete.setOnClickListener(click);
		btnAppend.setOnClickListener(click);

		lvData.setOnItemClickListener(itemClick);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			MyExternalStorage myInternal = null;
			String filename = null;
			String content = null;
			switch (v.getId()) {
			case R.id.btnInternalSave:
				filename = etFilename.getText().toString();
				content = etContent.getText().toString();
				myInternal = new MyExternalStorage(getApplicationContext());
				try {
					myInternal.save(filename, content);
					Toast.makeText(getApplicationContext(), "�����ļ��ɹ�",
							Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "�����ļ�ʧ��",
							Toast.LENGTH_SHORT).show();
				}

				break;

			case R.id.btnInternalDelete:
				filename = etFilename.getText().toString();
				myInternal = new MyExternalStorage(getApplicationContext());
				myInternal.delete(filename);
				Toast.makeText(getApplicationContext(), "ɾ���ļ��ɹ�",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.btnInternalQuery:
				myInternal = new MyExternalStorage(getApplicationContext());
				String[] files = myInternal.queryAllFile();
				ArrayAdapter<String> fileArray = new ArrayAdapter<String>(
						MainActivity.this,
						android.R.layout.simple_list_item_1, files);
				lvData.setAdapter(fileArray);
				Toast.makeText(getApplicationContext(), "��ѯ�ļ��б�",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.btnInternalAppend:
				filename = etFilename.getText().toString();
				content = etContent.getText().toString();
				myInternal = new MyExternalStorage(getApplicationContext());
				try {
					myInternal.append(filename, content);
					Toast.makeText(getApplicationContext(), "�ļ�����׷�ӳɹ�",
							Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "�ļ�����׷��ʧ��",
							Toast.LENGTH_SHORT).show();
				}
				break;
			}

		}
	};

	private OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView lv = (ListView) parent;
			ArrayAdapter<String> adapter = (ArrayAdapter<String>) lv
					.getAdapter();
			// ��ȡ��ǰѡ��������������
			String filename = adapter.getItem(position);
			etFilename.setText(filename);
			MyExternalStorage myInternal = new MyExternalStorage(
					getApplicationContext());
			String content;
			try {
				content = myInternal.get(filename);
				etContent.setText(content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
}
