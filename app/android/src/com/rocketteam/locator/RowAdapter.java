package com.rocketteam.locator;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowAdapter extends ArrayAdapter<RowItem> {

	public RowAdapter(Context context, int resource, int textViewResourceId,
			List<RowItem> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Context ctx = getContext();
		RowItem item = getItem(position);
		
		LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.row, parent, false);
		TextView textView = (TextView)row.findViewById(R.id.rowText);
		ImageView imageView = (ImageView)row.findViewById(R.id.rowImage);
		
		textView.setText(item.getLabel());
		imageView.setImageResource(item.getImageId());
		return row;
	}
	
}
