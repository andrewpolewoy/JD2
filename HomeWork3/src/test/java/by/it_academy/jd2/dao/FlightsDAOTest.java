package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.Flights;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FlightsDAOTest {

    private final FlightsDAO flightsDAO = new FlightsDAO();
    private final int num = 5;

    @DisplayName("Тест получения списка рейсов")
    @Test
    public void list() {
        int size = 0;
        try {
            List<Flights> list = flightsDAO.list("15/08/2016", "Шереметьево", "Пулково", "25", "1");
            size = list.size();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(num, size);
    }

    @DisplayName("Тест по подсчёту строк")
    @Test
    public void getRowCount() {
        int rowCount = 0;
        try {
            rowCount = flightsDAO.getRowCount("15/08/2016", "Шереметьево", "Пулково");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(num, rowCount);
    }
}