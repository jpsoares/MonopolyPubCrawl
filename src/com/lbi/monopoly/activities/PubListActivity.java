package com.lbi.monopoly.activities;

import java.util.ArrayList;
import java.util.List;

import com.lbi.monopoly.R;
import com.lbi.monopoly.adapters.PubAdapter;
import com.lbi.monopoly.model.Pub;
import com.lbi.monopoly.parser.PubLoader;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PubListActivity extends ListActivity {
	
	PubAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		adapter = new PubAdapter(this, R.layout.pubrowlayout, new ArrayList<Pub>());
		
		Runnable run = new Runnable() {
			
			public void run() {
				final List<Pub> pubs = PubLoader.loadPubs();
				runOnUiThread(new Runnable() {
					
					public void run() {
						adapter.clear();
						for(Pub pub : pubs){
							adapter.add(pub);
						}
						adapter.notifyDataSetChanged();
					}
				});
			}
		};
		
		Thread thread = new Thread(run);
		thread.start();
		
		
		this.setListAdapter(adapter);
	}
}
