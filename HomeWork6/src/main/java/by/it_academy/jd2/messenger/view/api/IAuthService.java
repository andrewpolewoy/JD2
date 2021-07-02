package by.it_academy.jd2.messenger.view.api;

import by.it_academy.jd2.messenger.model.User;

/** Интерфейс аутентификации пользователей */
public interface IAuthService {

    /**
     * Проверить авторизован ли пользователь
     * @param login логин
     * @param password пароль
     * @return пользователь
     */
    User authentication(String login, String password);
}

