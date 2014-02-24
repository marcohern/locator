package com.rocketteam.locator.activity;

import com.rocketteam.locator.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class LocatorPreferenceActivity extends PreferenceActivity {
	
	private static String KEY_LANGUAGE = "pref_lang";
	private static String KEY_FACEBOOK_LOGIN = "pref_facebook_login";

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		String lang = sharedPref.getString(KEY_LANGUAGE, "ES");
		Boolean login = sharedPref.getBoolean(KEY_FACEBOOK_LOGIN, false);
		Log.w("Settings Lang", lang);
		Log.w("Settings login", "" + login);
		
		ListPreference languages = (ListPreference)findPreference(KEY_LANGUAGE);
		languages.setSummary(languages.getEntry());
		languages.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				ListPreference lp = (ListPreference) preference;
				lp.setValue(newValue.toString());
				lp.setSummary(lp.getEntry());
				
				Log.w("Settings Lang", lp.getEntry().toString());
				return false;
			}
		});
		
	}
	

}
