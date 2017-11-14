package com.hackinfinity.farmhelp_serviceprovider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signup = (Button)findViewById(R.id.itsSignUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }
    public void signUp()
    {
        TextInputEditText name = (TextInputEditText)findViewById(R.id.username);
        String userName = name.getText().toString();
        TextInputEditText id = (TextInputEditText)findViewById(R.id.auth);
        String userId = id.getText().toString();
        TextInputEditText userPass = (TextInputEditText)findViewById(R.id.pass);
        String userPassword = userPass.getText().toString();
        TextInputEditText phn = (TextInputEditText)findViewById(R.id.phone);
        String userPhone = phn.getText().toString();

        ServiceProvider service ;
        service = new ServiceProvider();
        service.setName(userName);
        service.setPhone(userPhone);
        service.setRegistrationNumber(userId);

        Toast.makeText(this, "You have successfully registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }



}
