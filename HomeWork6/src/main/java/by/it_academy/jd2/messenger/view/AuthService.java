package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IAuthService;
import by.it_academy.jd2.messenger.view.api.IUserService;

import java.util.Objects;

/**
 * Класс для аутентификации пользователей.
 */
public class AuthService implements IAuthService {

    private final IUserService userService;

    public AuthService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Проверить, существует ли пользователь с указанным логином и паролем
     *
     * @param login Логин
     * @param password Пароль
     * @return Пользователь , если пользователь не существует null
     */
    @Override
    public User authentication(String login, String password) {
        User user = this.userService.getUser(login);
        if(user == null){
            return null;
        }

        if(!Objects.equals(user.getPassword(), password)){
            return null;
        }
        return user;
    }
}
