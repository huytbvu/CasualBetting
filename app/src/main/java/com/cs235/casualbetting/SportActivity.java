package com.cs235.casualbetting;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;


public class SportActivity extends TabActivity  {

    private int[] sportTabs = {R.string.sportFootball,R.string.sportTennis,R.string.sportFormulaOne};
    private int[] sportBanners = {R.drawable.bannerfootball,R.drawable.bannertennis,R.drawable.bannerformulaone};

    ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        TabHost tabHost = getTabHost();
        banner = (ImageView)findViewById(R.id.sportBanner);
        banner.setBackgroundResource(sportBanners[0]);
        for(int i:sportTabs){
            String s = getResources().getString(i);
            TabHost.TabSpec tab = tabHost.newTabSpec(s.toUpperCase());
            tab.setIndicator(s);
            Intent sportIntent = new Intent(SportActivity.this, SportListActivity.class);
            tab.setContent(sportIntent);
            tabHost.addTab(tab);
        }
        tabHost.getTabWidget().setStripEnabled(false);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                banner.setBackgroundResource(sportBanners[getTabHost().getCurrentTab()]);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sport, menu);
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
