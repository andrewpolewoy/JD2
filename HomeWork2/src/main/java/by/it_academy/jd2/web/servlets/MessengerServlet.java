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

@WebServlet(name = "MessengerServlet", urlPatterns = "/mess")
public class MessengerServlet extends HttpServlet {

    private HttpSession session;
    public static String myLogin;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String toLogin = req.getParameter("login");
        String message = req.getParameter("message");
        session = req.getSession();
        myLogin = (String) session.getAttribute("login");

        addMessage(session, toLogin, message);

        resp.sendRedirect(req.getContextPath() + "/message");
    }

    public void addMessage(HttpSession session, String login, String message) {

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

        String user = (String) session.getAttribute("login");
        if (!UserInMessenger.usersInMessenger.containsKey(login)) throw new IllegalArgumentException("Incorrect users login");
        else UserInMessenger.usersInMessenger.get(login).getMessage().add("(" + formatter.format(new Date()) + ")" + " from " + user + ": " + message);
    }

}

