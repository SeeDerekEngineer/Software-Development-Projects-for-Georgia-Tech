package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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
	
	//Initializes variables to be used with toast message
	CharSequence text = "Please enter a number before hitting the button.";
	int duration = Toast.LENGTH_SHORT;
	
	/* Performs unit conversion when radio buttons are clicked in the 'Distance' portion of the app
	 * @param current RadioButton view being clicked
	 */
	public void handleDistanceClick(View yourView){
		double distance;
		boolean checked = ((RadioButton) yourView).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText1);
		if(txt.getText().toString().matches("") || txt.getText().toString().matches("\\.")){
			Toast toast = Toast.makeText(getApplicationContext(), text, duration);
			toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,1);
			toast.show();
			txt.setText("");
			return;
		}
		else{distance = Double.parseDouble(txt.getText().toString());}
		
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
		double area;
		boolean checked = ((RadioButton) yourView).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText2);
		if(txt.getText().toString().matches("") || txt.getText().toString().matches("\\.")){
			Toast toast = Toast.makeText(getApplicationContext(), text, duration);
			toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,1);
			toast.show();
			txt.setText("");
			return;
		}
		else{area = Double.parseDouble(txt.getText().toString());}
		
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
		double currency;
		boolean checked = ((RadioButton) yourView).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText3);
		if(txt.getText().toString().matches("") || txt.getText().toString().matches("\\.")){
			Toast toast = Toast.makeText(getApplicationContext(), text, duration);
			toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,1);
			toast.show();
			txt.setText("");
			return;
		}
		else{currency = Double.parseDouble(txt.getText().toString());}
		
		
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