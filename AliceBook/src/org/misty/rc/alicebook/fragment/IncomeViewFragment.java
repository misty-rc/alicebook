package org.misty.rc.alicebook.fragment;

import org.misty.rc.alicebook.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class IncomeViewFragment extends Fragment {
	
	static IncomeViewFragment newInstance(int num) {
		IncomeViewFragment ins = new IncomeViewFragment();
		Bundle args = new Bundle();
		args.putInt("num", num);
		ins.setArguments(args);
		
		return ins;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.income_fragment2, container, false);
		TextView tv = (TextView) v.findViewById(R.id.income_test);
		tv.setText("income");
		
		return v;
	}
	
	

}
