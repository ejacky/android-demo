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
		//直接Add菜单选项到Menu中
		menu.add(1000, 100, 0, "System menu"); 
		//获取添加的菜单选项，然后设置其图标
		MenuItem menuItem2=menu.add(1000, 101, 2, "User menu"); 
		menuItem2.setIcon(R.drawable.ic_launcher);
		//获取添加的菜单选项，增加一个Intent，点击后转向IntentActivity
		MenuItem menuItem3=menu.add(1000, 102, 1, "Intent menu"); 
		menuItem3.setIcon(R.drawable.ic_launcher);
		Intent intent=new Intent(OptionMenu1Activitty.this, IntentActivity.class);
		menuItem3.setIntent(intent);		

		//添加一个SubMenu，点击后弹出一个子菜单对话框
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
