package com.param;

public class TimeParam {
    private String onTime = "8:30";
    private String offTime = "17:30";
    private String midTime = "12:00";
    private String nightTime="20:30";

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public String getNightTime() {
        return nightTime;
    }

    public void setNightTime(String nightTime) {
        this.nightTime = nightTime;
    }

    public String getMidTime() {
        return midTime;
    }

    public void setMidTime(String midTime) {
        this.midTime = midTime;
    }
}
