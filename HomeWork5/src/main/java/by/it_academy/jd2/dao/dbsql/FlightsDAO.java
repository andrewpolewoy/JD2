package by.it_academy.jd2.dao.dbsql;

import by.it_academy.jd2.core.dto.Flights;
import by.it_academy.jd2.dao.api.IFlight;
import by.it_academy.jd2.dao.utils.DataSourceCreatorDemo;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс FlightsDAO, предназначенный для получения из базы данных списка рейсов
 */
public class FlightsDAO implements IFlight {

    /** Объект класса DataSource */
    private DataSource ds;

    /** Новый объект собственного класса */
    private final static FlightsDAO instance = new FlightsDAO();



    /**  Конструктор класса, который инициализипует объект DataSource */
    private FlightsDAO() {
        try {
            this.ds = DataSourceCreatorDemo.getInstance();
        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который получает список рейсов
     * @param dateDeparture - дата вылета
     * @param airportDeparture - аэропорт вылета
     * @param airportArrival - аэропорт прилёта
     * @param limit - количество строк на странице
     * @param page - страница
     * @return список рейсов
     */
    public List<Flights> getList(String dateDeparture, String airportDeparture, String airportArrival, String limit, String page)  {
        List<Flights> flights = new ArrayList<>();
        int limit1 = Integer.parseInt(limit);
        int offset = (Integer.parseInt(page) - 1) * limit1;
        String sqlDate = dateDeparture.substring(6,10) + "-" + dateDeparture.substring(0,2) + "-" +
                dateDeparture.substring(3,5);
        LocalDate localDate = LocalDate.parse(sqlDate);
        String sql = "SELECT f.flight_no, f.scheduled_departure, f.scheduled_arrival, f.departure_airport_name, " +
                "f.arrival_airport_name, f.status " +
                "FROM bookings.flights_v f " +
                "WHERE  departure_airport_name = '" + airportDeparture + "' AND " +
                "arrival_airport_name = '" + airportArrival + "' AND scheduled_departure >='" + localDate + "'::date " +
                "AND scheduled_departure < ('" + localDate + "'::date + '1 day'::interval)" +
                "ORDER BY f.scheduled_departure LIMIT " + limit1 + " OFFSET " + offset;

        try (
                Connection connection = this.ds.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Flights flight = new Flights();
                flight.setFlight_no(resultSet.getString("flight_no"));
                flight.setScheduled_departure(resultSet.getString("scheduled_departure"));
                flight.setScheduled_arrival( resultSet.getString("scheduled_arrival"));
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
     * @return список рейсов
     */
    public int getRowCount(String dateDeparture, String airportDeparture, String airportArrival) {
        int numberOfRows = 0;
        String sqlDate = dateDeparture.substring(6,10) + "-" + dateDeparture.substring(0,2) + "-" +
                dateDeparture.substring(3,5);
        LocalDate localDate = LocalDate.parse(sqlDate);
        String sql = "SELECT COUNT(*)" +
                "FROM bookings.flights_v  " +
                "WHERE  departure_airport_name = '" + airportDeparture + "' AND " +
                "arrival_airport_name = '" + airportArrival + "' AND scheduled_departure >='" + localDate + "'::date " +
                "AND scheduled_departure < ('" + localDate + "'::date + '1 day'::interval)";
        try (
                Connection connection = this.ds.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
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

    /** Метод, который возвращает экземпляр собственного класса
     * @return экземпляр собственного класса {@link FlightsDAO}
     */
    public static FlightsDAO getInstance() {
        return instance;
    }
}


