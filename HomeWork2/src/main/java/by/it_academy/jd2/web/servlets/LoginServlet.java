package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.dto.UserInMessenger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String Login = req.getParameter("login");
        String Password = req.getParameter("password");

        if (!UserInMessenger.usersInMessenger.containsKey(Login)) {
            throw new IllegalArgumentException("User with this Login is no registered!");
        }
        if (UserInMessenger.usersInMessenger.containsKey(Login)) {
            if (!UserInMessenger.usersInMessenger.get(Login).getPassword().equals(Password)) {
                throw new IllegalArgumentException("Bad Password");
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("login", Login);

        resp.sendRedirect(req.getContextPath() + "/message");
    }
}