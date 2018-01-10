package weather.dal.cs.weatherapp;

/**
 * Created by Bhavya on 3/14/2017.
 */

public class Temperatures {



    private String textSummary = "textSummary";
    public static String temperature = "temperature";
    public boolean xmlparsingComplete;

    public String getTextSummary() {
        return textSummary;
    }

    public void setTextSummary(String textSummary) {
        this.textSummary = textSummary;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }



}