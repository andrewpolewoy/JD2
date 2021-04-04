package by.it_academy.jd2.core.dto;


import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInMessengerTest {
    private  UserInMessenger user1;
    private  UserInMessenger user2;
    private  UserInMessenger user3;
    public static HashMap<String, UserInMessenger> usersInMessenger = new HashMap<>();
    private ArrayList<String> message;

    @BeforeEach
    public void setUpEach() throws Exception {
        user1 = new UserInMessenger("Максимов", "LAMA", "3558","12.12.59");
        user2 = new UserInMessenger("PETROVICH", "12кило", "34kilo","11.11.87");
        user3 = new UserInMessenger("Гайдукова", "LAMA", "hhYu","25.04.96");
        message = new ArrayList<>(Collections.singletonList("какое-то сообщение"));
        user3.setMessage(message);

    }

    @AfterEach
    public void tearDownEach() throws Exception {
        UserInMessenger user1 = null;
        UserInMessenger user2 = null;
        UserInMessenger user3 = null;

    }

    @DisplayName("Тест сохранения пользователя")
    @Test
    public void saveUser() {
        UserInMessenger.saveUser("LAMA", user1);
        UserInMessenger.saveUser("12кило", user2);

        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            UserInMessenger.saveUser("LAMA", user3);
        });
        assertNotNull(thrown.getMessage());
    }


    @DisplayName("Тест получения сообщений пользователя")
    @Test
    public void getMessage() {
        ArrayList<String> inspected1 =  user3.getMessage();
        Assertions.assertEquals(message,inspected1);
    }

    @DisplayName("Тест сохранения сообщений пользователя")
    @Test
    public void setMessage() {
        message = new ArrayList<>(Collections.singletonList("КаКое????? СсСообщен.е"));
        user3.setMessage(message);
        Assertions.assertEquals(message,user3.getMessage());
    }

    @DisplayName("Тест получения имени пользователя")
    @Test
    public void getName() {
        String inspected1 =  user1.getName();
        String actual1 = "Максимов";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  user2.getName();
        String actual2 = "PETROVICH";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  user3.getName();
        String actual3 = "Гайдукова";
        Assertions.assertEquals(inspected3,actual3);
    }

    @DisplayName("Тест получения логина пользователя")
    @Test
    public void getLogin() {
        String inspected1 =  user1.getLogin();
        String actual1 = "LAMA";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  user2.getLogin();
        String actual2 = "12кило";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  user3.getLogin();
        String actual3 = "LAMA";
        Assertions.assertEquals(inspected3,actual3);
    }

    @DisplayName("Тест получения пароля пользователя")
    @Test
    public void getPassword() {
        String inspected1 =  user1.getPassword();
        String actual1 = "3558";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  user2.getPassword();
        String actual2 = "34kilo";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  user3.getPassword();
        String actual3 = "hhYu";
        Assertions.assertEquals(inspected3,actual3);
    }

    @DisplayName("Тест получения даты рождения пользователя")
    @Test
    public void getBirth_day() {
        String inspected1 =  user1.getBirth_day();
        String actual1 = "12.12.59";
        Assertions.assertEquals(inspected1,actual1);

        String inspected2 =  user2.getBirth_day();
        String actual2 = "11.11.87";
        Assertions.assertEquals(inspected2,actual2);

        String inspected3 =  user3.getBirth_day();
        String actual3 = "25.04.96";
        Assertions.assertEquals(inspected3,actual3);
    }
}