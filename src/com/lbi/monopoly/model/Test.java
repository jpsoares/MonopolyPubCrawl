package com.lbi.monopoly.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Pub pub = new Pub();
		pub.setCheckinDate(new Date());
		pub.setDirections("test directions");
		pub.setName("Pub name");
		
		Image image = new Image();
		image.setDescription("image decription");
		image.setPath("imagepath");
		List<Image> images = new ArrayList<Image>();
		images.add(image);
		pub.setImages(images);
		
		Location location = new Location();
		location.setLatitude(0);
		location.setLongitude(0);
		pub.setLocation(location);
		
		
	}
}
