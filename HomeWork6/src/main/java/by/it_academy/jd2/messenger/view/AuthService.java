package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IAuthService;
import by.it_academy.jd2.messenger.view.api.IUserService;
import java.util.Objects;

/** Класс для аутентификации пользователей */
public class AuthService implements IAuthService {

    /** Экземпляр класса IUserService */
    private final IUserService userService;

    /**
     * Конструктор с инициализацией экземпляра класса {@link IUserService}
     * @param userService класс сервиса пользователя
     */
    public AuthService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Метод проверки, существует ли пользователь с указанным логином и паролем
     * @param login Логин
     * @param password Пароль
     * @return пользователь , если пользователь не существует - null
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
