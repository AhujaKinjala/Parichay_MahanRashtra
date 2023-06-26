package com.example.parichaymahanrashtra;

public class Reviewmodel {
    String Review;
    String image;

    public Reviewmodel(String Review,String image){
        this.Review=Review;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }
}
