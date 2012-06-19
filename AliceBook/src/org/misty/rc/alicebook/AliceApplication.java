package org.misty.rc.alicebook;

import android.app.Application;
import android.content.Context;

public class AliceApplication extends Application {
	private Context _context;
	
	public void setContext(Context context) {
		this._context = context;
	}
	
	public Context getContext() {
		return this._context;
	}
}
