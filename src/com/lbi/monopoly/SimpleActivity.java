package com.lbi.monopoly;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.lbi.monopoly.activities.PubListActivity;
import com.lbi.monopoly.model.Pub;
import com.lbi.monopoly.parser.MonopolyParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends MapActivity {

	private Pub pub;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.pub = (Pub) getIntent().getExtras().get("pub");

		setContentView(R.layout.main);

		TextView pubname = (TextView) findViewById(R.id.pubname);
		pubname.setText(this.pub.getName());

		TextView pubdirections = (TextView) findViewById(R.id.pubdirections);
		pubdirections.setText(this.pub.getDirections());

		MapView mapview = (MapView) findViewById(R.id.mapview);

		GeoPoint point = new GeoPoint((int)this.pub.getLocation().getLatitude(),
				(int)this.pub.getLocation().getLongitude());

		MapController mapController = mapview.getController();
		mapController.setCenter(point);

		Button showMapButton = (Button) findViewById(R.id.showmap);
		showMapButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(SimpleActivity.this, PubMapActivity.class);
				SimpleActivity.this.startActivity(i);

			}
		});

		Button showListButton = (Button) findViewById(R.id.show_list);
		showListButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Intent i = new Intent(SimpleActivity.this,
						PubListActivity.class);
				SimpleActivity.this.startActivity(i);

			}
		});
	}

	private List<Pub> loadPubs() {
		MonopolyParser parser = new MonopolyParser(
				"https://raw.github.com/jpsoares/MonopolyPubCrawl/master/res/xml/pubs.xml");
		return parser.parse();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}