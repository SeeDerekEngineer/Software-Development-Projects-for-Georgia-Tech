package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DistanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
	}
	public String kmToMiles(double yourDistance){
		double miles = yourDistance/1.609;
		double milesr = Math.round(miles * 100.0) / 100.0;
		return String.valueOf(milesr);
	}
	
	public String milesToKm(double yourDistance){
		double kilom = yourDistance*1.609;
		double kilomr = Math.round(kilom * 100.0) / 100.0;
		return String.valueOf(kilomr);
	}
	
}
