package com.lbi.monopoly.activities;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.lbi.monopoly.R;
import com.lbi.monopoly.R.layout;

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
