package com.cs235.casualbetting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class BankActivity extends ActionBarActivity {

    private double current;
    private double transferAmount;

    private EditText amountText;

    private String msgHint, msgInvalidTitle, msgInvalidDesc,
            msgOK, msgTransConfirmTitle, msgTransConfirmDesc,
            msgNotnow, msgTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        amountText = (EditText)findViewById(R.id.transferAmount);

        msgHint = getResources().getString(R.string.transferAmount);
        msgInvalidTitle = getResources().getString(R.string.invalidTitle);
        msgInvalidDesc = getResources().getString(R.string.invalidDesc);
        msgOK = getResources().getString(R.string.ok);
        msgTransConfirmTitle = getResources().getString(R.string.transConfirmTitle);
        msgTransConfirmDesc = getResources().getString(R.string.transConfirmDesc);
        msgNotnow = getResources().getString(R.string.notnow);
        msgTransfer = getResources().getString(R.string.transferConfirm);

        ((Button)findViewById(R.id.clearTransferBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountText.setText("");
                amountText.setHint(msgHint);
            }
        });

        ((Button)findViewById(R.id.scheduleTransferBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = amountText.getText().toString();
                if (s.equals("")) {
                    new AlertDialog.Builder(BankActivity.this)
                            .setTitle(msgInvalidTitle)
                            .setMessage(msgInvalidDesc)
                            .setCancelable(false)
                            .setPositiveButton(msgOK, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                } else {
                    double amount = Double.parseDouble(s);

                    new AlertDialog.Builder(BankActivity.this)
                            .setTitle(msgTransConfirmTitle)
                            .setMessage(msgTransConfirmDesc)
                            .setCancelable(false)
                            .setNegativeButton(msgNotnow, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .setPositiveButton(msgTransfer, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

        ((Button)findViewById(R.id.transferBackBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bank, menu);
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
