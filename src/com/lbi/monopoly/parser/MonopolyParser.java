package com.lbi.monopoly.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.lbi.monopoly.model.Location;
import com.lbi.monopoly.model.Pub;

import android.os.Message;
import android.util.Xml;

public class MonopolyParser extends BaseFeedParser {
	private final static String MONOPOLY = "monopoly";
	private final static String PUBS = "pubs";
	private final static String PUB = "pub";
	private final static String PUB_NAME = "name";
	private final static String PUB_LOCATION = "location";
	private final static String PUB_IMAGES = "images";
	private final static String PUB_IMAGE = "image";
	private final static String PUB_CHECKIN_DATE = "checkInDate";
	private final static String PUB_DIRECTIONS = "directions";
	private final static String LOCATION_LONGITUDE = "longitude";
	private final static String LOCATION_LATITUDE = "latitude";
	private final static String IMAGE_PATH = "path";
	private final static String IMAGE_DESCRIPTION = "description";

	public MonopolyParser(String feedUrl) {
		super(feedUrl);
	}

	public List<Pub> parse() {
		List<Pub> pubs = null;
		XmlPullParser parser = Xml.newPullParser();
		try {
			// auto-detect the encoding from the stream
			parser.setInput(this.getInputStream(), null);
			int eventType = parser.getEventType();
			Pub currentMessage = null;
			boolean done = false;
			while (eventType != XmlPullParser.END_DOCUMENT && !done) {
				String name = null;
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					pubs = new ArrayList<Pub>();
					break;
				case XmlPullParser.START_TAG:
					name = parser.getName();
					if (name.equalsIgnoreCase(PUB)) {
						currentMessage = new Pub();
					} else if (currentMessage != null) {
						if (name.equalsIgnoreCase(PUB_NAME)) {
							currentMessage.setName(parser.nextText());
						} else if (name.equalsIgnoreCase(PUB_LOCATION)) {
							currentMessage.setLocation(new Location());
							
						} else if (name.equalsIgnoreCase(PUB_CHECKIN_DATE)) {
							currentMessage.setCheckinDate(new Date(parser.nextText()));
						} else if (name.equalsIgnoreCase(PUB_DIRECTIONS)) {
							currentMessage.setDirections((parser.nextText()));
						}
					}
					break;
				case XmlPullParser.END_TAG:
					name = parser.getName();
					if (name.equalsIgnoreCase(PUB) && currentMessage != null) {
						pubs.add(currentMessage);
					} else if (name.equalsIgnoreCase(MONOPOLY)) {
						done = true;
					}
					break;
				}
				eventType = parser.next();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return pubs;
	}
}
