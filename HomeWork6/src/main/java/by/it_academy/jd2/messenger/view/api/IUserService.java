package by.it_academy.jd2.messenger.view.api;

import by.it_academy.jd2.messenger.model.User;
import java.util.HashSet;

/** Интерфейс регистрации пользователей */
public interface IUserService {

    /**
     * Получить пользователя
     * @param login логин
     * @return пользователь
     */
    User getUser(String login);

    /**
     * Сохранить пользователя
     * @param user логин
     */
    void signUp(User user);

    /** Получить логины всех пользователей
     * @return список логинов всех пользователей
     */
    HashSet<String> getAllLogin ();
}
