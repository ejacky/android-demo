package com.bookdemo.menudemo;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextMenu1 extends Activity {
	private ListView listview;
	private List<String> dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contextmenu1);
		listview=(ListView)findViewById(R.id.listView1);
		dataList=getData();
		ArrayAdapter<String> adapter=new  ArrayAdapter<String>(ContextMenu1.this,android.R.layout.simple_list_item_1, dataList);
		listview.setAdapter(adapter);
		//为ListView注册上下文菜单
		registerForContextMenu(listview);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		//填充一个XML菜单文件
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.contextmenu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		//获取上下文菜单绑定的AdapterView的额外信息
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.context_copy:
			Toast.makeText(ContextMenu1.this, "copy "+dataList.get(info.position), Toast.LENGTH_SHORT).show();
			return true;
		case R.id.context_delete:
			Toast.makeText(ContextMenu1.this, "delete "+dataList.get(info.position), Toast.LENGTH_SHORT).show();
			return true;
		case R.id.context_edit:
			Toast.makeText(ContextMenu1.this, "edit " +dataList.get(info.position), Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onContextItemSelected(item);
		}		
	}
	//ListView数据
	public List<String> getData()
	{		
		List<String> data=new ArrayList<String>();
		for(int i=0;i<8;i++)
		{
			data.add("item"+i);
		}
		return data;
	}	
}
