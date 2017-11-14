package com.hackinfinity.farmhelp_serviceprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CardView seed = (CardView) findViewById(R.id.seed);
        CardView fertilizer = (CardView) findViewById(R.id.ferti);
        CardView transportation = (CardView) findViewById(R.id.trans);
        CardView hardware = (CardView) findViewById(R.id.hardware);
        CardView market = (CardView)findViewById(R.id.market);

        seed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seed();
            }
        });
        transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transportation();
            }
        });
        hardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hardware();
            }
        });
        fertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fertilizer();
            }
        });
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                market();
            }
        });

    }

    private void market()
    {
        Intent intent = new Intent(this,FormActivity.class);
        intent.putExtra("service",'m');
        startActivity(intent);
    }

    public void seed()
    {
        Intent intent = new Intent(Main2Activity.this,FormActivity.class);
        intent.putExtra("service",'s');
        startActivity(intent);

    }
    public void fertilizer()
    {
        Intent intent = new Intent(Main2Activity.this,FormActivity.class);
        intent.putExtra("service",'f');
        startActivity(intent);

    }

    public void transportation ()
    {
        Intent intent = new Intent(Main2Activity.this,FormActivity.class);
        intent.putExtra("service",'t');
        startActivity(intent);

    }

    public void hardware()
        {
        Intent intent = new Intent(Main2Activity.this,FormActivity.class);
        intent.putExtra("service",'h');
        startActivity(intent);

        }

}
