package com.cs235.casualbetting.entity;

/**
 * Created by huyvu on 4/13/2015.
 */
public class TennisItem extends SportItem {

    protected String home;
    protected String away;
    protected double homeBet, awayBet;

    public TennisItem(String title){
        super(title);
    }

    public void setTeams(String home, String away){
        this.home = home;
        this.away = away;
    }

    public void setBets(double homeBet, double awayBet){
        this.homeBet = homeBet;
        this.awayBet = awayBet;
    }

    @Override
    public String getEventTitle(){
        return home + " vs. " + away;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public double getHomeBet() {
        return homeBet;
    }

    public double getAwayBet() {
        return awayBet;
    }
}
