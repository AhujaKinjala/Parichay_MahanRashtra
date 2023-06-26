package com.example.parichaymahanrashtra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.parichaymahanrashtra.ui.places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Review extends AppCompatActivity {
    private Button post, upload;
    private EditText write;
    private ImageButton imag;
    FirebaseDatabase mdatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ProgressDialog progressDialog;
    private static final int Gallery_code = 1;
    Uri imageUrl = null;

    //    DatabaseReference revdata;
//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
//        storageRef=storage.getReference();
        post = (Button) findViewById(R.id.button19);
        upload = (Button) findViewById(R.id.button13);
        write = (EditText) findViewById(R.id.review);
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference().child("Reviews");
        mStorage = FirebaseStorage.getInstance();
        imag = (ImageButton) findViewById(R.id.imageButton21);
        progressDialog = new ProgressDialog(this);

//        revdata= FirebaseDatabase.getInstance().getReference().child("Reviews");

//        post.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                String re=write.getText().toString();
////                writeNewUser("Kinjala",re,"First");
////                Intent intent=new Intent(getApplicationContext(),kanheric.class);
////                startActivity(intent);
//            }
//        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/");
                startActivityForResult(intent, Gallery_code);


            }
        });

    }

        @Override
        protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == Gallery_code && resultCode == RESULT_OK) {
                imageUrl = data.getData();
                imag.setImageURI(imageUrl);
            }


            post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String rw = write.getText().toString().trim();
                    progressDialog.setTitle("Uploading....");
                    progressDialog.show();

                    StorageReference filepath = mStorage.getReference().child("Imagepost").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t = task.getResult().toString();
                                    DatabaseReference newPost = mRef.push();
                                    newPost.child("Review").setValue(rw);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    startActivity(new Intent(getApplicationContext(),Retrievedata.class));
                                    progressDialog.dismiss();


                                }
                            });
                        }


                    });

                }
            });
        }
    }






//    public void writeNewUser(String pname, String review,String placeid) {
//       Reviewdata rev=new Reviewdata(pname,review);
////        revdata.child("Reviews").child(placeid).setValue(rev);
//    }
