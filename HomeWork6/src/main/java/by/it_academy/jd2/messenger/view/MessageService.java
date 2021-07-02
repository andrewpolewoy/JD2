package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.storage.IMessageRepository;
import by.it_academy.jd2.messenger.view.api.IMessageService;

import java.util.List;

/** Класс для работы с сообщениями */
public class MessageService implements IMessageService {

    /** Экземпляр класса IMessageRepository */
    private final IMessageRepository repository;

    /**
     * Конструктор с инициализацией экземпляра класса {@link IMessageRepository}
     * @param repository класс репозитория сообщений
     */
    public MessageService(IMessageRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод получения всех сообщений для текущего пользователя
     * @param login Логин
     * @return сообщения
     */
    @Override
    public List<Message> getMessage(String login) {
        return this.repository.findAllByRecipient(login);
    }

    /**
     * Метод сохранения сообщения для текущего пользователя
     * @param message сообщение
     */
    @Override
    public void addMessage(Message message) {
        this.repository.save(message);
    }

}
