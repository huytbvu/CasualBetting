package com.cs235.casualbetting;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String balance = getResources().getString(R.string.currentBalance) + "$10.27" + getResources().getString(R.string.toTransfer);

    //    ((ImageView)findViewById(R.id.previousBetView)).setImageDrawable(null);
    //    ((ImageView)findViewById(R.id.previousBetView)).setImageResource(R.drawable.previous_bet);
    //   ((ImageView)findViewById(R.id.currentBetView)).setImageDrawable(null);
    //    ((ImageView)findViewById(R.id.currentBetView)).setImageResource(R.drawable.current_bet);

        ((TextView)findViewById(R.id.balanceView)).setText(balance);
        ((TextView)findViewById(R.id.balanceView)).setClickable(true);
        ((TextView)findViewById(R.id.balanceView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTransfer = new Intent(HomeActivity.this, BankActivity.class);
                startActivity(toTransfer);
            }
        });

        ((ImageButton)findViewById(R.id.betnowBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSport = new Intent(HomeActivity.this, SportActivity.class);
                startActivity(toSport);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
