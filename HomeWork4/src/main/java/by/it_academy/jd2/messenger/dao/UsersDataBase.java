package by.it_academy.jd2.messenger.dao;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;

/**
 * Класс UsersDataBase, предназначенный для работы с учётными записями пользователей
 */
public class UsersDataBase {

    /**
     * Метод сохранения пользователя в базу данных
     * @param login логин пользователя
     * @param user пользователь
     * @throws ClassNotFoundException ошибка определения класса драйвера
     * @see ClassNotFoundException
     * @throws SQLException ошибка базы данных
     * @see SQLException
     */
    public static void saveUser(String login, User user) throws ClassNotFoundException, SQLException {
        String login1 = user.getLogin();
        String birth_day = user.getBirth_day();
        String name = user.getName();
        String password = user.getPassword();

        Class.forName("org.postgresql.Driver");
        String sql = "INSERT INTO messenger.users (password,name,login,birth_day) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);

        ) {
            ps.setString(1,password);
            ps.setString(2,name);
            ps.setString(3,login1);
            ps.setString(4,birth_day);
            int i = ps.executeUpdate();
        }
    }
    /**
     * Метод получения пользователя из базы данных
     * @param login логин пользователя
     * @throws ClassNotFoundException ошибка определения класса драйвера
     * @see ClassNotFoundException
     * @throws SQLException ошибка базы данных
     * @see SQLException
     * @return пользователь
     */
    public static User getUser(String login) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT * FROM messenger.users WHERE login = '" + login + "'";
        User user = null;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery();
        ) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String log = resultSet.getString("login");
                String password = resultSet.getString("password");
                String birth_day = resultSet.getString("birth_day");
                user = new User(name, log, password, birth_day);
            }
        }
        return user;
    }

    /**
     * Метод получения всех зарегестрированных пользователей из базы данных
     * @throws ClassNotFoundException ошибка определения класса драйвера
     * @see ClassNotFoundException
     * @throws SQLException ошибка базы данных
     * @see SQLException
     * @return список пользователей с соответствующими им логинами
     */
    public static HashMap<String, User> getUsersInMessenger() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT * FROM messenger.users";
        User user;
        HashMap<String, User> usersInMessenger = new HashMap<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/messenger", "postgres", "postgres");
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery();
        ) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String log = resultSet.getString("login");
                String password = resultSet.getString("password");
                String birth_day = resultSet.getString("birth_day");
                user = new User(name, log, password, birth_day);
                usersInMessenger.put(log, user);
            }
        }
        return usersInMessenger;
    }
}


