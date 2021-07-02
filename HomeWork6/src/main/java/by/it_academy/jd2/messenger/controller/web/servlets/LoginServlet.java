package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Cервлет, отвечающий за аутентификацию пользователя, при удачном завершении которой
 * происходит переадресация на главную страницу чата
 */
@Controller
@RequestMapping(value = "/signIn")
public class LoginServlet {

    /** Экземпляр класса IAuthService */
    private final IAuthService authService;

    /**
     * Конструктор с инициализацией экземпляра класса {@link IAuthService}
     * @param authService класс сервиса авторизации пользователя
     */
    public LoginServlet(IAuthService authService){
        this.authService = authService;
    }

    /**
     * Метод, обрабатывающий GET запросы
     * @return URL страницы авторизации
     */
    @GetMapping
    public String doGet() {
        return "/views/signIn.jsp";
    }

    /**
     * Метод, обрабатывающий POST запросы
     * @param req - запрос от пользователя
     * @param Login - логин
     * @param Password - пароль
     * @param model - специальный класс для работы с атрибутами
     * @return URL страницы для отправки сообщений (при успешной авторизации),
     * либо страницы авторизации (при неуспешной авторизации)
     */
    @PostMapping
    public String doPost(@RequestParam(name = "login") String Login,
                         @RequestParam(name = "password") String Password,
                         HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        try {
            User user = authService.authentication(Login,Password);
            if (user == null){
                throw new IllegalArgumentException("Введен не верный логин или пароль");
            } else {
                session.setAttribute("user", user);
                return "redirect:/message";
            }
        }catch (IllegalArgumentException e){
            model.addAttribute("error", true);
            model.addAttribute("message", e.getMessage());
            return "/views/signIn.jsp";
        }
    }
}