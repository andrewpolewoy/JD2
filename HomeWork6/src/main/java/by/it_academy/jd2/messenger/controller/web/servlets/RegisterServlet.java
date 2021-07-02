package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Cервлет, отвечающий за регистрацию пользователя.
 * При успешной регистрации происходит переадресацию на страницу входа в учётную запись
 */
@Controller
@RequestMapping(value = "/signUp")
public class RegisterServlet {

    /** Экземпляр класса IUserService */
    private final IUserService userService;

    /**
     * Конструктор с инициализацией экземпляра класса {@link IUserService}
     * @param userService класс сервиса пользователя
     */
    public RegisterServlet(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Метод, обрабатывающий GET запросы
     * @return URL страницы регистрации
     */
    @GetMapping
    public String doGet()  {
        return "/views/signUp.jsp";
    }

    /**
     * Метод, обрабатывающий POST запросы
     * @param login - логин
     * @param password - пароль
     * @param name - имя
     * @param birth - дата рождения
     * @param model - специальный класс для работы с атрибутами
     * @return URL страницы для отправки сообщений
     */
    @PostMapping
    public String doPost(@RequestParam(name = "login") String login,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "birth_day") String birth,
                         Model model){
        User user = new User(name, login, password, birth);
        try {
            this.userService.signUp(user);
            model.addAttribute("user", user);
            return "redirect:/signIn";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "/views/signUp.jsp";
        }
    }
}

