package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.UserInMessenger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cервлет, отвечающий за отправку сообщений зарегестрированным пользователям.
 */
@WebServlet(name = "MessengerServlet", urlPatterns = "/message")
public class MessengerServlet extends HttpServlet {
    /**
     * Метод, обрабатывающий GET запросы
     * @param req - запрос от пользователя
     * @param resp - ответ пользователю
     * @throws IOException - ошибка ввода-вывода
     * @see IOException
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("message.jsp").forward(req, resp);
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

        String login = req.getParameter("login");
        String message = req.getParameter("message");
        HttpSession session = req.getSession();
        String myLogin = (String) session.getAttribute("login");

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        String user = (String) session.getAttribute("login");
        if (!UserInMessenger.usersInMessenger.containsKey(login)) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Пользователь с таким логином не существует");
        }else {
            UserInMessenger.usersInMessenger.get(login).getMessage().add("(" + formatter.format(new Date()) + ")" + " сообщение " +" от " + user + ": " + message);
        }
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }
}

