package com.example.nikhiltr.swahgaura_parivar;

/**
 * Created by NIKHIL TR on 1/17/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class LoginSignupActivity extends Activity {
    // Declare Variables
    Button loginbutton;
    Button signup;
    String usernametxt;
     String passwordtxt;
    EditText password;
    EditText username;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Get the view from main.xml
        setContentView(R.layout.loginsignup);
// Locate EditTexts in main.xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

// Locate Buttons in main.xml
        loginbutton = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);

// Login Button Click Listener
        loginbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
// Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();
/*
// Send data to Parse.com for verification
                ParseQuery<ParseObject> query = ParseQuery.getQuery("UserData");
                query.whereEqualTo("username", usernametxt);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> username, ParseException e) {
                        Log.d("msg", username.toString());

                        if (e == null) {
// If user exist and authenticated, send user to Welcome.class
                            Intent intent = new Intent(
                                    LoginSignupActivity.this,
                                    Welcome.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),
                                    "Successfully Logged in",
                                    Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "No such user exist, please signup",
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                });  */



                ParseQuery<ParseObject> query = ParseQuery.getQuery("UserData");
                query.whereEqualTo("username",usernametxt);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e)
                    {
                        if (object == null)
                        {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "No such user exist, please signup",
                                    Toast.LENGTH_LONG).show();
                        }
                        else
                        {

                            Intent intent = new Intent(
                                    LoginSignupActivity.this,
                                    Welcome.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),
                                    "Successfully Logged in",
                                    Toast.LENGTH_LONG).show();
                            finish();/*
                            String myIdInCLoud =  object.getObjectId().toString();
                            Log.d("scoren", "--found"+myIdInCLoud);
                            Toast.makeText(
                                    getApplicationContext(),
                                    myIdInCLoud,
                                    Toast.LENGTH_LONG).show();
                         //   String myIdInCLoud =  object.getObjectId().toString();  */
                        }
                    }
                });

/*
                ParseQuery<ParseObject> query = ParseQuery.getQuery("UserData");
                query.getInBackground("2O5R7v7MzR", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        Log.d("msggg",object.toString());
                        if (e == null) {

                            String playerName = object.getString("username");
                            Toast.makeText(
                                    getApplicationContext(),
                                    playerName,
                                    Toast.LENGTH_LONG).show();
                            // object will be your game score
                        } else {
                            // something went wrong
                        }
                    }
                }); */



/*
                ParseUser.logInInBackground(usernametxt, passwordtxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {
// If user exist and authenticated, send user to Welcome.class
                                    Intent intent = new Intent(
                                            LoginSignupActivity.this,
                                            Welcome.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "No such user exist, please signup",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });  */
            }
        });


// Sign up Button Click Listener
        signup.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent i=new Intent(LoginSignupActivity.this,SignUp.class);
                startActivity(i);
            }
                /*
// Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

// Force user to fill up the form
                if (usernametxt.equals("") && passwordtxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {
// Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
// Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });
                }

            }  */
        });

    }
}