package by.it_academy.jd2.dao.dbsql;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.dao.api.IAirport;
import by.it_academy.jd2.dao.utils.DataSourceCreatorDemo;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс AirportDAO, предназначенный для получения из базы данных списка аэропортов
 */
public class AirportDAO implements IAirport {

    /** Объект класса DataSource */
    private DataSource ds;

    /** Новый объект собственного класса */
    private final static AirportDAO instance = new AirportDAO();

    /**  Конструктор класса, который инициализипует объект DataSource */
    private AirportDAO() {
        try {
            this.ds = DataSourceCreatorDemo.getInstance();
        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который получает список аэропортов
     * @return список аэропортов
     */
    public List<Airport> getList()  {
        List<Airport> airports = new ArrayList<>();
        String sql = "SELECT airport_code, airport_name, city, coordinates, timezone FROM bookings.airports ORDER BY city";
        try (
                Connection connection = this.ds.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Airport airport = new Airport();
                airport.setAirport_code(resultSet.getString("airport_code"));
                airport.setAirport_name(resultSet.getString("airport_name"));
                airport.setCity(resultSet.getString("city"));
                airport.setCoordinates(resultSet.getString("coordinates"));
                airport.setTimezone(resultSet.getString("timezone"));
                airports.add(airport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return airports;
    }

    /** Метод, который возвращает экземпляр собственного класса
     * @return экземпляр собственного класса {@link AirportDAO}
     */
    public static AirportDAO getInstance() {
        return instance;
    }
}
