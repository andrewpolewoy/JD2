package by.it_academy.jd2.dao.hibernate;

import by.it_academy.jd2.core.dto.Flights;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


public class FlightsHibernateDAOTest {

    private final FlightsHibernateDAO flightsHibernateDAO = FlightsHibernateDAO.getInstance();
    private final int num = 5;

    @DisplayName("Тест получения списка рейсов")
    @Test
    public void getList() {
        int size = 0;
        List<Flights> list = flightsHibernateDAO.getList("08/15/2016", "Шереметьево", "Пулково", "25", "1");
        size = list.size();
        Assertions.assertEquals(num, size);
    }

    @DisplayName("Тест по подсчёту строк")
    @Test
    public void getRowCount() {
        int rowCount = 0;
        rowCount = flightsHibernateDAO.getRowCount("08/15/2016", "Шереметьево", "Пулково");
        Assertions.assertEquals(num, rowCount);
    }

    @DisplayName("Тест получения экземпляра собственного класса")
    @Test
    public void getInstance() {
        Assertions.assertNotNull(FlightsHibernateDAO.getInstance());
    }


}