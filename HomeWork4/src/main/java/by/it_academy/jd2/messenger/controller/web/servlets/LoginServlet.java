package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.view.UserInMessenger;
import by.it_academy.jd2.messenger.view.UserInMessengerDAO;
import by.it_academy.jd2.messenger.view.api.IUserInMessenger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Cервлет, отвечающий за аутентификацию пользователя, при удачном завершении которой
 * происходит переадресация на главную страницу чата  {@link MessengerServlet}.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/signIn")
public class LoginServlet extends HttpServlet {

    private final IUserInMessenger userInMessenger;

    public LoginServlet(){
        this.userInMessenger = UserInMessengerDAO.getInstance();
    }

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

        if (!userInMessenger.getUsersInMessenger().containsKey(Login)) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Пользователь с таким логином не найден");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        }
        if (userInMessenger.getUsersInMessenger().containsKey(Login)) {
            if (!userInMessenger.getUsersInMessenger().get(Login).getPassword().equals(Password)) {
                req.setAttribute("error", true);
                req.setAttribute("message", "Неверный пароль");
                req.getRequestDispatcher("signIn.jsp").forward(req, resp);
            }
        }
        req.getSession().setAttribute("login", Login);
        resp.sendRedirect(req.getContextPath() + "/message");
    }
}