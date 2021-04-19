package by.it_academy.jd2.messenger.dao;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MessagesDataBaseTest {

    String recipient;
    Message message = new Message();
    User user = new User();

    @BeforeEach
    public void setUpEach() throws SQLException, ClassNotFoundException {
        recipient = "testRecipient";
        message.setSendDate(new Date());
        message.setFrom("testLogin");
        message.setText("Привет,test, how are you?");

        user.setLogin("testLogin");
        user.setBirth_day("12.12.12");
        user.setName("testUser");
        user.setPassword("testPassword");
        UsersDataBase.saveUser(user.getLogin(), user);
    }

    @AfterEach
    public void tearDownEach() throws Exception {
        deleteMessage(message.getFrom());
        deleteUser(user.getLogin());
        String recipient = null;
        Message message = null;
        User user = null;
    }

    /**
     * Метод, который удаляет тестовое сообщение из бд
     */
    public static void deleteMessage(String from) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String sql = "DELETE FROM messenger.message WHERE from_user='" + from + "'";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.executeUpdate();
        }
    }

    /**
     * Метод, который удаляет тестового пользователя из бд
     */
    public static void deleteUser(String login) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String sql = "DELETE FROM messenger.users WHERE login='" + login + "'";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.executeUpdate();
        }
    }

    @DisplayName("Тест сохранения сообщений в бд")
    @Test
    public void setMessage() throws SQLException, ClassNotFoundException {
        MessagesDataBase.setMessage(recipient, message);
        ArrayList<Message> messages = MessagesDataBase.getMessage(recipient);
        Message messageTest = messages.get(0);
        Assertions.assertEquals(message.getText(), messageTest.getText());
    }

    @DisplayName("Тест получения сообщений из бд")
    @Test
    public void getMessage() throws SQLException, ClassNotFoundException {
        MessagesDataBase.setMessage(recipient, message);
        ArrayList<Message> messages = MessagesDataBase.getMessage(recipient);
        Message messageTest = messages.get(0);
        Assertions.assertEquals(message.getText(), messageTest.getText());
    }
}