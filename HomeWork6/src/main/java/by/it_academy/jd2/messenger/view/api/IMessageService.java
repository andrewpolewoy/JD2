package by.it_academy.jd2.messenger.view.api;

import by.it_academy.jd2.messenger.model.Message;
import java.util.List;

/**
 * Интерфейс сообщений
 */
public interface IMessageService {
    /** Получить сообщения */
    List<Message> getMessage(String login);
    /** Сохранить сообщения */
    void addMessage(Message message);
}
