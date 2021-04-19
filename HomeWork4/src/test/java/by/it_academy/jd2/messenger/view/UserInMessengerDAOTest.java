package by.it_academy.jd2.messenger.view;

import by.it_academy.jd2.messenger.dao.UsersDataBase;
import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class UserInMessengerDAOTest {

    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;
    UserInMessengerDAO userInMessengerDAO = new UserInMessengerDAO();
    private Message message1 = new Message();
    private Message message2 = new Message();

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

    @BeforeEach
    public void setUpEach() {
        user1 = new User("Максимов", "LAMA", "3558", "12.12.59");
        user2 = new User("PETROVICH", "12кило", "34kilo", "11.11.87");
        user3 = new User("Гайдукова", "LAMAch", "hhYu", "25.04.96");
        user4 = new User("Gtthg", "887", "lomtic", "12.04.91");
        user5 = new User("rerwef", "Uber", "4matic", "12.06.91");
        message1 = new Message();
        message1.setText("Какой-то текст");
        message1.setFrom(user1.getLogin());
        message1.setSendDate(new Date());

        message2 = new Message();
        message2.setText("Ещё один Какой-то текст");
        message2.setFrom(user1.getLogin());
        message2.setSendDate(new Date());
    }

    @AfterEach
    public void tearDownEach() throws Exception {
        deleteMessage(message1.getFrom());
        deleteMessage(message2.getFrom());
        deleteUser(user1.getLogin());
        deleteUser(user2.getLogin());
        deleteUser(user3.getLogin());
        deleteUser(user4.getLogin());
        deleteUser(user5.getLogin());
        user1 = null;
        user2 = null;
        user3 = null;
        user4 = null;
        user5 = null;
        userInMessengerDAO = null;
        message1 = null;
        message2 = null;
    }

    @DisplayName("Тест сохранения пользователя")
    @Test
    public void saveUser() {
        userInMessengerDAO.saveUser(user1.getLogin(), user1);
        userInMessengerDAO.saveUser(user2.getLogin(), user2);
        userInMessengerDAO.getUser(user2.getLogin());
        userInMessengerDAO.getUser(user2.getLogin());
        String inspected = userInMessengerDAO.getUser(user1.getLogin()).getLogin();
        String actual = user1.getLogin();
        Assertions.assertEquals(inspected, actual);

    }

    @DisplayName("Тест получения всех зарегестрированных пользователей")
    @Test
    public void getUsersInMessenger() {
        int size = userInMessengerDAO.getUsersInMessenger().size();
        userInMessengerDAO.saveUser("LAMA", user1);
        userInMessengerDAO.saveUser("12кило", user2);
        HashMap<String, User> usersInMessengerDao = userInMessengerDAO.getUsersInMessenger();
        int inspectedSize = usersInMessengerDao.size();
        String inspectedLogin = usersInMessengerDao.get("LAMA").getLogin();
        String actualLogin = "LAMA";
        String inspectedLogin1 = usersInMessengerDao.get("12кило").getLogin();
        String actualLogin1 = "12кило";
        Assertions.assertEquals(2, (inspectedSize - size));
        Assertions.assertEquals(inspectedLogin, actualLogin);
        Assertions.assertEquals(inspectedLogin1, actualLogin1);
    }

    @DisplayName("Тест получения пользователя")
    @Test
    public void getUser() {
        userInMessengerDAO.saveUser("Uber", user5);
        String inspected = userInMessengerDAO.getUser(user5.getLogin()).getLogin();
        String actual = user5.getLogin();

        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            userInMessengerDAO.saveUser("Uber", user5);
        });
        assertNotNull(thrown.getMessage());
        Assertions.assertEquals(actual, inspected);
    }

    @DisplayName("Тест получения сообщения")
    @Test
    public void getMessage() {
    }

    @DisplayName("Тест сохранения пользователя")
    @Test
    public void setMessage() {
        userInMessengerDAO.saveUser("LAMA", user1);
        ArrayList<Message> mess1 = new ArrayList<>();
        userInMessengerDAO.setMessage(user4.getLogin(), message1);
        userInMessengerDAO.setMessage(user4.getLogin(), message2);
        mess1.add(message1);
        mess1.add(message2);
        ArrayList<Message> message1 = userInMessengerDAO.getMessage(user4.getLogin());
        Assertions.assertEquals(mess1.get(0).getText(), message1.get(0).getText());
        Assertions.assertEquals(mess1.get(1).getText(), message1.get(1).getText());
    }

    @Test
    public void getInstance() {
        UserInMessengerDAO instance = UserInMessengerDAO.getInstance();
        Assertions.assertEquals(instance, instance);
    }
}