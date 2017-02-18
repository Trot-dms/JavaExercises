package model;

/**
 * Created by trot on 18.02.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import helper.Data;
import helper.Random;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("birthDate")
    @Expose
    private LocalDate birthDate;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("creditCard")
    @Expose
    private CreditCard creditCard;
    @SerializedName("pesel")
    @Expose
    private Pesel pesel;

    public void generateFirstName() {
        if (sex.equals(Sex.MALE.getUserSex())) {
            firstName = Random.getRandomProperty(Data.getMaleNames());
        } else if (sex.equals(Sex.FEMALE.getUserSex())) {
            firstName = Random.getRandomProperty(Data.getFemaleNames());
        } else {
            List<String> list = new ArrayList<>();
            list.addAll(Data.getFemaleNames());
            list.addAll(Data.getMaleNames());
            firstName = Random.getRandomProperty(list);
        }
    }

    public void generateLastName() {
        lastName = Random.getRandomProperty(Data.getLastNames());
    }

    public void generateAddress() {
        address = new Address();
        address.generateCityName();
        address.generateStreetNumber(1, 100, true);
        address.generateHomeNumber(1, 99);
        address.generateStreetName();
        address.generatePostCode();
    }

    public void generatePhoneNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("+48");
        for (int i = 0; i<3 ; i++) {
            sb.append(" ").append(Random.getRandomNumber(100, 999));
        }
        phoneNumber = sb.toString();
    }

    public void generatePesel() {
        pesel = new Pesel();
        pesel.generatePeselNumber(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }
}