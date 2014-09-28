package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CurrencyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
	}
	public String euroToDollar(double yourCurrency){
		double dollar = yourCurrency*0.78842;
		double dollarr = Math.round(dollar * 100.0) / 100.0;
		return String.valueOf(dollarr);
	}
	
	public String dollarToEuro(double yourCurrency){
		double euro = yourCurrency/0.78842;
		double euror = Math.round(euro * 100.0) / 100.0;
		return String.valueOf(euror);
	}
}
