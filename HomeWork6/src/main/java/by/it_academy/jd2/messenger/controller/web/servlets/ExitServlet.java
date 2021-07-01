package by.it_academy.jd2.messenger.controller.web.servlets;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Cервлет, отвечающий за корректное завершение сессии и переадресацию на страницу
 * входа в учётную запись{@link LoginServlet}.
 *
 */

@Controller
@RequestMapping(value = "/exit")
public class ExitServlet {
    /**
     * Метод, обрабатывающий GET запросы
     * @param req - запрос от пользователя
     */
    @GetMapping
    protected String doGet(HttpServletRequest req, Model model) {

        HttpSession session = req.getSession();
        session.removeAttribute("login");
        return "/views/signIn.jsp";
    }
}


