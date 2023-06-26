package com.example.parichaymahanrashtra.ui;

public class places
{
   

        public String pname ;
        public String location;
        public String desc;

        public places() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public places(String pname, String location,String desc) {
            this.pname = pname;
            this.location = location;
            this.desc=desc;
        }

}
