import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User(1,
                "Oleg", "last name",
                "Oleg@gmail.com",
                38, new String[]{"osh", "moscow", "bishkek"},
                new Cat(2,"koshka"));
        User user1 = new User(2,
                "name", "last name",
                "Oleg@gmail.com",
                20, new String[]{"address", "moscow", "bishkek"},
                new Cat(4,"myshyk"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> users = new ArrayList<>(Arrays.asList(user, user1));
        String json = gson.toJson(users);
        try (FileWriter writer = new FileWriter("user-objects.json")) {
            writer.write(json);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}