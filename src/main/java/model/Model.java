package model;

/**
 * Created by trot on 18.02.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Model {

    @SerializedName("user")
    @Expose
    private User user;

    public Model() {
        this.user = new User();
    }

    public void createRandomUser() {
        user.setSex(Sex.getRandomSex());
        user.setBirthDate(LocalDate.now());
        user.generateFirstName();
        user.generateLastName();
        user.generateAddress();
        user.generatePesel();
        user.generatePhoneNumber();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}