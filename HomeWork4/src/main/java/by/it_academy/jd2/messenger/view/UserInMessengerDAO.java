package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.dao.MessagesDataBase;
import by.it_academy.jd2.messenger.dao.UsersDataBase;
import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IUserInMessenger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Класс UserInMessengerDAO, предназначенный для работы с учетными записями пользователей и сообщениями
 * реализует интерфейс {@link IUserInMessenger}
 */
public class UserInMessengerDAO implements IUserInMessenger {
    /** Экземпляр собственного класса*/
    private final static UserInMessengerDAO instance = new UserInMessengerDAO();

    /**
     * Метод, который сохраняет пользователя
     * @param login - логин
     * @param user  - экземпляр класса{@link User#User})
     * @throws IllegalArgumentException - ошибка при вводе аргументов
     * @see IllegalArgumentException
     */
    public void saveUser(String login, User user) {
        try {
            UsersDataBase.saveUser(login, user);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
    }

    /**
     * Метод получения всех зарегестрированных пользователей
     * внутри метода вызывается метод {@link UsersDataBase#getUsersInMessenger()}
     * @return список пользователей с соответствующими им логинами
     * @throws IllegalArgumentException - ошибка при вводе аргументов
     * @see IllegalArgumentException
     */
    public HashMap<String, User> getUsersInMessenger() {
        HashMap<String, User> users = new HashMap<>();
        try {
            users = UsersDataBase.getUsersInMessenger();
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalArgumentException("error");
        }
        return users;
    }

    /**
     * Метод получения пользователя
     * внутри метода вызывается метод {@link UsersDataBase#getUser(String)}
     * @return пользователь
     */
    public User getUser(String login) {
        User user = new User();
        try {
            user = UsersDataBase.getUser(login);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Метод получения списка сообщений
     * внутри метода вызывается метод {@link MessagesDataBase#getMessage(String)}
     * @param login получатель сообщения
     * @return список сообщений
     */
    public ArrayList<Message> getMessage(String login) {
        ArrayList<Message> chats = new ArrayList<>();
        try {
            chats = MessagesDataBase.getMessage(login);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return chats;
    }

    /**
     * Метод сохранения сообщения
     * внутри метода вызывается метод {@link MessagesDataBase#setMessage(String,Message)}
     * @param login получатель сообщения
     * @param message сообщение
     */
    public void setMessage(String login, Message message) {
        try {
            MessagesDataBase.setMessage(login,message);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод получения значения поля {@link UserInMessengerDAO#instance}
     * @return возвращает экземпляр собственного класса
     */
    public static UserInMessengerDAO getInstance() {
        return instance;
    }
}
