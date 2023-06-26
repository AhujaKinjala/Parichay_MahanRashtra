package com.example.parichaymahanrashtra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Retrievedata extends AppCompatActivity {
    FirebaseDatabase mdatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;

    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;
    List<Reviewmodel> reviewmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanheric);

        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference().child("Reviews");
        mStorage = FirebaseStorage.getInstance();

        recyclerView=(RecyclerView) findViewById(R.id.idLVreviews);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        reviewmodelList=new ArrayList<Reviewmodel>();
        reviewAdapter=new ReviewAdapter(Retrievedata.this,reviewmodelList);
        recyclerView.setAdapter(reviewAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Reviewmodel reviewmodel=snapshot.getValue(Reviewmodel.class);
                reviewmodelList.add(reviewmodel);
                reviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}