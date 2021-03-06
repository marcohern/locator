package com.rocketteam.locator;

import com.rocketteam.locator.activity.MainActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class DummyAsyncTask extends AsyncTask<String, Integer, String> {

	private MainActivity activity;
	private ProgressDialog progressDialog;
	private static final String logTag = "DummyAsyncTask";
	
	public DummyAsyncTask(MainActivity activity){
		super();
		this.activity = activity;
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
			Thread.sleep(5000);
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
