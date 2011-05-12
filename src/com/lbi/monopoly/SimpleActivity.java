package com.lbi.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView t = (TextView) findViewById(R.id.textview);
        t.setText("new text");
        
        Button showMapButton = (Button) findViewById(R.id.showmap);
        showMapButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent(SimpleActivity.this, PubMapActivity.class);
				SimpleActivity.this.startActivity(i);
				
			}
		});
    }
}