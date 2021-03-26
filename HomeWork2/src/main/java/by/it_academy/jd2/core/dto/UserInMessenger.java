package by.it_academy.jd2.core.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class UserInMessenger {

    private String name;
    private String login;
    private String password;
    private String birth_day;
    public static HashMap<String, UserInMessenger> usersInMessenger = new HashMap<>();
    private ArrayList<String> message;

    public UserInMessenger(String name, String login, String password, String birth_day) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birth_day = birth_day;
        message = new ArrayList<>();
    }
    public static void saveUser(String login, UserInMessenger user) {
        if (!usersInMessenger.containsKey(login)) {
            usersInMessenger.put(login, user);
        } else throw new IllegalArgumentException("User with this login already exists!");
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getBirth_day() {
        return birth_day;
    }

    private void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

}
