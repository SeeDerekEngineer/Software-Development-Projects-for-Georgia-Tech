package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;

public class CurrencyActivity extends Activity {

	@Override
	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
	}
	
	/* Performs conversion from Euros to US Dollars, rounding to two decimal places
	 * @param currency input by user
	 * @return string of converted value to Dollars, rounded to two decimal places
	 */
	public String euroToDollar(double yourCurrency){
		double dollar = yourCurrency*0.78842;
		double dollarRound = Math.round(dollar * 100.0) / 100.0;
		return String.valueOf(dollarRound);
	}
	
	/* Performs conversion from US Dollars to Euros, rounding to two decimal places
	 * @param currency input by user
	 * @return string of converted value to Euros, rounded to two decimal places
	 */
	public String dollarToEuro(double yourCurrency){
		double euro = yourCurrency/0.78842;
		double euroRound = Math.round(euro * 100.0) / 100.0;
		return String.valueOf(euroRound);
	}
}
