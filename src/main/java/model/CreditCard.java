package model;

/**
 * Created by trot on 18.02.17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditCard {

    @SerializedName("creditCardNumber")
    @Expose
    private String creditCardNumber;
    @SerializedName("creditCardBank")
    @Expose
    private String creditCardBank;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardBank() {
        return creditCardBank;
    }

    public void setCreditCardBank(String creditCardBank) {
        this.creditCardBank = creditCardBank;
    }

}
