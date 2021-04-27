package by.it_academy.jd2.dao.hibernate;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.dao.api.IAirport;
import by.it_academy.jd2.dao.dbsql.FlightsDAO;
import by.it_academy.jd2.dao.utils.HibernateCreatorDemo;
import org.hibernate.Session;
import java.util.List;

/** Класс AirportDAO, предназначенный для получения из базы данных списка аэропортов */
public class AirportHibernateDAO implements IAirport {

    /** Объект класса Session */
    private final Session ds;

    /** Новый объект собственного класса */
    private final static AirportHibernateDAO instance = new AirportHibernateDAO();

    /** Конструктор класса, который инициализипует объект Session */
    private AirportHibernateDAO() {
        this.ds = HibernateCreatorDemo.getInstance().openSession();
    }

    /** Метод, который получает список аэропортов
     * @return список аэропортов
     */
    public List<Airport> getList() {
        return (List<Airport>) ds.createQuery("FROM Airport ORDER BY city").list();
    }

    /** Метод, который возвращает экземпляр собственного класса
     * @return экземпляр собственного класса {@link AirportHibernateDAO}
     * */
    public static AirportHibernateDAO getInstance() {
        return instance;
    }
}
