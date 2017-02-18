import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Model;
import model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by trot on 18.02.17.
 */
public class Presenter {

    public static void showUsers(List<User> userList) {
        userList.forEach(Presenter::show);
    }

    public static void saveToJson(String filename, Model model) {
        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream(filename + ".json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(model, writer);
        } catch (IOException e) {
            System.err.println("Error - " + e.getMessage());
        }
    }

    private static void show(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("Imię i nazwisko : ").append(user.getFirstName())
                .append(" ").append(user.getLastName())
                .append("\nPłeć : ").append(user.getSex())
                .append("\nAdres : ").append(user.getAddress().getStreetName()).append(" ")
                .append(user.getAddress().getStreetNumber())
                .append("\nKod pocztowy i miasto : ").append(user.getAddress().getCityPostCode())
                .append(" ").append(user.getAddress().getCityName())
                .append("\nPesel : ").append(user.getPesel().getPeselNumber())
                .append("\nNumer telefonu : ").append(user.getPhoneNumber())
                .append("\n--------------------------------------------------");
        System.out.println(sb.toString());
    }
}
