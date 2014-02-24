package com.rocketteam.locator.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.rocketteam.locator.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {
	
	private static long splashDelay = 6000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
		        startActivity(mainIntent);
		        finish();
			}
		};
		Log.w("Splash","Before timer");
		Timer t = new Timer();
		t.schedule(task, splashDelay);
	}
}
