package org.misty.rc.alicebook.fragment;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PieChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.misty.rc.alicebook.AliceApplication;
import org.misty.rc.alicebook.AliceBookActivity;
import org.misty.rc.alicebook.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SummaryViewFragment extends Fragment {
	
	static SummaryViewFragment newInstance(int num) {
		SummaryViewFragment ins = new SummaryViewFragment();
		Bundle args = new Bundle();
		args.putInt("num", num);
		ins.setArguments(args);
		
		return ins;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.summary_fragment, container, false);
		
		// text sample
		TextView tv = (TextView)v.findViewById(R.id.summary_test);
		tv.setText("Summary");
		
		// chart test
		LinearLayout ll = (LinearLayout)v.findViewById(R.id.chart_area);
		CategorySeries series = new CategorySeries(null);
		DefaultRenderer renderer = new DefaultRenderer();
		int[] colors = new int[]{Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN, Color.RED};
		
		series.add("Cupcake", new Integer(40));
		series.add("Donut", new Integer(5));
		series.add("Eclair", new Integer(10));
		series.add("Froyo", new Integer(25));
		series.add("Gingerbread", new Integer(20));
		series.add("Honeycomb", new Integer(50));
		
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(20);
		
		for(int color: colors) {
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(color);
			renderer.addSeriesRenderer(r);
		}
		PieChart _pieChart = new PieChart(series, renderer);
		ExtendedGraphicalView chart_test = new ExtendedGraphicalView(getActivity(), _pieChart);
//		GraphicalView pie_chart = ChartFactory.getPieChartView(getActivity().getApplicationContext(), series, renderer);
		ll.addView(chart_test, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		return v;
	}
	
	
}
