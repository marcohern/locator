package com.rocketteam.locator.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class SearchSiteActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    //setContentView(R.layout.search);
		Intent intent = getIntent();
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	    	String query = intent.getStringExtra(SearchManager.QUERY);
	    	executeSearch(query);
	    } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {
	    	
	        Uri data = intent.getData();
	        showResult(data);
	    }
	}
	
	private void showResult(Uri data) {
		Log.w("Search","Executing result '" + data + "'");
	}

	private void executeSearch(String query) {
		Log.w("Search","Executing query '" + query + "'");
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		Log.w("Search","Requested");
		return super.onSearchRequested();
	}
}
