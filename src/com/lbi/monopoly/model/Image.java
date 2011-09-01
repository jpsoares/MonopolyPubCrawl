package com.lbi.monopoly.model;

import java.io.Serializable;

public class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 948851026653619435L;
	private String path;
	private String description;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
