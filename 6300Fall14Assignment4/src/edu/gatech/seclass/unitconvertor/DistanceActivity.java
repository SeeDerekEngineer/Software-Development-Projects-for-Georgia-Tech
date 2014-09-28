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
		return String.valueOf(miles);
	}
	
	public String milesToKm(double yourDistance){
		double kilom = yourDistance*1.609;
		return String.valueOf(kilom);
	}
	
}
