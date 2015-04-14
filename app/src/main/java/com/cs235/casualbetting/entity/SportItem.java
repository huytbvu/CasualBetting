package com.cs235.casualbetting.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huyvu on 4/13/2015.
 */
public class SportItem implements Comparable<SportItem> {

    protected Date eventDate;
    protected String eventTitle;
    protected String eventSubtitle;
    protected String eventDescription;

    public SportItem(String title){
        this.eventTitle = title;
    }

    public void setEventDate(String date) throws ParseException {
        eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventSubtitle() {
        return eventSubtitle;
    }

    public void setEventSubtitle(String eventSubtitle) {
        this.eventSubtitle = eventSubtitle;
    }

    public int compareTo(SportItem another) {
        if(this.eventDate.before(another.eventDate))
            return -1;
        else if (this.eventDate.after(another.eventDate))
            return 1;
        else return 0;
    }
}
