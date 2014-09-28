package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;

public class DistanceActivity extends Activity {

	@Override
	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
	}

	/* Performs conversion from kilometers to miles, rounding to two decimal places
	 * @param distance input by user
	 * @return string of converted value to miles, rounded to two decimal places
	 */
	public String kmToMiles(double yourDistance){
		double miles = yourDistance/1.609;
		double milesRound = Math.round(miles * 100.0) / 100.0;
		return String.valueOf(milesRound);
	}
	
	/* Performs conversion from miles to kilometers, rounding to two decimal places
	 * @param distance input by user
	 * @return string of converted value to kilometers, rounded to two decimal places
	 */
	public String milesToKm(double yourDistance){
		double kilom = yourDistance*1.609;
		double kilomRound = Math.round(kilom * 100.0) / 100.0;
		return String.valueOf(kilomRound);
	}
	
}
