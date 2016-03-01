package com.example.nikhiltr.swahgaura_parivar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    Button signup1;
    String usernametxt,cpasswordtxt,contacttxt,emailtxt,roletxt;
    String passwordtxt;
    EditText password,cpassword,contact,email,role;
    EditText username;
    ProgressDialog pd,pd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup1 =(Button)findViewById(R.id.button);
        username = (EditText) findViewById(R.id.editText);

        contact = (EditText) findViewById(R.id.editText2);
        email= (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        cpassword= (EditText) findViewById(R.id.editText5);
        role = (EditText) findViewById(R.id.editText6);


        pd=new ProgressDialog(this);
        pd.setTitle("wait");
        pd.setMessage("By Nikhil");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setCancelable(true);


        pd2=new ProgressDialog(this);
        pd2.setTitle("wait");
        pd2.setMessage("By Nikhil");
        pd2.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd2.setCancelable(true);
        // Sign up Button Click Listener

        signup1.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {

                                        //   pd2.show();

                                           ParseObject userData = new ParseObject("UserData");

                                           //Initials our variables
                                           usernametxt = username.getText().toString();
                                           contacttxt = contact.getText().toString();
                                           emailtxt = email.getText().toString();
                                           passwordtxt = password.getText().toString();
                                           cpasswordtxt = cpassword.getText().toString();
                                           roletxt = role.getText().toString();

                                           //update it with new data

                                           userData.put("username", usernametxt);
                                           userData.put("Contact", contacttxt);
                                           userData.put("Email", emailtxt);
                                           userData.put("password", passwordtxt);
                                           userData.put("Role", roletxt);
                                           userData.saveInBackground();

                                           Toast.makeText(getApplicationContext(),
                                                   "Sign Up Successfully Please Logged in",
                                                   Toast.LENGTH_LONG).show();

                                           Intent intent=new Intent(SignUp.this,LoginSignupActivity.class);
                                           startActivity(intent);



                                       }

                                   });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
