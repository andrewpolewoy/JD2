package by.it_academy.jd2.core.dto;

import java.util.Date;

public class User {
    private String name;
    private String login;
    private String password;
    private String birth_day;


    public User(String name, String login, String password, String birth_day) {
        this.name = name;
        this.login = login;
        this.birth_day = birth_day;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String name() {
        return name;
    }

    public void setName(String first_name) {
        this.name = first_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }
}
