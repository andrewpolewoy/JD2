package by.it_academy.jd2.messenger.view.api;

import by.it_academy.jd2.messenger.model.User;

import java.util.HashSet;

/**
 * Интерфейс регистрации пользователей
 */
public interface IUserService {

//    void checkUser (User user);
    /** Получить пользователя */
    User getUser(String login);

    /** Сохранить пользователя */
    void signUp(User user);

    /** Получить логины всех пользователей */
    HashSet<String> getAllLogin ();
}
