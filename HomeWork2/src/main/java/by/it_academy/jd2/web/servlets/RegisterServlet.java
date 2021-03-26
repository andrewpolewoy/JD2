package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.dto.UserInMessenger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "RegisterServlet", urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("signUp.jsp").forward(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String birth = req.getParameter("birth_day");

//        HttpSession session = req.getSession();
//        session.setAttribute("user", user);
        UserInMessenger.saveUser(login, new UserInMessenger(name, login, password, birth));


        resp.sendRedirect(req.getContextPath() + "/signIn");

    }
}

