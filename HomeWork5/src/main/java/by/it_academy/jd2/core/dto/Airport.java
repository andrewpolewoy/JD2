package by.it_academy.jd2.core.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс Airport, предназначенный для хранения записи аэропорта
 * с параметрами <b>airport_code</b>, <b>airport_name</b>, <b>city</b>, <b>coordinates</b>, <b>timezone</b>,
 *  <b>message</b>
 */

@Entity
@Table(name = "airports", schema = "bookings")
public class Airport {


    /** Код аэропорта */
    @Id
    @Column(name = "airport_code")
    private String airport_code;

    /** Название аэропорта */
    @Column(name = "airport_name")
    private String airport_name;

    /** Город */
    @Column(name = "city")
    private String city;

    /** Координаты */
    @Column(name = "coordinates")
    private String coordinates;

    /** Часовой пояс */
    @Column(name = "timezone")
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
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
