package com.example.parichaymahanrashtra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class bucketlistfinal extends AppCompatActivity{
        private RecyclerView recyclerView;
        bucket_adapter adapter; // Create Object of the Adapter class
        DatabaseReference mbase; // Create object of the
        // Firebase Realtime Database

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_bucketlist2);

            // Create a instance of the database and get
            // its reference
            mbase= FirebaseDatabase.getInstance().getReference();

            recyclerView = findViewById(R.id.recycler1);

            // To display the Recycler view linearly
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(this));

            // It is a class provide by the FirebaseUI to make a
            // query in the database to fetch appropriate data
            FirebaseRecyclerOptions<bucket> options
                    = new FirebaseRecyclerOptions.Builder<bucket>()
                    .setQuery(mbase, bucket.class)
                    .build();
            // Connecting object of required Adapter class to
            // the Adapter class itself
            adapter = new bucket_adapter(options);
            // Connecting Adapter class with the Recycler view*/
            recyclerView.setAdapter(adapter);
        }

        // Function to tell the app to start getting
        // data from database on starting of the activity
        @Override protected void onStart()
        {
            super.onStart();
            adapter.startListening();
        }

        // Function to tell the app to stop getting
        // data from database on stopping of the activity
        @Override protected void onStop()
        {
            super.onStop();
            adapter.stopListening();
        }
    }


