package com.rocketteam.locator;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class DummyAsyncTask extends AsyncTask<String, Integer, String> {

	private Context context;
	private MainActivity activity;
	private ProgressDialog progressDialog;
	private static final String logTag = "DummyAsyncTask";
	
	public DummyAsyncTask(MainActivity activity){
		super();
		this.activity = activity;
		this.context = activity.getApplicationContext();
		Log.w(logTag, "DummyAsyncTask");
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		progressDialog = ProgressDialog.show(activity, "Loading", "please wait");
		Log.w(logTag, "onPreExecute");
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		Log.w(logTag, "onProgressUpdate");
	}
	
	@Override
	protected String doInBackground(String... params) {
		Log.w(logTag, "doInBackground");
		try {
			Thread.sleep(10000);
		}catch(InterruptedException ex) {
			
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		progressDialog.dismiss();
		Log.w(logTag, "onPostExecute");
	}

}
