package by.it_academy.jd2.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HibernateCreatorDemoTest {

    @DisplayName("Тест получения экземпляра собственного класса")
    @Test
    public void getInstance() {
        Assertions.assertNotNull(HibernateCreatorDemo.getInstance());
    }
}