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
		// ����2�� ��Fragment�л�ȡ��������Fragment�Ŀؼ�
		Button btnGetText2=(Button)getActivity().findViewById(R.id.btnGetText2);
		btnGetText2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ʹ��FragmentManagerͨ��ID�ҵ���Ҫ������fragment����
				Fragment fragment=getFragmentManager().findFragmentById(R.id.fragment2);
				// ���Fragment������ʾ�ĸ�View
				View view=fragment.getView();
				// �ҵ��ؼ�
				TextView tv=(TextView) view.findViewById(R.id.tvFragment1);
				tv.setText("Fragment�ж�̬�ı�");		
			}
		});
	}
}
