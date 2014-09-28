package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;

public class AreaActivity extends Activity {

	@Override
	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area);
	}
	
	/* Performs conversion from square meters to square feet, rounding to two decimal places
	 * @param area input by user
	 * @return string of converted value to square feet, rounded to two decimal places
	 */
	public String metToFt(double yourArea){
		double feet = yourArea/10.7639;
		double feetRound = Math.round(feet * 100.0) / 100.0;
		return String.valueOf(feetRound);
	}
	
	/* Performs conversion from square feet to square meters, rounding to two decimal places
	 * @param area input by user
	 * @return string of converted value to square meters, rounded to two decimal places
	 */
	public String ftToMet(double yourArea){
		double meters = yourArea*10.7639;
		double metersRound = Math.round(meters * 100.0) / 100.0;
		return String.valueOf(metersRound);
	}
}
