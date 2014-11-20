package com.rocketteam.locator.activity;

import com.rocketteam.locator.SearchContentProvider;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListAdapter;

public class SearchSiteActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

	@SuppressWarnings("deprecation")
	private void executeSearch(String query) {
		Log.w("Search","Executing query '" + query + "'");
		Cursor mCursor = this.getContentResolver().query(SearchContentProvider.CONTENT_URI, null, null, null, null);
		ListAdapter adapter = new SimpleCursorAdapter(
                this, // Context.
                android.R.layout.two_line_list_item,  // Specify the row template to use (here, two columns bound to the two retrieved cursor rows).
                mCursor,                                              // Pass in the cursor to bind to.
                new String[] {"name", "address"},           // Array of cursor columns to bind to.
                new int[] {android.R.id.text1, android.R.id.text2});  // Parallel array of which template objects to bind to those columns.

        // Bind to our new adapter.
        setListAdapter(adapter);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		Log.w("Search","Requested");
		return super.onSearchRequested();
	}
}
