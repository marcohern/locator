package com.rocketteam.locator;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView left = (ListView)findViewById(R.id.left_drawer);
        createRowListView(left);
        LocatorTestData.init();
    }
    
    protected void createSimpleTextListView(ListView lv) {
    	String[] values = new String[] {
        	"Android List View", 
            "Adapter implementation",
            "Simple List View In Android",
            "Create List View Android", 
            "Android Example", 
            "List View Source Code", 
            "List View Array Adapter", 
            "Android Example List View" 
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, values);
        lv.setAdapter(adapter);
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
		Intent intent = new Intent(MainActivity.this, com.rocketteam.locator.LocatorPreferenceActivity.class);
		startActivity(intent);
		return true;
	}


	private boolean openSearchBox() {
		onSearchRequested();
		return true;
	}
}
