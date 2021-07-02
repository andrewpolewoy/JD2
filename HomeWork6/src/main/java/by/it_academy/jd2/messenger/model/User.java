package by.it_academy.jd2.messenger.model;

import javax.persistence.*;
import java.io.Serializable;

/** Класс учетной записи пользователя, реализует интерфейс {@link Serializable} */
@Entity(name = "User")
@Table(name = "user",schema = "hibernate")
public class User implements Serializable {

    /** Логин */
    @Id
    @Column(name = "login",nullable = false)
    private String login;

    /** Имя */
    @Column(name = "name")
    private String name;

    /** Пароль */
    @Column(name = "password")
    private String password;

    /** Дата рождения */
    @Column(name = "birth_day")
    private String birth_day;

    /**
     * Конструктор для создания учётной записи
     * @param name имя
     * @param login логин
     * @param password фамилия
     * @param birth_day дата рождения
     */
    public User(String name, String login, String password, String birth_day) {
        this.name = name;
        this.login = login;
        this.birth_day = birth_day;
        this.password = password;
    }

    /**
     * Конструктор для создания учётной записи
     * @param login логин
     * @param password фамилия
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Конструктор для создания учётной записи без параметров
     */
    public User() {
    }

    /**
     * Метод получения значения поля {@link User#name}
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод определения имени {@link User#name}
     * @param first_name имя
     */
    public void setName(String first_name) {
        this.name = first_name;
    }

    /**
     * Метод получения значения поля {@link User#login}
     * @return логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод определения логина {@link User#login}
     * @param login логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Метод получения значения поля {@link User#password}
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод определения пароля {@link User#password}
     * @param password пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Метод получения значения поля {@link User#birth_day}
     * @return дата рождения
     */
    public String getBirth_day() {
        return birth_day;
    }

    /**
     * Метод определения даты рождения {@link User#birth_day}
     * @param birth_day дата рождения
     */
    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }
}
