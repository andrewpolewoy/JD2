package by.it_academy.jd2.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Cервлет, отвечающий за переход на страницу с сообщениями пользователю.
 */
@WebServlet(name = "ChatServlet", urlPatterns = "/chats")
public class ChatServlet extends HttpServlet {
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
        req.getRequestDispatcher("chats.jsp").forward(req,resp);
    }
}


