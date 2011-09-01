package com.lbi.monopoly.model;

import java.io.Serializable;

public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3521147617081278322L;
	private long longitude;
	private long latitude;

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
}
