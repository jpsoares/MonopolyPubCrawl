package com.lbi.monopoly;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends MapActivity {

	private int latitude = 0;

	private int longitude = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView pubname = (TextView) findViewById(R.id.pubname);
		pubname.setText(getPubName());

		TextView pubdirections = (TextView) findViewById(R.id.pubdirections);
		pubdirections.setText(getPubDirections());

		MapView mapview = (MapView) findViewById(R.id.mapview);

		GeoPoint point = new GeoPoint(this.latitude, this.longitude);

		MapController mapController = mapview.getController();
		mapController.setCenter(point);

		Button showMapButton = (Button) findViewById(R.id.showmap);
		showMapButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(SimpleActivity.this, PubMapActivity.class);
				SimpleActivity.this.startActivity(i);

			}
		});
	}

	private String getPubDirections() {
		// TODO Auto-generated method stub
		return "Turn left, then turn right";
	}

	private String getPubName() {
		// TODO Auto-generated method stub
		return "Test pub";
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}