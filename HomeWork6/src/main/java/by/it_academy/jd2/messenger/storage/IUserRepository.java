package by.it_academy.jd2.messenger.storage;

import by.it_academy.jd2.messenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/** Специальное расширение репозитория JPA для класса User */
public interface IUserRepository extends JpaRepository<User, String> {

    /** Получить пользователя
     * @param login пользователя
     * @return пользователь
     */
    User getUserByLogin(String login);
}
