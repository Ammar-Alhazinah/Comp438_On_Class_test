package edu.cs.birzeit.a1172482.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText weight,height  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.edtWeight);
        height = findViewById(R.id.edtHeight);
    }

    public void btnRun_onClick(View view) {
    String weightStr = weight.getText().toString().trim();
    String heightStr = height.getText().toString().trim();

    float weightVal = Float.parseFloat(weightStr);
    float heigtVal = Float.parseFloat(heightStr)/100;

    float bmi = weightVal/(heigtVal*heigtVal);
    if(bmi<16){
        Toast.makeText(this, "Severely Under Weight", Toast.LENGTH_SHORT).show();

    }
    else if(bmi<18.5){
        Toast.makeText(this, "Under Weight", Toast.LENGTH_SHORT).show();

    }else if(bmi >= 18.5 && bmi <= 24.9){
        Toast.makeText(this, "Normal Weight", Toast.LENGTH_SHORT).show();

    }else if(bmi >= 25 && bmi <= 29.9){
        Toast.makeText(this, "OverWeight", Toast.LENGTH_SHORT).show();

    }else{
        Toast.makeText(this, "You have a real problem!!", Toast.LENGTH_SHORT).show();
    }
        InputMethodManager mgr =(InputMethodManager) getSystemService(ContextThemeWrapper.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

    }
}