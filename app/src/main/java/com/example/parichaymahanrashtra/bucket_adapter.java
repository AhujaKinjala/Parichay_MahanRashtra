package com.example.parichaymahanrashtra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


    


    // FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
    public class bucket_adapter extends FirebaseRecyclerAdapter<
            bucket, bucket_adapter.bucketsViewholder> {

        public bucket_adapter(
                @NonNull FirebaseRecyclerOptions<bucket> options)
        {
            super(options);
        }

        // Function to bind the view in Card view(here
        // "bucket.xml") iwth data in
        // model class(here "bucket.class")
        @Override
        protected void
        onBindViewHolder(@NonNull bucketsViewholder holder,
                         int position, @NonNull bucket model)
        {

            // Add firstname from model class (here
            // "bucket.class")to appropriate view in Card
            // view (here "bucket.xml")
            holder.firstname.setText(model.getpname());


        }

        // Function to tell the class about the Card view (here
        // "bucket.xml")in
        // which the data will be shown
        @NonNull
        @Override
        public bucketsViewholder
        onCreateViewHolder(@NonNull ViewGroup parent,
                           int viewType)
        {
            View view
                    = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.bucketdata, parent, false);
            return new bucket_adapter.bucketsViewholder(view);
        }

        // Sub Class to create references of the views in Crad
        // view (here "bucket.xml")
        class bucketsViewholder
                extends RecyclerView.ViewHolder {
            TextView firstname, lastname, age;
            public bucketsViewholder(@NonNull View itemView)
            {
                super(itemView);

                firstname
                        = itemView.findViewById(R.id.firstname);

            }
        }
    }


