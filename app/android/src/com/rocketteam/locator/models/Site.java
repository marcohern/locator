package com.rocketteam.locator.models;

import java.util.ArrayList;

public class Site {
	private int id;
	private String name;
	private String entityType;
	private double lat;
	private double lng;
	private ArrayList<String> categories;
	private String address;
	private String phoneNumber;
	private String schedule;
	private String email;
	private String web;
	private String contactName;
	private String contactEmail;
	private String contactPhoneNumber;
	private String facebookUrl;
	private String youtubeUrl;
	private String imageUrl;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEntityType() { return entityType; }
	public void setEntityType(String entity_type) { this.entityType = entity_type; }

	public double getLat() { return lat; }
	public void setLat(double lat) { this.lat = lat; }

	public double getLng() { return lng; }
	public void setLng(double lng) { this.lng = lng; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public ArrayList<String> getCategories() { return categories; }
	public void setCategories(ArrayList<String> categories) { this.categories = categories; }

	public String getSchedule() { return schedule; }
	public void setSchedule(String schedule) { this.schedule = schedule; }

	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getContactName() { return contactName; }
	public void setContactName(String contactName) { this.contactName = contactName; }

	public String getWeb() { return web; }
	public void setWeb(String web) { this.web = web; }

	public String getContactPhoneNumber() { return contactPhoneNumber; }
	public void setContactPhoneNumber(String contactPhoneNumber) { this.contactPhoneNumber = contactPhoneNumber; }

	public String getContactEmail() { return contactEmail; }
	public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

	public String getFacebookUrl() { return facebookUrl; }
	public void setFacebookUrl(String facebookUrl) { this.facebookUrl = facebookUrl; }

	public String getYoutubeUrl() { return youtubeUrl; }
	public void setYoutubeUrl(String youtubeUrl) { this.youtubeUrl = youtubeUrl; }

	public String getImageUrl() { return imageUrl; }
	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
	
}
