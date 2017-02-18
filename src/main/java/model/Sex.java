package model;

import java.util.Random;

/**
 * Created by trot on 18.02.17.
 */
public enum Sex {
    MALE("Mężczyzna"),
    FEMALE("Kobieta"),
    UNDEFINED("Nie określono");

    private String userSex;

    Sex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public static String  getRandomSex() {
        Random random = new Random();
        int randomNum = random.nextInt(Sex.values().length);
        return Sex.values()[randomNum].getUserSex();
    }
}
