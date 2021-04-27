package by.it_academy.jd2.dao.dbsql;

import by.it_academy.jd2.core.dto.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


public class AirportDAOTest {

    private final AirportDAO flightsDAO = AirportDAO.getInstance();
    private final int num = 104;

    @DisplayName("Тест получения списка аэропортов")
    @Test
    public void getList() {
        int size = 0;
        List<Airport> list = flightsDAO.getList();
        size = list.size();
        Assertions.assertEquals(num, size);
    }

    @DisplayName("Тест получения экземпляра собственного класса")
    @Test
    public void getInstance() {
        Assertions.assertNotNull(AirportDAO.getInstance());
    }
}
