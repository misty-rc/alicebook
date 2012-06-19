package org.misty.rc.alicebook;

import java.util.Map;

import org.misty.rc.alicebook.fragment.MainFragmentAdapter;
import org.misty.rc.alicebook.pref.AliceBookPreference;
import org.misty.rc.alicebook.pref.KeyReference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class AliceBookActivity extends FragmentActivity {
	MainFragmentAdapter _adapter;
	ViewPager _pager;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        // application class
        AliceApplication _alice = new AliceApplication();
        
        // set fragment
        _adapter = new MainFragmentAdapter(getSupportFragmentManager());
        _pager = (ViewPager)findViewById(R.id.mainpager);
        _pager.setAdapter(_adapter);
        _pager.setCurrentItem(1);
    }
    
    private static final int MENU_SELECT_A = 0;
    private static final int MENU_SELECT_B = 1;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_SELECT_A, 0, "Test");
		menu.add(0, MENU_SELECT_B, 0, "Preference");
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_SELECT_A:
			return true;
		case MENU_SELECT_B:
			openPref();
			return true;
		}
		return false;
	}
    
	
	private void openPref() {
		Intent intent = new Intent(this, AliceBookPreference.class);
		startActivity(intent);
	}
	
    
}