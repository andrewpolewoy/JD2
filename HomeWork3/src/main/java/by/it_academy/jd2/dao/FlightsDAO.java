package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.Flights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс FlightsDAO, предназначенный для получения из базы данных списка рейсов
 */
public class FlightsDAO {
    /**
     * Конструктор класса
     */
    public FlightsDAO() {
    }

    /**
     * Метод, который получает список рейсов
     * @param dateDeparture - дата вылета
     * @param airportDeparture - аэропорт вылета
     * @param airportArrival - аэропорт прилёта
     * @param limit - количество строк на странице
     * @param page - страница
     * @throws ClassNotFoundException - ошибка при получении драйвера базы данных
     * @see ClassNotFoundException
     * @return список рейсов
     */
    public List<Flights> list(String dateDeparture, String airportDeparture, String airportArrival, String limit, String page) throws ClassNotFoundException {
        List<Flights> flights = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        int limit1 = Integer.parseInt(limit);
        int offset = (Integer.parseInt(page) - 1) * limit1;

        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
                PreparedStatement statement = connection.prepareStatement("SELECT f.flight_no, f.scheduled_departure, f.scheduled_arrival, f.departure_airport_name, " +
                        "f.arrival_airport_name, f.status " +
                        "FROM bookings.flights_v f " +
                        "WHERE  departure_airport_name = '" + airportDeparture + "' AND " +
                        "arrival_airport_name = '" + airportArrival + "' AND scheduled_departure >='" + dateDeparture + "'::date " +
                        "AND scheduled_departure < ('" + dateDeparture + "'::date + '1 day'::interval)" +
                        "ORDER BY f.scheduled_departure LIMIT " + limit1 + " OFFSET " + offset);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Flights flight = new Flights();
                flight.setFlight_no(resultSet.getString("flight_no"));
                flight.setScheduled_departure(resultSet.getObject("scheduled_departure"));
                flight.setScheduled_arrival(resultSet.getObject("scheduled_arrival"));
                flight.setDeparture_airport_name(resultSet.getString("departure_airport_name"));
                flight.setArrival_airport_name(resultSet.getString("arrival_airport_name"));
                flight.setStatus(resultSet.getString("status"));
                flights.add(flight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return flights;
    }

    /**
     * Метод, который считает количество строк
     * @param dateDeparture - дата вылета
     * @param airportDeparture - аэропорт вылета
     * @param airportArrival - аэропорт прилёта
     * @throws ClassNotFoundException - ошибка при получении драйвера базы данных
     * @see ClassNotFoundException
     * @return список рейсов
     */
    public int getRowCount(String dateDeparture, String airportDeparture, String airportArrival) throws ClassNotFoundException {
        List<Flights> flights = new ArrayList<>();
        int numberOfRows = 0;
        Class.forName("org.postgresql.Driver");

        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*)" +
                        "FROM bookings.flights_v  " +
                        "WHERE  departure_airport_name = '" + airportDeparture + "' AND " +
                        "arrival_airport_name = '" + airportArrival + "' AND scheduled_departure >='" + dateDeparture + "'::date " +
                        "AND scheduled_departure < ('" + dateDeparture + "'::date + '1 day'::interval)");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                numberOfRows = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return numberOfRows;
    }

}
