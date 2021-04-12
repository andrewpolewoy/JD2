package by.it_academy.jd2.core.dto;
/**
 * Класс Airport, предназначенный для хранения записи аэропорта
 * с параметрами <b>airport_code</b>, <b>airport_name</b>, <b>city</b>, <b>coordinates</b>, <b>timezone</b>,
 *  <b>message</b>
 */
public class Airport {

    private String airport_code;
    private String airport_name;
    private String city;
    private Object coordinates;
    private String timezone;


    public String getAirport_code() {
        return airport_code;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return

                "Город:'" + city + '\'' +
                ", Название:'" + airport_name + '\'' +
                ", Часовой пояс:'" + timezone + '\'';
    }
}
