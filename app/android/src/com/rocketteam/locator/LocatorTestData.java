package com.rocketteam.locator;

import java.util.ArrayList;

import com.rocketteam.locator.models.SiteIndex;

public class LocatorTestData {
	private static final ArrayList<SiteIndex> siteIndex = new ArrayList<SiteIndex>();
	
	public static void init() {
		siteIndex.add(new SiteIndex("Unicentro","Calle 15 con cra. 127"));
		siteIndex.add(new SiteIndex("Unilago","Calle 15 con Cra. 79"));
		siteIndex.add(new SiteIndex("Globant","Cra. 26 con Calle 68B"));
		siteIndex.add(new SiteIndex("Intcomex","Calle 72 con Cra. 14"));
	}
	
	public static ArrayList<SiteIndex> get() {
		return siteIndex;
	}
}
