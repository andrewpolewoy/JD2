package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.UserInMessenger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Cервлет, отвечающий за аутентификацию пользователя, при удачном завершении которой
 * происходит переадресация на главную страницу чата  {@link MessengerServlet}.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/signIn")
public class LoginServlet extends HttpServlet {
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
        req.getRequestDispatcher("signIn.jsp").forward(req, resp);
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

        String Login = req.getParameter("login");
        String Password = req.getParameter("password");

        if (!UserInMessenger.usersInMessenger.containsKey(Login)) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Пользователь с таким логином не найден");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        }
        if (UserInMessenger.usersInMessenger.containsKey(Login)) {
            if (!UserInMessenger.usersInMessenger.get(Login).getPassword().equals(Password)) {
                req.setAttribute("error", true);
                req.setAttribute("message", "Неверный пароль");
                req.getRequestDispatcher("signIn.jsp").forward(req, resp);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("login", Login);

        resp.sendRedirect(req.getContextPath() + "/message");
    }
}