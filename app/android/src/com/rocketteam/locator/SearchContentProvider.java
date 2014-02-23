package com.rocketteam.locator;

import java.util.ArrayList;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class SearchContentProvider extends ContentProvider {
	private static final int SITE_INDEX = 1;
	private static final UriMatcher sUriMatcher;
	
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI("com.rocketteam.locator.SearchContentProvider", "site_index", SITE_INDEX);
	}

	@Override
	public String getType(Uri uri) {
		switch(sUriMatcher.match(uri)) {
		case SITE_INDEX: return "com.rocketteam.locator.SearchContentProvider";
		default: throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		switch(sUriMatcher.match(uri)) {
		case SITE_INDEX: return querySiteIndex();
		default: return null;
		}
	}

	private Cursor querySiteIndex() {
		String[] columns = { "_id", "name", "address" };
		MatrixCursor matrixCursor= new MatrixCursor(columns);
		ArrayList<SiteIndex> index = LocatorTestData.get();
		for (int i=0; i < index.size(); i++) {
			matrixCursor.addRow(new Object[] {i, index.get(i).getName(), index.get(i).getAddress() });
		}
		return matrixCursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
