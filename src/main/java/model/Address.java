package model;

/**
 * Created by trot on 18.02.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import helper.Data;
import helper.Random;

public class Address {

    @SerializedName("streetName")
    @Expose
    private String streetName;
    @SerializedName("streetNumber")
    @Expose
    private String streetNumber;
    @SerializedName("homeNumber")
    @Expose
    private String homeNumber;
    @SerializedName("cityName")
    @Expose
    private String cityName;
    @SerializedName("cityPostCode")
    @Expose
    private String cityPostCode;

    public void generateStreetNumber(int minNumber, int maxNumber, boolean letters) {
        if (!letters) {
            streetNumber = String.valueOf(Random.getRandomNumber(minNumber, maxNumber));
        } else {
            char letter = (char) Random.getRandomNumber(65,85);
            streetNumber = "" + Random.getRandomNumber(minNumber, maxNumber) + letter;
        }
    }

    public void generateHomeNumber(int minNumber, int maxNumber) {
        homeNumber = String.valueOf(Random.getRandomNumber(minNumber, maxNumber));
    }

    public void generateStreetName() {
        streetName = Random.getRandomProperty(Data.getStreetNames());
    }

    public void generatePostCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$02d", Random.getRandomNumber(0, 99)))
                .append("-")
                .append(String.format("%1$03d", Random.getRandomNumber(0, 999)));
        cityPostCode = sb.toString();
    }

    public void generateCityName() {
        setCityName(Random.getRandomProperty(Data.getCities()));
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityPostCode() {
        return cityPostCode;
    }

    public void setCityPostCode(String cityPostCode) {
        this.cityPostCode = cityPostCode;
    }


}
