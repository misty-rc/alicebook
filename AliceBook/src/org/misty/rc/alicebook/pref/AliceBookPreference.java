package org.misty.rc.alicebook.pref;

import org.misty.rc.alicebook.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class AliceBookPreference extends PreferenceActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.alicebook_pref);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
