package by.it_academy.jd2.messenger.view.api;

import by.it_academy.jd2.messenger.model.Message;
import java.util.List;

/** Интерфейс сообщений */
public interface IMessageService {

    /**
     * Получить сообщения
     * @param login логин
     * @return список сообщений
     */
    List<Message> getMessage(String login);

    /**
     * Сохранить сообщения
     * @param message сообщение
     */
    void addMessage(Message message);
}
