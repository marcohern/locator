package com.rocketteam.locator.activity;

import java.util.ArrayList;

import com.rocketteam.locator.DummyAsyncTask;
import com.rocketteam.locator.LocatorTestData;
import com.rocketteam.locator.R;
import com.rocketteam.locator.RowAdapter;
import com.rocketteam.locator.RowItem;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	private static String logTag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocatorTestData.init();
        
        DummyAsyncTask dat = new DummyAsyncTask(this);
        try {
        	dat.execute("this is a test");
        } catch(Exception ex) {
        	dat.cancel(true);
        	alert(ex.getMessage());
        }
    }
    
    protected void alert(String message) {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage(message);
    	builder.setTitle("Error");
    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	dialog.dismiss();
            }
    	});
    	AlertDialog dialog = builder.create();
    	dialog.show();
    }
    
    protected void createRowListView(ListView lv) {
    	ArrayList<RowItem> items = new ArrayList<RowItem>();
    	items.add(new RowItem(R.drawable.common_signin_btn_icon_dark, "Test"));
    	items.add(new RowItem(R.drawable.common_signin_btn_icon_disabled_dark, "Test 2"));
    	
    	RowAdapter adapter = new RowAdapter(this, 0,0, items);
    	lv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	int id = item.getItemId();
    	switch(id) {
	    	case R.id.action_search: return openSearchBox();
	    	case R.id.action_settings: return openSettings();
	    	default: return super.onOptionsItemSelected(item);
    	}
    }


	private boolean openSettings() {
		Intent intent = new Intent(MainActivity.this, LocatorPreferenceActivity.class);
		startActivity(intent);
		return true;
	}


	private boolean openSearchBox() {
		Log.w(logTag,"Search clicked");
		onSearchRequested();
		return true;
	}
}
