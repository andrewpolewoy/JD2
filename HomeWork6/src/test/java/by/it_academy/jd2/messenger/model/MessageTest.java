package by.it_academy.jd2.messenger.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class MessageTest {


    /**
     * Экземпляр класса LocalDateTime. Используется как один из параметров конструктора
     */
    private LocalDateTime sendDate = LocalDateTime.now();

    /**
     * Переменная экземпляра класса Message
     */
    private Message message;

    /**
     * Инициализирует переменную класса перед тестами
     */
    @BeforeEach
    public void setUp() {
        message = new Message("from", "recipient", sendDate, "text");
    }

    @DisplayName("Тест проверяет правильность получения поля recipient")
    @Test
    public void getRecipient() {
        Assertions.assertEquals("recipient",message.getRecipient());
    }

    @DisplayName("Тест проверяет правильность получения поля from")
    @Test
    public void getFrom() {
        Assertions.assertEquals("from",message.getFrom());
    }

    @DisplayName("Тест проверяет правильность получения поля sendDate")
    @Test
    public void getSendDate() {
        Assertions.assertEquals(sendDate,message.getSendDate());
    }

    @DisplayName("Тест проверяет правильность получения поля text")
    @Test
    public void getText() {
        Assertions.assertEquals("text",message.getText());
    }
}