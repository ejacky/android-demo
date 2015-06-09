package com.bookdemo.fragmentSimple;

import com.bookdemo.fragmentdemo.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 填充一个布局View到ViewGrope中
		return inflater.inflate(R.layout.fragment1, container, false);		
	}
}
