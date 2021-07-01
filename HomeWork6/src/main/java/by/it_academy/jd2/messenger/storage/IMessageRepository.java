package by.it_academy.jd2.messenger.storage;

import by.it_academy.jd2.messenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Специальное расширение репозитория JPA для класса Message
 */
public interface IMessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByRecipient(String recipient);
}
