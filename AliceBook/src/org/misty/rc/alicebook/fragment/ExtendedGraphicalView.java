package org.misty.rc.alicebook.fragment;

import org.achartengine.chart.AbstractChart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ExtendedGraphicalView extends View {
	private AbstractChart mChart;
	private Paint mPaint = new Paint();
	
	public ExtendedGraphicalView(Context context, AbstractChart chart) {
		super(context);
		mChart = chart;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		mChart.draw(canvas, 0, 0, getWidth(), getHeight(), mPaint);
	}
}
