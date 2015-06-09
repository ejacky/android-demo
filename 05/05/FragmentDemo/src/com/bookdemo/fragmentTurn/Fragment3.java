package com.bookdemo.fragmentTurn;

import com.bookdemo.fragmentdemo.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment3 extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment3, container, false);		
	}
	@Override
	public void onStart() {
		super.onStart();
		// 方法2： 在Fragment中获取操作其他Fragment的控件
		Button btnGetText2=(Button)getActivity().findViewById(R.id.btnGetText2);
		btnGetText2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 使用FragmentManager通过ID找到需要操作的fragment对象
				Fragment fragment=getFragmentManager().findFragmentById(R.id.fragment2);
				// 获得Fragment对象显示的根View
				View view=fragment.getView();
				// 找到控件
				TextView tv=(TextView) view.findViewById(R.id.tvFragment1);
				tv.setText("Fragment中动态改变");		
			}
		});
	}
}
