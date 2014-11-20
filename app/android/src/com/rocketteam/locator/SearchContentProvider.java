package com.rocketteam.locator;

import java.util.ArrayList;
import java.util.Locale;

import com.rocketteam.locator.models.SiteIndex;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class SearchContentProvider extends ContentProvider {
	public static final Uri CONTENT_URI =
			Uri.parse("com.rocketteam.locator.searchcontentprovider");

	private static final int SUGGEST_QUERY = 1;
	private static final int SITE_INDEX = 2;
	
	private static final UriMatcher sUriMatcher;

	public static final int SITE_INDEX_ID = 1;
	public static final int SITE_INDEX_NAME = 2;
	public static final int SITE_INDEX_ADDRESS = 3;
	
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(CONTENT_URI.toString(), "search_suggest_query/*", SUGGEST_QUERY);
	}

	@Override
	public String getType(Uri uri) {
		switch(sUriMatcher.match(uri)) {
		case SITE_INDEX:
		case SUGGEST_QUERY: return CONTENT_URI.toString();
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
		
		String q = uri.getLastPathSegment().toLowerCase(Locale.getDefault());
		int m = sUriMatcher.match(uri);

		switch(m) {
		case SITE_INDEX:
		case SUGGEST_QUERY: return querySiteIndex(q);
		default: return null;
		}

	}

	private Cursor querySiteIndex(String q) {
		String[] columns = { "_id", SearchManager.SUGGEST_COLUMN_TEXT_1, SearchManager.SUGGEST_COLUMN_TEXT_2 };
		MatrixCursor matrixCursor= new MatrixCursor(columns);
		ArrayList<SiteIndex> index = LocatorTestData.get();
		for (int i=0; i < index.size(); i++) {
			SiteIndex si = index.get(i);
			
			if (si.getName().toLowerCase(Locale.getDefault()).contains(q)) {
				matrixCursor.addRow(new Object[] {i, index.get(i).getName(), index.get(i).getAddress() });
			}
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
