package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.dao.AirportDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;


/**
 * Cервлет, отвечающий за отображение аэропортов.
 */
@WebServlet("/airports")
public class AirportsServlet extends HttpServlet {

private AirportDAO airportDAO;
    /**
     * Метод инициализации, который создаёт объект класса {@link AirportDAO#AirportDAO}
     */
    @Override
    public void init() {
         airportDAO = new AirportDAO();
    }
    /**
     * Метод, обрабатывающий GET запросы
     * @param request - запрос от пользователя
     * @param response - ответ пользователю
     * @throws IOException - ошибка ввода-вывода
     * @see IOException
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Airport> airports = airportDAO.list();
            request.setAttribute("airports", airports);
            request.getRequestDispatcher("airports.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }

    }
}
