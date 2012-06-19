package org.misty.rc.alicebook.fragment;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.misty.rc.alicebook.R;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpenseViewFragment extends Fragment {
	
	static ExpenseViewFragment newInstance(int num) {
		ExpenseViewFragment ins = new ExpenseViewFragment();
		Bundle args = new Bundle();
		args.putInt("num", num);
		ins.setArguments(args);
		
		return ins;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.expense_fragment, container, false);
		
		// sample text
		TextView tv = (TextView) v.findViewById(R.id.expense_test);
		tv.setText("Expense");
		
		// chart view
		LinearLayout ll = (LinearLayout)v.findViewById(R.id.expense_chart);
		String[] titles = new String[]{"Crete", "Corfu", "Thassos", "Skiathos"};
		
		List<double[]> x = new ArrayList<double[]>();
		for(int i = 0; i < titles.length; i++) {
			x.add(new double[]{1,2,3,4,5,6,7,8,9,10,11,12});
		}
		
		List<double[]> values = new ArrayList<double[]>();
		values.add(new double[]{12.3, 12.5, 13.8, 16.8, 20.4, 24.4, 26.4, 26.1, 23.6, 20.3, 17.2, 13.9});
		values.add(new double[] { 10, 10, 12, 15, 20, 24, 26, 26, 23, 18, 14, 11 });
		values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9, 6 });
		values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13, 10 });
		
		int[] colors = new int[]{Color.BLUE, Color.GREEN, Color.CYAN, Color.YELLOW};
		PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND, PointStyle.TRIANGLE, PointStyle.SQUARE};
		
		XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
		int length = renderer.getSeriesRendererCount();
		for(int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
		}
		
		renderer.setXLabels(12);  
		renderer.setYLabels(10);  
		renderer.setShowGrid(true);  
		renderer.setXLabelsAlign(Align.RIGHT);  
		renderer.setYLabelsAlign(Align.RIGHT);  
		renderer.setZoomButtonsVisible(true);  
		
		//表示されるX軸とY軸の最小最大。  
		//ここでXYともに最小を0にするとグラフのマイナス表示がない  
		renderer.setPanLimits(new double[] { -10, 20, -10, 40 });  
		renderer.setZoomLimits(new double[] { -10, 20, -10, 40 });
		
		LineChart _lineChart = new LineChart(buildDataset(titles, x, values), renderer);
		ExtendedGraphicalView _lineChartView = new ExtendedGraphicalView(getActivity(), _lineChart);
		
//		GraphicalView expense_chat = ChartFactory.getLineChartView(getActivity().getApplicationContext(), buildDataset(titles, x, values) , renderer);
		FrameLayout fl = (FrameLayout)ll.findViewById(R.id.deep_chart);
		fl.addView(_lineChartView);
		return v;
	}
	
	
	
	
	
	protected XYMultipleSeriesRenderer buildRenderer(int[] colors, PointStyle[] styles) {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		setRenderer(renderer, colors, styles);
		return renderer;
	}
	
	protected void setRenderer(XYMultipleSeriesRenderer renderer, int[] colors, PointStyle[] styles) {
		renderer.setAxisTitleTextSize(16);
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setPointSize(5f);
		renderer.setMargins(new int[]{20, 30, 15, 20});
		int length = colors.length;
		for(int i = 0; i < length; i++) {
			XYSeriesRenderer r = new XYSeriesRenderer();
			r.setColor(colors[i]);
			r.setPointStyle(styles[i]);
			renderer.addSeriesRenderer(r);
		}
	}
	
	protected XYMultipleSeriesDataset buildDataset(String[] titles, List<double[]> x, List<double[]> values ) {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		addXYSeries(dataset, titles, x, values, 0);
		return dataset;
	}
	
	protected void addXYSeries(XYMultipleSeriesDataset dataset, String[] titles, List<double[]> x, List<double[]> values, int scale) {
		int length = titles.length;
		for(int i = 0; i < length; i++) {
			XYSeries series = new XYSeries(titles[i], scale);
			double[] xV = x.get(i);
			double[] yV = values.get(i);
			int seriesLength = xV.length;
			for(int k = 0; k < seriesLength; k++) {
				series.add(xV[k], yV[k]);
			}
			dataset.addSeries(series);
		}
	}
	
}
