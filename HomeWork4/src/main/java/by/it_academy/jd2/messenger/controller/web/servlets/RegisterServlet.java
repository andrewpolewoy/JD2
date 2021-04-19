package by.it_academy.jd2.messenger.controller.web.servlets;


import by.it_academy.jd2.messenger.view.UserInMessenger;
import by.it_academy.jd2.messenger.view.UserInMessengerDAO;
import by.it_academy.jd2.messenger.view.api.IUserInMessenger;
import by.it_academy.jd2.messenger.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Cервлет, отвечающий за регистрацию пользователя пользователям.
 * При успешной регистрации происходит переадресацию на страницу входа в учётную запись{@link LoginServlet}.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/signUp")

public class RegisterServlet extends HttpServlet {

    private final IUserInMessenger userInMessenger;

    public RegisterServlet(){
        this.userInMessenger = UserInMessengerDAO.getInstance();
    }

    /**
     * Метод, обрабатывающий GET запросы
     * @param request - запрос от пользователя
     * @param response - ответ пользователю
     * @throws IOException - ошибка ввода-вывода
     * @see IOException
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
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
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String birth = (String) req.getParameter("birth_day");
        User user = new User(name, login, password, birth);

//        HttpSession session = req.getSession();
//
        try{
            userInMessenger.saveUser(login, user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/signIn");
        } catch (Exception e){
            req.setAttribute("error", true);
            req.setAttribute("message", "Пользователь с таким логином уже существует");
            req.getRequestDispatcher("signUp.jsp").forward(req, resp);
        }


    }
}

