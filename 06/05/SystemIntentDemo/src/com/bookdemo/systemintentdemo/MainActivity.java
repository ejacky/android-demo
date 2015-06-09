package com.bookdemo.systemintentdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
	private Button btnDial, btnCallPhone, btnPeople, btnSendToSms, btnWeb,
			btnHome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnDial = (Button) findViewById(R.id.btnDial);
		btnCallPhone = (Button) findViewById(R.id.btnCallPhone);
		btnPeople = (Button) findViewById(R.id.btnPeople);
		btnSendToSms = (Button) findViewById(R.id.btnSendToSms);
		btnWeb = (Button) findViewById(R.id.btnWeb);
		btnHome = (Button) findViewById(R.id.btnHome);

		btnHome.setOnClickListener(this);
		btnCallPhone.setOnClickListener(this);
		btnPeople.setOnClickListener(this);
		btnSendToSms.setOnClickListener(this);
		btnWeb.setOnClickListener(this);
		btnDial.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnDial:
			startDial();
			break;
		case R.id.btnCallPhone:
			callPhone();
			break;

		case R.id.btnPeople:
			openPeopleList();
			break;
		case R.id.btnSendToSms:
			SendToSm();
			break;
		case R.id.btnWeb:
			startBrowser();
			break;
		case R.id.btnHome:
			returnHome();
			break;

		default:
			break;
		}
	}

	/**
	 * չʾIDΪ1����ϵ��
	 */
	private void SendToSm() {
		Uri uri = Uri.parse("smsto:18612345678");
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.putExtra("sms_body", "����һ���µĶ���Ϣ");
		startActivity(intent);
	}

	/**
	 * ����ϵ���б�
	 */
	private void openPeopleList() {
		// ����Intent����
		Intent intent = new Intent();
		// ����Action��Data
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("content://contacts/people"));
		startActivity(intent);
	}

	/**
	 * ����ָ���ĵ绰�������ֱ�Ӳ���
	 */
	private void startBrowser() {
		// ����Intent����
		Intent intent = new Intent();
		// ����Action����ַ
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.cnblogs.com/plokmju/"));
		startActivity(intent);
	}

	/**
	 * ����ָ���ĵ绰�������ֱ�Ӳ���
	 */
	private void callPhone() {
		// ����Intent����
		Intent intent = new Intent();
		// ����Action�͵绰����
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:18612345678"));
		startActivity(intent);
	}

	/**
	 * ����������壬���Ҵ��ݵ绰����
	 */
	private void startDial() {
		// ����Intent����
		Intent intent = new Intent();
		// ����Action�͵绰����
		intent.setAction(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:13000000000"));
		startActivity(intent);
	}

	/**
	 * ��������
	 */
	private void returnHome() {
		// ����Intent����
		Intent intent = new Intent();
		// ����Action��Category����
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		// ����Activity�ص�HOME����
		startActivity(intent);

	}
}
