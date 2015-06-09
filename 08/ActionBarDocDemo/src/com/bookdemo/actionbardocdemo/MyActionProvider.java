package com.bookdemo.actionbardocdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyActionProvider extends ActionProvider {
	private Context context;

	public MyActionProvider(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public View onCreateActionView() {
		View view=LayoutInflater.from(context).inflate(R.layout.myshared, null);
		
//		ListView listview = new ListView(context);
//		List<String> strList = new ArrayList<String>();
//		strList.add("sina");
//		strList.add("weixin");
//		listview.setAdapter(new ArrayAdapter<String>(context,
//				android.R.layout.simple_list_item_1, strList));
		return view;
	}

	@Override
	public boolean onPerformDefaultAction() {
		return super.onPerformDefaultAction();
	}
}
