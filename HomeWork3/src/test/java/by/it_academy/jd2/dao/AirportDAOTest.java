package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AirportDAOTest {

    private final AirportDAO flightsDAO = new AirportDAO();
    private final int num = 104;

   @DisplayName("Тест получения списка аэропортов")
   @Test
    void list() {
       int size = 0;
        try {
            List<Airport> list = flightsDAO.list();
            size = list.size();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       Assertions.assertEquals(num, size);
   }
}