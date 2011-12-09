package com.lbi.monopoly.adapters;

import java.util.List;

import com.lbi.monopoly.R;
import com.lbi.monopoly.activities.PubActivity;
import com.lbi.monopoly.model.Pub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PubAdapter extends ArrayAdapter<Pub> {
	List<Pub> items;

	public PubAdapter(Context context, int textViewResourceId, List<Pub> items) {
		super(context, textViewResourceId, items);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.pubrowlayout, null);
		}

		setPub(position, convertView);

		return convertView;

	}

	private void setPub(int position, View v) {
		final Pub pub = this.items.get(position);
		if (pub != null) {
			final TextView pubName = (TextView) v.findViewById(R.id.pub_name);
			if (pubName != null) {
				pubName.setText(pub.getName());
			}

			final TextView pubDistance = (TextView) v
					.findViewById(R.id.pub_distance);
			if (pubDistance != null) {
				pubDistance.setText("0 meters");
			}
			
			v.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					Intent i = new Intent(v.getContext(), PubActivity.class);
					i.putExtra("pub", pub);
					
					v.getContext().startActivity(i);
				}
			});
		}
		
	}

}
