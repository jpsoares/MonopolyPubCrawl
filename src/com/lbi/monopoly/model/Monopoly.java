package com.lbi.monopoly.model;

import java.io.Serializable;
import java.util.List;

public class Monopoly implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7801869993964898132L;
	private List<Pub> pubs;

	public List<Pub> getPubs() {
		return pubs;
	}

	public void setPubs(List<Pub> pubs) {
		this.pubs = pubs;
	}
}
