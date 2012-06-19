package org.misty.rc.alicebook.pref;

import org.misty.rc.alicebook.R;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

public class AliceBookPreference extends PreferenceActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
		screen.setTitle("Screen Title");
		setPreferenceScreen(screen);
		
		// common category
		PreferenceCategory category_common = new PreferenceCategory(this);
		category_common.setTitle(R.string.pref_category_common);
		screen.addPreference(category_common);
		// test flag1
		CheckBoxPreference testflag1 = new CheckBoxPreference(this);
		testflag1.setKey(KeyReference.PrefCommonsFlag1);
		testflag1.setTitle(R.string.pref_item_commons_set_flag_1);
		testflag1.setSummary(R.string.pref_item_commons_set_flag_1_summary);
		testflag1.setDefaultValue(false);
		category_common.addPreference(testflag1);
		
		
		// debug category
		PreferenceCategory category_debug = new PreferenceCategory(this);
		category_debug.setTitle(R.string.pref_category_debug);
		screen.addPreference(category_debug);
		// debug clear init flag
		CheckBoxPreference debug_clear = new CheckBoxPreference(this);
		debug_clear.setKey(KeyReference.PrefDebugClearFlags);
		debug_clear.setTitle(R.string.pref_item_debug_clear_init_flag);
		debug_clear.setSummary(R.string.pref_item_debug_clear_init_flag_summary);
		debug_clear.setDefaultValue(false);
		category_debug.addPreference(debug_clear);
		
//		addPreferencesFromResource(R.xml.alicebook_pref);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
