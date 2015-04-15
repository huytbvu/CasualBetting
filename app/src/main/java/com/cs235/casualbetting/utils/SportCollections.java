package com.cs235.casualbetting.utils;

import com.cs235.casualbetting.entity.FootballItem;
import com.cs235.casualbetting.entity.FormulaOneItem;
import com.cs235.casualbetting.entity.TennisItem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by huyvu on 4/15/2015.
 */
public class SportCollections {


    private ArrayList<FormulaOneItem> itemFormulaOne = new ArrayList<>();
    private ArrayList<FootballItem> itemFootball = new ArrayList<>();
    private ArrayList<TennisItem> itemTennis= new ArrayList<>();

    public SportCollections(){

    }

    public void addFootballItem(FootballItem fi){
        itemFootball.add(fi);
    }

    public void addFormulaOneItem(FormulaOneItem foi){
        itemFormulaOne.add(foi);
    }

    public void addTennisItem(TennisItem ti){
        itemTennis.add(ti);
    }

    public void sortAll(){
        Collections.sort(itemFootball);
        Collections.sort(itemFormulaOne);
        Collections.sort(itemTennis);
    }

    public ArrayList<FormulaOneItem> getItemFormulaOne() {
        return itemFormulaOne;
    }

    public ArrayList<FootballItem> getItemFootball() {
        return itemFootball;
    }

    public ArrayList<TennisItem> getItemTennis() {
        return itemTennis;
    }
}
