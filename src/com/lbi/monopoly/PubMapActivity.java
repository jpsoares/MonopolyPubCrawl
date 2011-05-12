package com.lbi.monopoly;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class PubMapActivity extends MapActivity {

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.pubmap);
	}

}
