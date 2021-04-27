package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.dto.Flights;
import by.it_academy.jd2.dao.dbsql.AirportDAO;
import by.it_academy.jd2.dao.dbsql.FlightsDAO;
import by.it_academy.jd2.dao.api.IAirport;
import by.it_academy.jd2.dao.api.IFlight;
import by.it_academy.jd2.dao.hibernate.AirportHibernateDAO;
import by.it_academy.jd2.dao.hibernate.FlightsHibernateDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.List;


/**
 * Cервлет, отвечающий за отображение найденных рейсов.
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    /** Объект класса интерфейса IFlight */
    private final IFlight flightsData;

    /** Объект класса интерфейса IAirport */
    private final IAirport airportData;

    /**
     * Метод инициализации, который создаёт объекты класса {@link AirportDAO}
     * и класса {@link FlightsDAO}
     */
    public SearchServlet() {
        this.airportData = AirportHibernateDAO.getInstance();
        this.flightsData = FlightsHibernateDAO.getInstance();
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
        List<Airport> airports = airportData.getList();
        request.setAttribute("airports", airports);
        request.getRequestDispatcher("search.jsp").forward(request, response);
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
        List<Airport> airports;
        airports = airportData.getList();
        req.setAttribute("airports", airports);
        String dateDeparture = req.getParameter("dateDeparture");
        String airportDeparture = req.getParameter("airportDeparture");
        String airportArrival = req.getParameter("airportArrival");
        if (dateDeparture == null ||  airportDeparture == null ||  airportArrival == null){
            resp.sendRedirect(req.getContextPath() + "/search");
        }else {
            try {
                int numberOfRows = flightsData.getRowCount(dateDeparture, airportDeparture, airportArrival);
                int rowsOnPage = 25;
                int maxPage = (int) Math.ceil((double)numberOfRows / rowsOnPage);
                List<Flights> flights = flightsData.getList(dateDeparture, airportDeparture, airportArrival,String.valueOf(rowsOnPage),String.valueOf(page));
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
            }catch (DateTimeException e){
                req.setAttribute("error", true);
                req.setAttribute("message", "Некорректная дата");
                req.getRequestDispatcher("search.jsp").forward(req, resp);
            }

        }
    }
}

