package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.storage.IUserRepository;
import by.it_academy.jd2.messenger.view.api.IUserService;
import java.util.HashSet;

/**
 * Класс для регистрации и поиска пользователей.
 */
public class UserService implements IUserService {

    private final IUserRepository repository;
    static HashSet<String> allUsersLogin = new HashSet<>();

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод для получения пользователя по логину
     *
     * @param login Логин
     * @return Пользователь с предоставленным логином, если пользователь существует, null, если нет
     */
    @Override
    public User getUser(String login) {
        return this.repository.getUserByLogin(login);
    }

    /**
     * Метод для регистрации пользователя
     *
     * @param user Пользователь
     */
    @Override
    public void signUp(User user) {
        this.validationForSignUp(user);
        if (repository.findById(user.getLogin()).isPresent()) {
            throw new IllegalArgumentException("Этот логин уже занят");
        } else {
            allUsersLogin.add(user.getLogin());
            this.repository.save(user);
        }
    }

    /**
     * Метод для проверки все ли поля заполнены данными
     *
     * @param user Пользователь
     * @throws IllegalArgumentException если поля не заполнены
     */
    private void validationForSignUp(User user) {
        if (this.nullOrEmpty(user.getName()) || this.nullOrEmpty(user.getPassword())
                || this.nullOrEmpty(user.getLogin())) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод для проверки пустая ли строка
     *
     * @param val Строка
     * @return true  если строка не пустая, false если пустая или null
     */
    private boolean nullOrEmpty(String val) {
        return val == null || val.isEmpty();
    }

    /**
     * Метод получения списка логинов всех пользователей
     * @return список allUsersLogin
     */
    @Override
    public HashSet<String> getAllLogin() {
        if (allUsersLogin == null || allUsersLogin.isEmpty()) {
            for (User user : repository.findAll()) {
                allUsersLogin.add(user.getLogin());
            }
            return allUsersLogin;
        }
        return allUsersLogin;
    }
}

