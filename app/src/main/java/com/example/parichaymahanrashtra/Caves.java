package com.example.parichaymahanrashtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.parichaymahanrashtra.ui.places;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Caves extends AppCompatActivity {
    private ImageButton kanheri,back;
    DatabaseReference cavesDbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caves);

        kanheri=(ImageButton) findViewById(R.id.imageButton10);
        back=(ImageButton)findViewById(R.id.imageButton22);
        cavesDbref = FirebaseDatabase.getInstance().getReference().child("Places");
        writeNewUser(" "," "," "," ");

        kanheri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),kanheric.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),nav_home.class));
            }
        });
    }
    public void writeNewUser(String pname, String location, String desc,String placeid) {
        places place = new places(pname,location,desc);

        cavesDbref.child("Caves").child(placeid).setValue(place);
    }
}