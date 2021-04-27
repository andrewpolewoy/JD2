package by.it_academy.jd2.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DataSourceCreatorDemoTest {

    private DataSource instance;

    @DisplayName("Тест получения экземпляра собственного класса")
    @Test
    public void getInstance() {
        try {
            this.instance = DataSourceCreatorDemo.getInstance();
            Assertions.assertEquals(0, instance.getLoginTimeout());
        } catch (IOException | SQLException | PropertyVetoException e) {
            Assertions.fail("Exception appeared");
            e.printStackTrace();
        }
    }
}