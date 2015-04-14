package com.cs235.casualbetting.entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by huyvu on 4/13/2015.
 */
public class FormulaOneItem extends SportItem {

    HashMap<String,Double> drivers;

    public FormulaOneItem(String title){
        super(title);
        drivers = new HashMap<String,Double>();
    }

    public void addDriver(String name, double bet){
        drivers.put(name, bet);
    }

    public ArrayList<String> getDriverNames(){
        ArrayList<String> dr = new ArrayList<String>();
        dr.addAll(drivers.keySet());
        return dr;
    }

    public HashMap<String, Double> getDriversWithBet() {
        return drivers;
    }
}
