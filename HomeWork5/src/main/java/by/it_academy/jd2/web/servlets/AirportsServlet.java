package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.dao.api.IAirport;
import by.it_academy.jd2.dao.dbsql.AirportDAO;
import by.it_academy.jd2.dao.hibernate.AirportHibernateDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/** Cервлет, отвечающий за отображение аэропортов. */
@WebServlet("/airports")
public class AirportsServlet extends HttpServlet {

/** Объект класса интерфейса IAirport */
private final IAirport airportData;

/**  Конструктор собственного класса */
public AirportsServlet(){
    this.airportData = AirportHibernateDAO.getInstance();
}
    /**
     * Метод, обрабатывающий GET запросы
     * @param request запрос от пользователя
     * @param response ответ пользователю
     * @throws IOException ошибка ввода-вывода
     * @see IOException
     * @throws ServletException ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Airport> airports = airportData.getList();
        request.setAttribute("airports", airports);
        request.getRequestDispatcher("airports.jsp").forward(request, response);

    }
}
