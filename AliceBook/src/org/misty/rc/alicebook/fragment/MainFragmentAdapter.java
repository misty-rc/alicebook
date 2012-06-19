package org.misty.rc.alicebook.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentAdapter extends FragmentPagerAdapter {
	private final int MAIN_VIEW_COUNT = 3;

	public MainFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return ExpenseViewFragment.newInstance(position);
		case 1:
			return SummaryViewFragment.newInstance(position);
		case 2:
			return IncomeViewFragment.newInstance(position);
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return MAIN_VIEW_COUNT;
	}

}
