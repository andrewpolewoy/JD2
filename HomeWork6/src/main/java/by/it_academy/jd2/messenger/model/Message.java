package by.it_academy.jd2.messenger.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/** Класс сообщения, реализует интерфейс {@link Serializable} */
@Entity(name = "Message")
@Table(name = "message",schema = "hibernate")
public class Message implements Serializable {

    /** Поле ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Логин отправителя */
    @Column(name = "from_user", nullable = false)
    private String from;

    /** Логин получателя */
    @Column(name = "recipient", nullable = false)
    private  String recipient;

    /** Дата отправления */
    @Column(name = "send_date", nullable = false)
    private LocalDateTime sendDate;

    /** Текст сообщения */
    @Column(name = "text", nullable = false)
    private String text;

    /** Конструктор без параметров */
    public Message() {
    }

    /**
     * Конструктор с параметрами
     * @param from отправитель
     * @param recipient получатель
     * @param text текст
     * @param sendDate Дата отправления
     */
    public Message(String from, String recipient, LocalDateTime sendDate, String text) {
        this.from = from;
        this.recipient = recipient;
        this.sendDate = sendDate;
        this.text = text;
    }

    /**
     * Метод получения значения поля {@link Message#recipient}
     * @return логин получателя
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Метод определения получателя {@link Message#recipient}
     * @param recipient получатель
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Метод получения значения поля {@link Message#from}
     * @return логин отправителя
     */
    public String getFrom() {
        return from;
    }

    /**
     * Метод определения отправителя {@link Message#from}
     * @param from отправитель
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Метод получения значения поля {@link Message#sendDate}
     * @return дата отправки
     */
    public LocalDateTime getSendDate() {
        return sendDate;
    }

    /**
     * Метод определения даты отправки {@link Message#sendDate}
     * @param sendDate дата отправки
     */
    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }
    /**
     * Метод получения значения поля {@link Message#text}
     * @return текст сообщения
     */
    public String getText() {
        return text;
    }

    /**
     * Метод определения текста сообщения {@link Message#text}
     * @param text текст сообщения
     */
    public void setText(String text) {
        this.text = text;
    }
}
