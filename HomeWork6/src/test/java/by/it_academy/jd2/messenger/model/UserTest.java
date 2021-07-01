package by.it_academy.jd2.messenger.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UserTest {

    /**
     * Переменная экземпляра класса User
     */
    private User user;

    /**
     * Инициализирует переменную класса перед тестами
     */
    @BeforeEach
    public void setUp() {
        user = new User("name", "login", "password", "birth_day");
    }

    @DisplayName("Тест проверяет правильность получения поля name")
    @Test
    public void getName() {
        Assertions.assertEquals("name",user.getName());
    }

    @DisplayName("Тест проверяет правильность получения поля login")
    @Test
    public void getLogin() {
        Assertions.assertEquals("login",user.getLogin());
    }

    @DisplayName("Тест проверяет правильность получения поля password")
    @Test
    public void getPassword() {
        Assertions.assertEquals("password",user.getPassword());
    }

    @DisplayName("Тест проверяет правильность получения поля birth_day")
    @Test
    public void getBirth_day() {
        Assertions.assertEquals("birth_day",user.getBirth_day());
    }
}