package by.it_academy.jd2.dao.hibernate;

import by.it_academy.jd2.core.dto.Flights;
import by.it_academy.jd2.dao.api.IFlight;
import by.it_academy.jd2.dao.utils.HibernateCreatorDemo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.util.List;

/** Класс FlightsDAO, предназначенный для получения из базы данных списка рейсов */
public class FlightsHibernateDAO implements IFlight {

    /** Объект класса Session */
    private final Session ds;

    /** Новый объект собственного класса */
    private final static FlightsHibernateDAO instance = new FlightsHibernateDAO();



    /** Конструктор класса, который инициализипует объект DataSource */
    private FlightsHibernateDAO() {
        this.ds = HibernateCreatorDemo.getInstance().openSession();
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
        Query query;
        int limit1 = Integer.parseInt(limit);
        int offset = (Integer.parseInt(page) - 1) * limit1;
        String sqlDate = dateDeparture.substring(6,10) + "-" + dateDeparture.substring(0,2) + "-" +
                dateDeparture.substring(3,5);
        LocalDate localDate = LocalDate.parse(sqlDate);
         query = ds.createQuery( "FROM Flights " +
                "WHERE  departure_airport_name =:airportDeparture AND " +
                "arrival_airport_name =:airportArrival AND DATE(scheduled_departure)=:departureDate " +
                "ORDER BY scheduled_departure");

        query.setParameter("airportDeparture",airportDeparture);
        query.setParameter("airportArrival",airportArrival);
        query.setParameter("departureDate", localDate);
        query.setFirstResult(offset);
        query.setMaxResults(limit1);
        return (List<Flights>)query.list();
    }

    /**
     * Метод, который считает количество строк
     * @param dateDeparture - дата вылета
     * @param airportDeparture - аэропорт вылета
     * @param airportArrival - аэропорт прилёта
     * @return список рейсов
     */
    public int getRowCount(String dateDeparture, String airportDeparture, String airportArrival) {
        String sqlDate = dateDeparture.substring(6,10) + "-" + dateDeparture.substring(0,2) + "-" +
                dateDeparture.substring(3,5);
        LocalDate localDate = LocalDate.parse(sqlDate);
        Query query = ds.createQuery("SELECT COUNT(*) FROM Flights WHERE  departure_airport_name =:airportDeparture AND arrival_airport_name =:airportArrival AND DATE(scheduled_departure)=:departureDate");
        query.setParameter("airportDeparture",airportDeparture);
        query.setParameter("airportArrival",airportArrival);
        query.setParameter("departureDate", localDate);

        Long result = (Long)query.getSingleResult();
        return result.intValue();
    }

    /** Метод, который возвращает экземпляр собственного класса
     * @return экземпляр собственного класса {@link FlightsHibernateDAO}
     */
    public static FlightsHibernateDAO getInstance() {
        return instance;
    }
}


