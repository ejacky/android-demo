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
	 * 展示ID为1的联系人
	 */
	private void SendToSm() {
		Uri uri = Uri.parse("smsto:18612345678");
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.putExtra("sms_body", "这是一个新的短消息");
		startActivity(intent);
	}

	/**
	 * 打开联系人列表
	 */
	private void openPeopleList() {
		// 构造Intent对象
		Intent intent = new Intent();
		// 设置Action和Data
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("content://contacts/people"));
		startActivity(intent);
	}

	/**
	 * 按照指定的电话号码进行直接拨号
	 */
	private void startBrowser() {
		// 构造Intent对象
		Intent intent = new Intent();
		// 设置Action和网址
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.cnblogs.com/plokmju/"));
		startActivity(intent);
	}

	/**
	 * 按照指定的电话号码进行直接拨号
	 */
	private void callPhone() {
		// 构造Intent对象
		Intent intent = new Intent();
		// 设置Action和电话号码
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:18612345678"));
		startActivity(intent);
	}

	/**
	 * 启动拨号面板，并且传递电话号码
	 */
	private void startDial() {
		// 构造Intent对象
		Intent intent = new Intent();
		// 设置Action和电话号码
		intent.setAction(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:13000000000"));
		startActivity(intent);
	}

	/**
	 * 返回桌面
	 */
	private void returnHome() {
		// 构造Intent对象
		Intent intent = new Intent();
		// 设置Action和Category属性
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		// 开启Activity回到HOME桌面
		startActivity(intent);

	}
}
