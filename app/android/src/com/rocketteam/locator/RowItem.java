package com.rocketteam.locator;

public class RowItem {
	private String label;
	private int imageId;
	
	public RowItem() {
		this(0, "");
	}
	
	public RowItem(int imageId, String label) {
		this.imageId = imageId;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
}
