package com.example.trailmobile.app.Models;

import com.example.trailmobile.app.Interfaces.IConfiguration;

/**
 * Created by Cesar Ferreira on 12/03/2016.
 */
public class ConfigurationManager implements IConfiguration {

    private int maxTimer = 20;


    public int getTrackerMaxTimer()
    {
        return maxTimer;
    }

    public String[] getMaxTimerNums()
    {
        String[] nums =  new String[maxTimer];
        for(int i=0; i < nums.length; i++)
            nums[i] = Integer.toString(i+1);
        return nums;
    }
}
