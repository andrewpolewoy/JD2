package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.view.UserInMessenger;
import by.it_academy.jd2.messenger.view.UserInMessengerDAO;
import by.it_academy.jd2.messenger.view.api.IUserInMessenger;
import by.it_academy.jd2.messenger.model.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Cервлет, отвечающий за отправку сообщений зарегестрированным пользователям.
 */
@WebServlet(name = "MessengerServlet", urlPatterns = "/message")
public class MessengerServlet extends HttpServlet {

    private final IUserInMessenger userInMessenger;

    public MessengerServlet() {
        this.userInMessenger = UserInMessengerDAO.getInstance();
    }

    /**
     * Метод, обрабатывающий GET запросы
     *
     * @param req  - запрос от пользователя
     * @param resp - ответ пользователю
     * @throws IOException      - ошибка ввода-вывода
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see IOException
     * @see ServletException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }

    /**
     * Метод, обрабатывающий POST запросы
     *
     * @param req  - запрос от пользователя
     * @param resp - ответ пользователю
     * @throws IOException      - ошибка ввода-вывода
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see IOException
     * @see ServletException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("recipient");
        String mess = req.getParameter("message");

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

        String login = (String) req.getSession().getAttribute("login");

        if (!userInMessenger.getUsersInMessenger().containsKey(recipient)) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Пользователь с таким логином не существует");
        } else {
            Message message = new Message();
            message.setFrom(login);
            message.setSendDate(new Date());
            message.setText(mess);
            req.setAttribute("recipient", recipient);
            userInMessenger.setMessage(recipient, message);
        }
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }

}

