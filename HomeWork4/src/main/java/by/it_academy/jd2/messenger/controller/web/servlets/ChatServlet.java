package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.view.UserInMessenger;
import by.it_academy.jd2.messenger.view.UserInMessengerDAO;
import by.it_academy.jd2.messenger.view.api.IUserInMessenger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.util.ArrayList;


/**
 * Cервлет, отвечающий за отображение страницы чата.
 *
 */
@WebServlet(name = "ChatServlet", urlPatterns = "/chats")
public class ChatServlet extends HttpServlet {

    private final IUserInMessenger userInMessenger;

    public ChatServlet() {
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

        HttpSession session = req.getSession();
        ArrayList<Message> messages = userInMessenger.getMessage((String)session.getAttribute("login"));
//        ArrayList<Message> messages = UserInMessenger.getInstance().getMessage((String)session.getAttribute("login"));
        req.setAttribute("chat", messages);
        req.getRequestDispatcher("chats.jsp").forward(req,resp);

    }
}


