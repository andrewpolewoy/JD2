package by.it_academy.jd2.core.dto;
/**
 * Класс Flights, предназначенный для хранения записи рейс
 * с параметрами <b>flight_no</b>, <b>scheduled_departure</b>, <b>scheduled_arrival</b>, <b>departure_airport_name</b>, <b>arrival_airport_name</b>, <b>status</b>
 *  <b>message</b>
 */
public class Flights {

    private String flight_no;
    private Object scheduled_departure;
    private Object scheduled_arrival;
    private String departure_airport_name;
    private String arrival_airport_name;
    private String status;

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public Object getScheduled_departure() {
        return scheduled_departure;
    }

    public void setScheduled_departure(Object scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }

    public Object getScheduled_arrival() {
        return scheduled_arrival;
    }

    public void setScheduled_arrival(Object scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }

    public String getDeparture_airport_name() {
        return departure_airport_name;
    }

    public void setDeparture_airport_name(String departure_airport_name) {
        this.departure_airport_name = departure_airport_name;
    }

    public String getArrival_airport_name() {
        return arrival_airport_name;
    }

    public void setArrival_airport_name(String arrival_airport_name) {
        this.arrival_airport_name = arrival_airport_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flight_no='" + flight_no + '\'' +
                ", scheduled_departure=" + scheduled_departure +
                ", scheduled_arrival=" + scheduled_arrival +
                ", departure_airport_name='" + departure_airport_name + '\'' +
                ", arrival_airport_name='" + arrival_airport_name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
