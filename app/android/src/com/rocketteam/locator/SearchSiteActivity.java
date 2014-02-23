package com.rocketteam.locator;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SearchSiteActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.search);
		
		Intent intent = getIntent();
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	      String query = intent.getStringExtra(SearchManager.QUERY);
	      executeSearch(query);
	    }
	}
	
	private void executeSearch(String query) {
		// TODO Auto-generated method stub
		Log.w("Search","Executing search");
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		Log.w("Search","Requested");
		return super.onSearchRequested();
	}
}
