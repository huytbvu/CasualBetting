package com.cs235.casualbetting.utils;

import com.cs235.casualbetting.entity.FootballItem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by huyvu on 4/15/2015.
 */
public class SportReader {

    public static SportCollections allSports = new SportCollections();

    public static void readFootballInput(InputStream is){
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            while (br.ready()) {
                String[] line = br.readLine().split(",");
                FootballItem fi = new FootballItem(line[3]+" vs. "+line[4]);
                fi.setEventSubtitle(line[1]);
                fi.setEventDescription(line[2]);
                fi.setTeams(line[3],line[4]);
                fi.setBets(Double.parseDouble(line[5]),Double.parseDouble(line[6]),Double.parseDouble(line[7]));

                allSports.addFootballItem(fi);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
