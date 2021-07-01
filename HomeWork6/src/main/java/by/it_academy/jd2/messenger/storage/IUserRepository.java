package by.it_academy.jd2.messenger.storage;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

/**
 * Специальное расширение репозитория JPA для класса User
 */
public interface IUserRepository extends JpaRepository<User, String> {
    /** Получить пользователя */
    User getUserByLogin(String login);
}
