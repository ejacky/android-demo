package com.bookdemo.menudemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class OptionMenu2Activitty extends Activity {
	private TextView  tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_optionmenu1);
		tv=(TextView)findViewById(R.id.tvOptionMenu1);
		tv.setText("����XML��Դ���Menu");		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {		
		// ʹ�ò����ļ����ز˵�
		getMenuInflater().inflate(R.menu.optionmenu2, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.item1:
			Toast.makeText(OptionMenu2Activitty.this, "selected System menu", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.item2:
			Toast.makeText(OptionMenu2Activitty.this, "selected User menu", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.item3:
			Intent intent=new Intent(OptionMenu2Activitty.this, IntentActivity.class);
			startActivity(intent);
			return true;
		case R.id.menu_save:
			Toast.makeText(OptionMenu2Activitty.this, "file save", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.sub_menu1:
			Toast.makeText(OptionMenu2Activitty.this, "Selected sub_menu1", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}		
	}	
}
