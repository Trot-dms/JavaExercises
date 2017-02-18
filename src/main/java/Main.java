import model.Model;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trot on 18.02.17.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            model.setUser(new User());
            model.createRandomUser();
            userList.add(model.getUser());
        }

        Presenter.showUsers(userList);
        Presenter.saveToJson("Output", model);

    }
}
