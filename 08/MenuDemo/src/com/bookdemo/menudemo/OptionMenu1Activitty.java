package com.bookdemo.menudemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class OptionMenu1Activitty extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_optionmenu1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("main", "onCreateOptionsMenu");
		//ֱ��Add�˵�ѡ�Menu��
		menu.add(1000, 100, 0, "System menu"); 
		//��ȡ��ӵĲ˵�ѡ�Ȼ��������ͼ��
		MenuItem menuItem2=menu.add(1000, 101, 2, "User menu"); 
		menuItem2.setIcon(R.drawable.ic_launcher);
		//��ȡ��ӵĲ˵�ѡ�����һ��Intent�������ת��IntentActivity
		MenuItem menuItem3=menu.add(1000, 102, 1, "Intent menu"); 
		menuItem3.setIcon(R.drawable.ic_launcher);
		Intent intent=new Intent(OptionMenu1Activitty.this, IntentActivity.class);
		menuItem3.setIntent(intent);		

		//���һ��SubMenu������󵯳�һ���Ӳ˵��Ի���
		SubMenu submenu=menu.addSubMenu(1000, 103, 3, "Sub menus");
		submenu.add(1000, 104, 4, "Sub ment1");
		submenu.add(1000, 105, 4, "Sub ment2");
		submenu.add(1000, 106, 4, "Sub ment3");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean flag;
		switch (item.getItemId()) {
		case 100:
			Toast.makeText(OptionMenu1Activitty.this, "selected System menu", Toast.LENGTH_SHORT).show();
			flag=true;
			break;
		case 101:
			Toast.makeText(OptionMenu1Activitty.this, "selected User menu", Toast.LENGTH_SHORT).show();
			flag=true;
			break;
		case 104:
			Toast.makeText(OptionMenu1Activitty.this, "selected Sub menu1", Toast.LENGTH_SHORT).show();
			flag=true;
		case 106:
			Log.i("main", "invalidateOptionsMenu");
			Toast.makeText(OptionMenu1Activitty.this, "selected Sub menu6", Toast.LENGTH_SHORT).show();
			flag=true;
		default:
			flag=super.onOptionsItemSelected(item);
			break;
		}
		return super.onOptionsItemSelected(item);
	}	
}
