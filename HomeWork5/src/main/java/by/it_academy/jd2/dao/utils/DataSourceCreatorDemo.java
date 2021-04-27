package by.it_academy.jd2.dao.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

/**  Класс для установки соединения с базой данных */
public class DataSourceCreatorDemo {

    /** Создание объекта DataSourceCreatorDemo  */
    private static DataSourceCreatorDemo instance;

    /** Создание объекта ComboPooledDataSource */
    private ComboPooledDataSource cpds;

    /**
     * Дэфолтеный конструктор с заданными ComboPooledDataSource параметрами
     * @throws IOException ошибка ввода-вывода
     * @throws SQLException ошибка доступа к базе данных или другие ошибки
     * @throws PropertyVetoException предлагаемое изменение свойства представляет недопустимое значение
     * @see PropertyVetoException
     * @see IOException
     * @see SQLException
     */
    private DataSourceCreatorDemo() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        cpds.setUser("postgres");
        cpds.setPassword("postgres");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    /**
     * Получает экземпляр класса DataSource
     * @return DataSource объект
     * @throws IOException ошибка ввода-вывода
     * @throws SQLException ошибка доступа к базе данных или другие ошибки
     * @throws PropertyVetoException предлагаемое изменение свойства представляет недопустимое значение
     * @see PropertyVetoException
     * @see IOException
     * @see SQLException
     */
    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (instance == null) {
            synchronized (DataSourceCreatorDemo.class) {
                instance = new DataSourceCreatorDemo();
            }
        }
        return instance.cpds;
    }
}