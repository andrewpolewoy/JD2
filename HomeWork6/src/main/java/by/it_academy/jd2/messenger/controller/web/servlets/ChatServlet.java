package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/** Cервлет, отвечающий за отображение страницы чата */
@Controller
@RequestMapping(value = "/chats")
public class ChatServlet {

    /** Экземпляр класса IMessageService */
    private final IMessageService messageService;

    /**
     * Конструктор с инициализацией экземпляра класса {@link IMessageService}
     * @param messageService класс сервиса сообщений
     */
    public ChatServlet(IMessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Метод, обрабатывающий GET запросы
     * @param req - запрос от пользователя
     * @param model - специальный класс для работы с атрибутами
     * @return URL страницы чата
     */
    @GetMapping
    public String doGet(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Message> messages = this.messageService.getMessage(user.getLogin());
        model.addAttribute("chat", messages);
        return "/views/chats.jsp";
    }
}


