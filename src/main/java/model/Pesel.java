package model;

/**
 * Created by trot on 18.02.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import helper.Random;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pesel {

    @SerializedName("peselNumber")
    @Expose
    private String peselNumber;

    public void generatePeselNumber(User user) {
        // dd-MM-yyyy
        StringBuilder pesel = new StringBuilder();

        LocalDate dateOfBirth = user.getBirthDate();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yy");
        int yearInt = Integer.parseInt(dateOfBirth.format(df));
        df = DateTimeFormatter.ofPattern("MM");
        int monthInt = Integer.parseInt(dateOfBirth.format(df));
        String year = String.format("%1$02d", yearInt);
        String month = String.format("%1$02d", validateMonth(yearInt, monthInt));
        df = DateTimeFormatter.ofPattern("dd");
        String day = String.format("%1$02d", Integer.parseInt(dateOfBirth.format(df)));

        pesel.append(String.format("%1$02d", yearInt))
                .append(month)
                .append(day);

        int randomNumber;
        if (user.getSex().equals(Sex.FEMALE.getUserSex())) {
            randomNumber = Random.getRandomEvenNumber(0, 9999);
        } else {
            randomNumber = Random.getRandomEvenNumber(1, 10000) - 1;
        }
        pesel.append(String.format("%1$04d", randomNumber));

        setPeselNumber(validatePesel(pesel.toString()));
    }

    private String validatePesel(String inclompetePesel) {
        // 1 3 7 9 1 3 7 9 1 3
        char[] pesel = inclompetePesel.toCharArray();
        int sum = 1 * pesel[0] +
                3 * pesel[1] +
                7 * pesel[2] +
                9 * pesel[3] +
                1 * pesel[4] +
                3 * pesel[5] +
                7 * pesel[6] +
                9 * pesel[7] +
                1 * pesel[8] +
                3 * pesel[9];
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;
        return inclompetePesel + sum;
    }

    private int validateMonth(int year, int month) {
        int add = 0;
        if (year >= 1800 && year <= 1899) add = 80;
        else if (year >= 2000 && year <= 2099) add = 20;
        else if (year >= 2100 && year <= 2199) add = 40;
        else if (year >= 2200 && year <= 2299) add = 60;
        return add + month;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

}