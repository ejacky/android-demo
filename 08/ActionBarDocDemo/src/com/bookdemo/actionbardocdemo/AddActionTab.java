package com.bookdemo.actionbardocdemo;

import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddActionTab extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.action_bar_tabs);
	}

	/**
	 * ���һ��Tab��ActionBar��
	 * @param v 
	 */
	public void onAddTab(View v) {
		final ActionBar bar = getActionBar();
		final int tabCount = bar.getTabCount();
		final String text = "Tab " + tabCount;
		// ��ActionBar�����һ��Tab������ǩ
		bar.addTab(bar.newTab().setText(text)
				.setTabListener(new TabListener(new TabContentFragment(text))));
	}
	/**
	 * �Ƴ����һ��ActionBar�е�Tab
	 * @param v 
	 */
	public void onRemoveTab(View v) {
		final ActionBar bar = getActionBar();
		if (bar.getTabCount() > 0) {
			bar.removeTabAt(bar.getTabCount() - 1);
		}
	}

	/**
	 * ��ʾ��������ActionBar��Tab������
	 * @param v
	 */
	public void onToggleTabs(View v) {
		final ActionBar bar = getActionBar();
		// �����ʾ������
		if (bar.getNavigationMode() == ActionBar.NAVIGATION_MODE_TABS) {
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE,
					ActionBar.DISPLAY_SHOW_TITLE);
		} else {
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
		}
	}

	/**
	 * ��ActionBar���Ƴ����е�Tab��ǩ
	 * @param v
	 */
	public void onRemoveAllTabs(View v) {
		getActionBar().removeAllTabs();
	}

	/**
	 * ����һ��TabListener�ļ̳��࣬������ͨ�����캯��ָ����ʾ��Fragment
	 * ��onTabSelected()�����У����ص�ǰTabListenerָ����Fragment
	 */
	private class TabListener implements ActionBar.TabListener {
		private TabContentFragment mFragment;

		public TabListener(TabContentFragment fragment) {
			// ��ǰTabListener��ʾ��Fragment
			mFragment = fragment;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Tab��ǩ��ѡ��ʱ��������ʾ��Fragment
			ft.add(R.id.fragment_content, mFragment, mFragment.getText());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// Tab�Ƴ�ѡ��״̬���Ƴ���ʾ��Fragment
			ft.remove(mFragment);
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			Toast.makeText(AddActionTab.this, "��ѡ����һ��", Toast.LENGTH_SHORT)
					.show();
		}
	}

	@SuppressLint("ValidFragment")
	/**
	 * �ڲ���Fragment��ָ����ʾ��View�Լ�View��ʾ��ֵ
	 *
	 */
	private class TabContentFragment extends Fragment {
		private String mText;

		public TabContentFragment(String text) {
			mText = text;
		}

		public String getText() {
			return mText;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View fragView = inflater.inflate(R.layout.activity_new, container,
					false);

			TextView text = (TextView) fragView.findViewById(R.id.tvNew);
			text.setText(mText);

			return fragView;
		}
	}
}
