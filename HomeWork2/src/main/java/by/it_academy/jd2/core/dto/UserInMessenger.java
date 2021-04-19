package by.it_academy.jd2.core.dto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс UserInMessenger, предназначенный для создания учетной записи пользователя
 * с параметрами <b>name</b>, <b>login</b>, <b>password</b>, <b>birth_day</b>, <b>usersInMessenger</b>,
 *  <b>message</b>
 */
public class UserInMessenger {

    /** Поле имя */
    private String name;
    /** Поле логин */
    private String login;
    /** Поле пароль */
    private String password;
    /** Поле дата рождения */
    private String birth_day;
    /** Поле пользователь (ключ - логин ,
     *  значение - экземпляр класса{@link UserInMessenger#UserInMessenger}) */
    public static HashMap<String, UserInMessenger> usersInMessenger = new HashMap<>();
    /** Поле сообщение */
    private ArrayList<String> message;

    /**
     *Конструктор - создание нового объекта с определенными значениями
     * @param name - имя
     * @param login - логин
     * @param password - фамилия
     * @param birth_day - день рождения
     */
    public UserInMessenger(String name, String login, String password, String birth_day) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birth_day = birth_day;
        message = new ArrayList<>();
    }
    /**
     * Метод, который сохраняет пользователя
     * @param login - логин
     * @param user - экземпляр класса{@link UserInMessenger#UserInMessenger})
     * @throws IllegalArgumentException - ошибка при вводе аргументов
     * @see IllegalArgumentException
     */
    public static void saveUser(String login, UserInMessenger user) {
        if (!usersInMessenger.containsKey(login)) {
            usersInMessenger.put(login, user);
        } else {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
    }
    /**
     * Метод получения значения поля {@link UserInMessenger#message}
     * @return возвращает сообщения
     */
    public ArrayList<String> getMessage() {
        return message;
    }
    /**
     * Метод определения сообщения {@link UserInMessenger#message}
     * @param message - сообщение
     */
    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
    /**
     * Метод получения значения поля {@link UserInMessenger#name}
     * @return возвращает имя
     */
    public String getName() {
        return name;
    }
    /**
     * Метод получения значения поля {@link UserInMessenger#login}
     * @return возвращает логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод получения значения поля {@link UserInMessenger#password}
     * @return возвращает пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод получения значения поля {@link UserInMessenger#birth_day}
     * @return возвращает дату рождения
     */
    public String getBirth_day() {
        return birth_day;
    }


}
