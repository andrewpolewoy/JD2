package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.dto.Flights;
import by.it_academy.jd2.dao.AirportDAO;
import by.it_academy.jd2.dao.FlightsDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Cервлет, отвечающий за отображение найденных рейсов.
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private AirportDAO airportDAO;
    private FlightsDAO flightsDAO;

    /**
     * Метод инициализации, который создаёт объекты класса {@link AirportDAO#AirportDAO}
     * и класса {@link FlightsDAO#FlightsDAO}
     */
    public SearchServlet() {
        airportDAO = new AirportDAO();
        flightsDAO = new FlightsDAO();
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
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
    }
    /**
     * Метод, обрабатывающий POST запросы
     * @param req - запрос от пользователя
     * @param resp - ответ пользователю
     * @throws IOException - ошибка ввода-вывода
     * @see IOException
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getSession().getServletContext();
        int page;

        if (req.getParameter("currentPage") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(req.getParameter("currentPage"));
        }
        List<Airport> airports = null;
        try {
            airports = airportDAO.list();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("airports", airports);
        String dateDeparture = req.getParameter("dateDeparture");
        String airportDeparture = req.getParameter("airportDeparture");
        String airportArrival = req.getParameter("airportArrival");
        if (dateDeparture == null ||  airportDeparture == null ||  airportArrival == null){
            resp.sendRedirect(req.getContextPath() + "/search");
        }else {
            try {
                int numberOfRows = flightsDAO.getRowCount(dateDeparture, airportDeparture, airportArrival);
                int rowsOnPage = 25;
                int maxPage = (int) Math.ceil((double)numberOfRows / rowsOnPage);
                List<Flights> flights = flightsDAO.list(dateDeparture, airportDeparture, airportArrival,String.valueOf(rowsOnPage),String.valueOf(page));
                if (flights.isEmpty()){
                    req.setAttribute("error", true);
                    req.setAttribute("message", "Ничего не найдено");
                    req.getRequestDispatcher("search.jsp").forward(req, resp);

                }else {
                    req.setAttribute("flights", flights);
                    req.setAttribute("flight", true);
                    req.setAttribute("maxPage", maxPage);
                    req.setAttribute("Departure", airportDeparture);
                    req.setAttribute("Arrival", airportArrival);
                    req.setAttribute("timeDeparture", dateDeparture);
                    req.setAttribute("currentPage", page);
                    req.getRequestDispatcher("search.jsp").forward(req, resp);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}

