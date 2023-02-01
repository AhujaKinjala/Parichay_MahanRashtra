package com.example.parichaymahanrashtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class loginpg extends AppCompatActivity {

        public Button login;
        public TextView forgot;
        public TextView signup;
        public EditText email;
        public EditText password;
        public ImageButton image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpg);
        login=(Button) findViewById(R.id.button5);
        forgot=(TextView) findViewById(R.id.textView13);
        signup=(TextView) findViewById(R.id.textView14);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress);
        password=(EditText)findViewById(R.id.editTextTextPassword);
        image=(ImageButton)findViewById(R.id.imageButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),nav_home.class);
                startActivity(intent);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OTP.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Registerpg.class);
                startActivity(intent);
            }
        });

//        image.setOnClickListener {
//            if(showHideBtn.text.toString().equals("Show")){
//                pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
//                showHideBtn.text = "Hide"
//            } else{
//                pwd.transformationMethod = PasswordTransformationMethod.getInstance()
//                showHideBtn.text = "Show"
//            }
//        }
        image .setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        password.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }
        });

    }


}