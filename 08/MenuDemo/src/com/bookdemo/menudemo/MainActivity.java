package com.bookdemo.menudemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1,btn2,btn3,btn4,btn5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		btn2=(Button)findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		btn3=(Button)findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		btn4=(Button)findViewById(R.id.btn4);
		btn4.setOnClickListener(this);
		btn5=(Button)findViewById(R.id.btn5);
		btn5.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch (v.getId()) {
		case R.id.btn1:
			intent=new Intent(MainActivity.this,OptionMenu1Activitty.class);
			startActivity(intent);
			break;
		case R.id.btn2:
			intent=new Intent(MainActivity.this,OptionMenu2Activitty.class);
			startActivity(intent);
			break;
		case R.id.btn3:
			intent=new Intent(MainActivity.this,ContextMenu1.class);
			startActivity(intent);
			break;
		case R.id.btn4:
			intent=new Intent(MainActivity.this,ActionModeMenu.class);
			startActivity(intent);
			break;
		case R.id.btn5:
			showPopup(v);
			break;
		default:
			break;
		}
		
	}

	@SuppressLint("NewApi")
	public void showPopup(View v){
		PopupMenu popup=new PopupMenu(MainActivity.this, v);
		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case R.id.context_copy:
					Toast.makeText(MainActivity.this, "select copy ", Toast.LENGTH_SHORT).show();
					return true;
				case R.id.context_delete:
					Toast.makeText(MainActivity.this, " select delete ", Toast.LENGTH_SHORT).show();
					return true;
				case R.id.context_edit:
					Toast.makeText(MainActivity.this, " select edit ", Toast.LENGTH_SHORT).show();
					return true;
					default :
					return false;
				}
			}
		});
		popup.getMenuInflater().inflate(R.menu.contextmenu,popup.getMenu());
		popup.show();
	}
}
