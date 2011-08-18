package com.lbi.monopoly.parser;

import java.util.List;

import com.lbi.monopoly.model.Pub;

public class PubLoader {

	public static List<Pub> loadPubs() {
		MonopolyParser parser = new MonopolyParser(
				"https://raw.github.com/jpsoares/MonopolyPubCrawl/master/res/xml/pubs.xml");
		return parser.parse();
	}
}
