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
		return String.valueOf(dollar);
	}
	
	public String dollarToEuro(double yourCurrency){
		double euro = yourCurrency/0.78842;
		return String.valueOf(euro);
	}
}
