package cs474.ternaryCalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	int firstOperand, secondOperand;
	boolean isFirstOperand, newValue, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Set the operands
        firstOperand = secondOperand = 0;
        isFirstOperand = true;
        newValue = true;
        add = false;
        
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /*Add responses to all the buttons clicked */
    
    public void zeroButtonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.resultTextView);
        if (newValue) {
        	text.setText("0");
        	newValue = false;
        }
        else text.setText(text.getText() + "0");
    }
    
    public void oneButtonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.resultTextView);
        if (newValue) {
        	text.setText("1");
        	newValue = false;
        }
        else text.setText(text.getText() + "1");
    }
    
    public void twoButtonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.resultTextView);
        if (newValue) {
        	text.setText("2");
        	newValue = false;
        }
        else text.setText(text.getText() + "2");
    }
    
    public void addButtonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.resultTextView);
        if (isFirstOperand) {
        	firstOperand = Integer.parseInt(text.getText().toString()); 
        	newValue = true;
        	isFirstOperand = false;
        	add = true;
        }
    }
    
    public void subtractButtonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.resultTextView);
        if (isFirstOperand) {
        	firstOperand = Integer.parseInt(text.getText().toString());  
        	text.setText("0");
        	newValue = true;
        	isFirstOperand = false;
        	add = false;
        }
    }
    
    public void equalButtonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.resultTextView);
        if (!isFirstOperand) {
        	int result;
        	secondOperand = Integer.parseInt(text.getText().toString());
        	
        	//convert values to decimal. do operation and then convert them back        	
        	firstOperand = ternaryToDecimal(firstOperand); 
    		secondOperand = ternaryToDecimal(secondOperand);
    		
        	if (add) {        		
        		result = firstOperand + secondOperand;
        		result = decimalToTernary(result);
        	}
        	else {
        		result = firstOperand - secondOperand;
        		result = decimalToTernary(result);
        	}
        	text.setText(Integer.toString(result));
        	isFirstOperand = newValue = true;
        }
    }
    
    private int decimalToTernary(int input) {
    	String result = Integer.toString(input,3);
    	return Integer.parseInt(result);
    }
    
    private int ternaryToDecimal(int input) {    	
    	String inputS = Integer.toString(input);
    	return Integer.valueOf(inputS, 3);
    }
    
}
