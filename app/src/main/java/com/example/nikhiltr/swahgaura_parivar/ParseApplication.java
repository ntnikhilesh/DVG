package com.example.nikhiltr.swahgaura_parivar;


import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseInstallation;
import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "pValVq5mV4D579HrtKqPvIRO2uXxvsTNqLkoQ9aK", "bql9vgoftzNR9Hy92ZN9LjpVVn8YPIXnOYIoajuX");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }

}
