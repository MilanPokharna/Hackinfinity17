package com.hackinfinity.farmhelp_serviceprovider;

import android.annotation.SuppressLint;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.nio.Buffer;

import static com.hackinfinity.farmhelp_serviceprovider.R.color.colorAccent;

public class FormActivity extends AppCompatActivity {


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        TextInputEditText seedValue = (TextInputEditText) findViewById(R.id.name);
        TextInputEditText price = (TextInputEditText) findViewById(R.id.price);
        TextInputEditText quantity = (TextInputEditText)findViewById(R.id.quantity);
        switch (getIntent().getCharExtra("service",'a'))
        {
            case 's' :
                seedValue.setHint("Seed Name");
                quantity.setHint("Quantity");
                price.setHint("price/kg");
                break;
            case 'f':
                seedValue.setHint("Fertilizer Name");
                quantity.setHint("Quantity");
                price.setHint("price/kg");
                break;
            case 't':
                price.setHint("Rent/km");
                quantity.setHint("Quantity");
                seedValue.setHint("Vehicle Name");
                break;
            case 'h':
                price.setHint("cost of machine");
                quantity.setHint("Rent/hr");
                seedValue.setHint("Machine Name");
                break;
            case 'm' :
                seedValue.setHint("Mandi Name");
                quantity.setHint("Crop Name");
                price.setHint("price/kg");
                break;

        }
        Button submitInfo = (Button) findViewById(R.id.submit);
        submitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitInfo();
            }
        });
    }

        public void submitInfo()
        {

            Toast.makeText(this, "Your Stock has been uploaded successfully", Toast.LENGTH_SHORT).show();

            TextInputEditText name = (TextInputEditText) findViewById(R.id.name);
            TextInputEditText price = (TextInputEditText) findViewById(R.id.price);
            TextInputEditText quantity = (TextInputEditText)findViewById(R.id.price);


            name.setHint("");
            finish();

        }

}
