package com.cs235.casualbetting.entity;

/**
 * Created by huyvu on 4/13/2015.
 */
public class FootballItem extends TennisItem {

    protected double drawBet;

    public FootballItem(String title){
        super(title);
    }

    public void setBets(double homeBet, double drawBet, double awayBet){
        super.setBets(homeBet,awayBet);
        this.drawBet = drawBet;
    }


    public double getDrawBet() {
        return drawBet;
    }
}
