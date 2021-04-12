package by.it_academy.jd2.dao;
import by.it_academy.jd2.core.dto.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс AirportDAO, предназначенный для получения из базы данных списка аэропортов
 */
public class AirportDAO  {
    /**
     * Конструктор класса
     */
    public AirportDAO() {
    }

    /**
     * Метод, который получает список аэропортов
     * @throws ClassNotFoundException - ошибка при получении драйвера базы данных
     * @see ClassNotFoundException
     * @return список аэропортов
     */
    public List<Airport> list() throws ClassNotFoundException {
        List<Airport> airports = new ArrayList<>();
        Class.forName("org.postgresql.Driver");

        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
                PreparedStatement statement = connection.prepareStatement("SELECT airport_code, airport_name, city, coordinates, timezone FROM bookings.airports ORDER BY city");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Airport airport = new Airport();
                airport.setAirport_code(resultSet.getString("airport_code"));
                airport.setAirport_name(resultSet.getString("airport_name"));
                airport.setCity(resultSet.getString("city"));
                airport.setCoordinates(resultSet.getObject("coordinates"));
                airport.setTimezone(resultSet.getString("timezone"));
                airports.add(airport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return airports;
    }

}
