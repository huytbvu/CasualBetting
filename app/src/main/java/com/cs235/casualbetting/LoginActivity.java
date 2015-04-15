package com.cs235.casualbetting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;


public class LoginActivity extends ActionBarActivity {

    EditText loginID;
    EditText loginPass;

    private String msgEmptyIDPassTitle, msgEmptyIDPassDesc, msgAuthenFailTitle, msgAuthenFailDesc, msgOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        msgEmptyIDPassTitle = getResources().getString(R.string.emptyIDPassTitle);
        msgEmptyIDPassDesc = getResources().getString(R.string.emptyIDPassDesc);
        msgAuthenFailTitle = getResources().getString(R.string.authenFailTitle);
        msgAuthenFailDesc = getResources().getString(R.string.authenFailDesc);
        msgOK = getResources().getString(R.string.ok);
        loginID = (EditText) findViewById(R.id.idText);
        loginPass = (EditText) findViewById(R.id.passText);

        ((ImageButton)findViewById(R.id.iconUS)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocale("en_US");
            }
        });


        ((ImageButton)findViewById(R.id.iconJP)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocale("ja");
            }
        });


        ((ImageButton)findViewById(R.id.iconVI)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocale("vi");
            }
        });

        ((Button) findViewById(R.id.loginBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginID.getText().toString().equals("") || loginPass.getText().toString().equals(""))
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle(msgEmptyIDPassTitle)
                            .setMessage(msgEmptyIDPassDesc)
                            .setCancelable(false)
                            .setPositiveButton(msgOK, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                else if (loginID.getText().toString().equals("bet") && loginPass.getText().toString().equals("me")) {
                    Intent toHomePage = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(toHomePage);
                } else {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle(msgAuthenFailTitle)
                            .setMessage(msgAuthenFailDesc)
                            .setCancelable(false)
                            .setPositiveButton(msgOK, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });
    }

    private void changeLocale(String localeName){
        Configuration config = getApplicationContext().getResources().getConfiguration();
        config.locale = new Locale(localeName);
        Locale.setDefault(config.locale);
        getApplicationContext().getResources().updateConfiguration(config,
                getApplicationContext().getResources().getDisplayMetrics());
        resetString();
    }


    private void resetString(){
        ((EditText)findViewById(R.id.idText)).setHint(getResources().getString(R.string.loginID));
        ((EditText)findViewById(R.id.passText)).setHint(getResources().getString(R.string.loginPass));
        ((Button)findViewById(R.id.loginBtn)).setText(getResources().getString(R.string.loginBtn));
        ((Button)findViewById(R.id.signupBtn)).setText(getResources().getString(R.string.signupBtn));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
