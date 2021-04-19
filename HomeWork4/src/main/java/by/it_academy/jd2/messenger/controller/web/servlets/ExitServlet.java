package by.it_academy.jd2.messenger.controller.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Cервлет, отвечающий за корректное завершение сессии и переадресацию на страницу
 * входа в учётную запись{@link LoginServlet}.
 *
 */
@WebServlet(name = "ExitServlet", urlPatterns = "/exit")
public class ExitServlet extends HttpServlet {
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

        HttpSession session = req.getSession();
        session.removeAttribute("login");

        resp.sendRedirect(req.getContextPath() + "/signIn");
    }
}


