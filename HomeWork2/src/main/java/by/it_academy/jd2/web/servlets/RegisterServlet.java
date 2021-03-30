package by.it_academy.jd2.web.servlets;


import by.it_academy.jd2.core.dto.UserInMessenger;
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
        String birth = req.getParameter("birth_day");


//        HttpSession session = req.getSession();
//        session.setAttribute("user", user);
        try{
            UserInMessenger.saveUser(login, new UserInMessenger(name, login, password, birth));
            resp.sendRedirect(req.getContextPath() + "/signIn");
        } catch (IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message", "Пользователь с таким логином уже существует");
            req.getRequestDispatcher("signUp.jsp").forward(req, resp);
        }


    }
}

