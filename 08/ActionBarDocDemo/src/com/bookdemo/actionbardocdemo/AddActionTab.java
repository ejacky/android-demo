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
	 * 添加一个Tab到ActionBar中
	 * @param v 
	 */
	public void onAddTab(View v) {
		final ActionBar bar = getActionBar();
		final int tabCount = bar.getTabCount();
		final String text = "Tab " + tabCount;
		// 在ActionBar中添加一个Tab导航标签
		bar.addTab(bar.newTab().setText(text)
				.setTabListener(new TabListener(new TabContentFragment(text))));
	}
	/**
	 * 移除最后一个ActionBar中的Tab
	 * @param v 
	 */
	public void onRemoveTab(View v) {
		final ActionBar bar = getActionBar();
		if (bar.getTabCount() > 0) {
			bar.removeTabAt(bar.getTabCount() - 1);
		}
	}

	/**
	 * 显示或者隐藏ActionBar的Tab导航栏
	 * @param v
	 */
	public void onToggleTabs(View v) {
		final ActionBar bar = getActionBar();
		// 如果显示则隐藏
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
	 * 从ActionBar中移除所有的Tab标签
	 * @param v
	 */
	public void onRemoveAllTabs(View v) {
		getActionBar().removeAllTabs();
	}

	/**
	 * 声明一个TabListener的继承类，在其中通过构造函数指定显示的Fragment
	 * 在onTabSelected()方法中，加载当前TabListener指定的Fragment
	 */
	private class TabListener implements ActionBar.TabListener {
		private TabContentFragment mFragment;

		public TabListener(TabContentFragment fragment) {
			// 当前TabListener显示的Fragment
			mFragment = fragment;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Tab标签被选中时，加载显示的Fragment
			ft.add(R.id.fragment_content, mFragment, mFragment.getText());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// Tab移出选中状态后，移除显示的Fragment
			ft.remove(mFragment);
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			Toast.makeText(AddActionTab.this, "又选中了一次", Toast.LENGTH_SHORT)
					.show();
		}
	}

	@SuppressLint("ValidFragment")
	/**
	 * 内部的Fragment，指定显示的View以及View显示的值
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
