package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.view.api.IUserInMessenger;
import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс UserInMessenger, предназначенный для работы с учетными записями пользователей и сообщениями
 * реализует интерфейс {@link IUserInMessenger}
 */
public class UserInMessenger implements IUserInMessenger {
    /** Экземпляр собственного класса*/
    private final static UserInMessenger instance = new UserInMessenger();

    /** Поле пользователь (ключ - логин ,
     *  значение - экземпляр класса{@link User#User}) */
    public static HashMap<String, User> usersInMessenger = new HashMap<>();
    /** Поле сообщения */
    private static final Map<String, ArrayList<Message>> chats = new HashMap<>();

//    public UserInMessenger() {
//        HashMap<String, User> usersInMessenger = new HashMap<>();
//        Map<String, ArrayList<Message>> chats = new HashMap<>();
//    }

    /**
     * Метод получения значения поля {@link UserInMessenger#usersInMessenger}
     * @return возвращает пользователей
     */
    public HashMap<String, User> getUsersInMessenger() {
        return usersInMessenger;
    }
    /**
     * Метод, который сохраняет пользователя
     * @param login логин
     * @param user экземпляр класса{@link User#User})
     * @throws IllegalArgumentException - ошибка при вводе аргументов
     * @see IllegalArgumentException
     */
    public void saveUser(String login, User user) {
        if (!usersInMessenger.containsKey(login)) {
            usersInMessenger.put(login, user);
        } else {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
    }

    /**
     * Метод получения пользователя {@link User#User}
     * @param login логин
     * @return возвращает пользователя
     */
    public User getUser(String login) {
        return usersInMessenger.get(login);
    }

    /**
     * Метод получения значения поля {@link UserInMessenger#chats}
     * @return возвращает сообщения
     */
    public ArrayList<Message> getMessage(String login) {
        return chats.get(login);
    }

    /**
     * Метод определения сообщения {@link UserInMessenger#chats}
     * @param message сообщение
     * @param login логин
     */
    public void setMessage(String login, Message message) {
        ArrayList<Message> chat;
        if(chats.containsKey(login)){
            chat = chats.get(login);
        } else {
            chat = new ArrayList<>();
            chats.put(login, chat);
        }
        chat.add(message);
    }

    /**
     * Метод получения значения поля {@link UserInMessenger#instance}
     * @return возвращает экземпляр собственного класса
     */
    public static UserInMessenger getInstance() {
        return instance;
    }
}
