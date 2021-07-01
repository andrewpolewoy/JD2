package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.storage.IMessageRepository;
import by.it_academy.jd2.messenger.view.api.IMessageService;
import java.util.List;

/**
 * Класс для работы с сообщениями.
 */
public class MessageService implements IMessageService {

    private final IMessageRepository repository;

    public MessageService(IMessageRepository repository) {
        this.repository = repository;
    }

    /**
     * Получить все сообщения для текущего пользователя
     *
     * @param login Логин
     * @return все сообщения для текущего пользователя
     */
    @Override
    public List<Message> getMessage(String login) {
        return this.repository.findAllByRecipient(login);
    }

    @Override
    public void addMessage(Message message) {
        this.repository.save(message);
    }

}
