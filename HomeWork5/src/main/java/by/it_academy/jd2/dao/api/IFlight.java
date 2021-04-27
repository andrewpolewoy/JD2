package by.it_academy.jd2.dao.api;

import by.it_academy.jd2.core.dto.Flights;
import java.util.List;

/** Интерфейс полётов */
public interface IFlight {
    List<Flights> getList(String dateDeparture, String airportDeparture, String airportArrival, String limit, String page);
    int getRowCount(String dateDeparture, String airportDeparture, String airportArrival);

}
