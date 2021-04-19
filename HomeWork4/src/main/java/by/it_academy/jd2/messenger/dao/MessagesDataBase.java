package by.it_academy.jd2.messenger.dao;

import by.it_academy.jd2.messenger.model.Message;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Класс MessagesDataBase, предназначенный для работы с сообщениями
 */
public class MessagesDataBase {

    /**
     * Метод сохранения сообщения в базе данных
     * @param recipient получатель сообщения
     * @param message сообщение
     * @throws ClassNotFoundException ошибка определения класса драйвера
     * @see ClassNotFoundException
     * @throws SQLException ошибка базы данных
     * @see SQLException
     */
    public static void setMessage(String recipient, Message message) throws ClassNotFoundException, SQLException {
        java.sql.Timestamp send_date = new java.sql.Timestamp(message.getSendDate().getTime());
        String from = message.getFrom();
        String text = message.getText();

        Class.forName("org.postgresql.Driver");
        String sql = "INSERT INTO messenger.message (from_user,send_date,text,recipient) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, from);
            ps.setTimestamp(2,send_date);
            ps.setString(3,text);
            ps.setString(4,recipient);
            ps.executeUpdate();
        }
    }
    /**
     * Метод получения списка сообщений
     * @param recipient получатель сообщения
     * @throws ClassNotFoundException ошибка определения класса драйвера
     * @see ClassNotFoundException
     * @throws SQLException ошибка базы данных
     * @see SQLException
     * @return список сообщений
     */
    public static ArrayList<Message> getMessage(String recipient) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT message.from_user, message.send_date, message.text, message.recipient " +
                "FROM messenger.message, messenger.users " +
                "WHERE users.login=message.from_user AND message.recipient='" + recipient + "'";
        ArrayList<Message> chats = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery();
        ) {
            while (resultSet.next()) {
                Message message = new Message();
                message.setFrom(resultSet.getString("from_user"));
                message.setSendDate(new Date(resultSet.getTimestamp("send_date").getTime()));
                message.setText(resultSet.getString("text"));
                chats.add(message);
            }
            return chats;
        }
    }
}


