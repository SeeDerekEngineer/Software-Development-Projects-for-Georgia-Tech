package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//Declare new instances of each activity
	DistanceActivity newDistance = new DistanceActivity();
	AreaActivity newArea = new AreaActivity();
	CurrencyActivity newCurrency = new CurrencyActivity();
	
	/* Performs unit conversion when radio buttons are clicked in the 'Distance' portion of the app
	 * @param current RadioButton view being clicked
	 */
	public void handleDistanceClick(View yourView){
		boolean checked = ((RadioButton) yourView).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText1);
		double distance = Double.parseDouble(txt.getText().toString());
		
		 switch(yourView.getId()){
			case R.id.radio0:
				if(checked)
					txt.setText(newDistance.kmToMiles(distance));
					break;
			case R.id.radio1:
				if(checked)
					txt.setText(newDistance.milesToKm(distance));
					break;
		}
	
	}
	
	/* Performs unit conversion when radio buttons are clicked in the 'Area' portion of the app
	 * @param current RadioButton view being clicked
	 */
	public void handleAreaClick(View yourView){
		boolean checked = ((RadioButton) yourView).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText2);
		double area = Double.parseDouble(txt.getText().toString());
		
		switch(yourView.getId()){
			case R.id.radio3:
				if(checked)
					txt.setText(newArea.metToFt(area));
					break;
			case R.id.radio2:
				if(checked)
					txt.setText(newArea.ftToMet(area));
					break;
		
		}
	}
	
	/* Performs unit conversion when radio buttons are clicked in the 'Currency' portion of the app
	 * @param current RadioButton view being clicked
	 */
	public void handleCurrencyClick(View yourView){
		boolean checked = ((RadioButton) yourView).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText3);
		double currency = Double.parseDouble(txt.getText().toString());
		
		switch(yourView.getId()){
			case R.id.radio5:
				if(checked)
					txt.setText(newCurrency.euroToDollar(currency));
					break;
			case R.id.radio4:
				if(checked)
					txt.setText(newCurrency.dollarToEuro(currency));
					break;
		}
	}
}	