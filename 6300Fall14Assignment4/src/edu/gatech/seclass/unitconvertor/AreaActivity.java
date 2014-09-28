package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AreaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area);
	}
	public String metToFt(double yourArea){
		double feet = yourArea/10.7639;
		double feetr = Math.round(feet * 100.0) / 100.0;
		return String.valueOf(feetr);
	}
	
	public String ftToMet(double yourArea){
		double meters = yourArea*10.7639;
		double metersr = Math.round(meters * 100.0) / 100.0;
		return String.valueOf(metersr);
	}
}
