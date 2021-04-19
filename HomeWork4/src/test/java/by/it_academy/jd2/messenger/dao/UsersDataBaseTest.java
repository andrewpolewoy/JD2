package by.it_academy.jd2.messenger.dao;

import by.it_academy.jd2.messenger.model.User;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;


public class UsersDataBaseTest {

    User user = new User();

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

    @BeforeEach
    public void setUpEach() throws SQLException, ClassNotFoundException {
        user.setLogin("testLogin");
        user.setBirth_day("2021-05-01");
        user.setName("testUser");
        user.setPassword("testPassword");
    }

    @AfterEach
    public void tearDownEach() throws Exception {
        deleteUser(user.getLogin());
        User user = null;
    }

    @DisplayName("Тест сохранения пользователя в бд")
    @Test
    public void saveUser() throws SQLException, ClassNotFoundException {
        UsersDataBase.saveUser(user.getLogin(), user);
        User inspected = UsersDataBase.getUser(user.getLogin());
        String login =  user.getLogin();
        String birth_day =  user.getBirth_day();
        String name =  user.getName();
        String password =  user.getPassword();
        Assertions.assertEquals(inspected.getLogin(), login);
        Assertions.assertEquals(inspected.getBirth_day(), birth_day);
        Assertions.assertEquals(inspected.getName(), name);
        Assertions.assertEquals(inspected.getPassword(), password);
    }

    @DisplayName("Тест получения пользователя из бд")
    @Test
    public void getUser() throws SQLException, ClassNotFoundException {
        UsersDataBase.saveUser(user.getLogin(), user);
        User inspected = UsersDataBase.getUser(user.getLogin());
        String login =  user.getLogin();
        String birth_day =  user.getBirth_day();
        String name =  user.getName();
        String password =  user.getPassword();
        Assertions.assertEquals(inspected.getLogin(), login);
        Assertions.assertEquals(inspected.getBirth_day(), birth_day);
        Assertions.assertEquals(inspected.getName(), name);
        Assertions.assertEquals(inspected.getPassword(), password);
    }

    @DisplayName("Тест получения всех пользователей из бд")
    @Test
    public void getUsersInMessenger() throws SQLException, ClassNotFoundException {
        HashMap<String, User> inspected = UsersDataBase.getUsersInMessenger();
        int before = inspected.size();
        UsersDataBase.saveUser(user.getLogin(), user);
        HashMap<String, User> inspected1 = UsersDataBase.getUsersInMessenger();
        int after = inspected1.size();
        String login =  user.getLogin();
        String birth_day =  user.getBirth_day();
        String name =  user.getName();
        String password =  user.getPassword();
        Assertions.assertNotEquals(0, (after - before));
        Assertions.assertEquals(inspected1.get(login).getLogin(), login);
        Assertions.assertEquals(inspected1.get(login).getBirth_day(), birth_day);
        Assertions.assertEquals(inspected1.get(login).getName(), name);
        Assertions.assertEquals(inspected1.get(login).getPassword(), password);
    }
}