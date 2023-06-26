package com.example.parichaymahanrashtra;

public class Reviewdata {
    public String pname ;
    public String Review;


    public Reviewdata() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Reviewdata(String pname, String Review) {
        this.pname = pname;
        this.Review= Review;
    }
}
