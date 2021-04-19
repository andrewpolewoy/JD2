package by.it_academy.jd2.messenger.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Класс User , предназначенный для создания сообщения
 * с параметрами <b>from</b>, <b>sendDate</b>, <b>text</b>
 * реализует интерфейс {@link Serializable}
 */
public class Message implements Serializable {
    /** Логин отправителя */
    private String from;
    /** Дата отправления */
    private Date sendDate;
    /** Текст сообщения */
    private String text;

    /**
     * Метод получения значения поля {@link Message#from}
     * @return возвращает логин отправителя
     */
    public String getFrom() {
        return from;
    }
    /**
     * Метод определения отправителя {@link Message#from}
     * @param from отправителя
     */
    public void setFrom(String from) {
        this.from = from;
    }
    /**
     * Метод получения значения поля {@link Message#sendDate}
     * @return возвращает дату отправки
     */
    public Date getSendDate() {
        return sendDate;
    }
    /**
     * Метод определения даты отправки {@link Message#sendDate}
     * @param sendDate дата отправки
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    /**
     * Метод получения значения поля {@link Message#text}
     * @return возвращает текст сообщения
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
