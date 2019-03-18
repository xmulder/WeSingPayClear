package com.example.wesingpayclear;

public class Wsc {

    private static String wscTextView;
    private static int wscImageId;

    public Wsc(String wscTextView,int wscImageId){
        this.wscImageId=wscImageId;
        this.wscTextView=wscTextView;
    }

    public static String getWscTextView(){
        return wscTextView;
    }

    public static int getWscImageId(){
        return wscImageId;
    }
}
