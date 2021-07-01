package by.it_academy.jd2.messenger.controller.web.servlets;

import by.it_academy.jd2.messenger.model.User;
import by.it_academy.jd2.messenger.view.api.IMessageService;
import by.it_academy.jd2.messenger.model.Message;
import by.it_academy.jd2.messenger.view.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * Cервлет, отвечающий за отправку сообщений зарегестрированным пользователям.
 */
@Controller
@RequestMapping(value = "/message")
public class MessengerServlet {

    private final IMessageService messageService;
    private final IUserService userService;

    public MessengerServlet(IMessageService messageService, IUserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    /**
     * Метод, обрабатывающий GET запросы
     * @return URL
     */
    @GetMapping
    protected String doGet(){
        return "/views/message.jsp";
    }

    /**
     * Метод, обрабатывающий POST запросы

     *
     */
    @PostMapping
    protected String doPost(@RequestParam (name = "recipient") String recipient,
                            @RequestParam (name = "message") String mess,
                            HttpServletRequest req,
                            Model model) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        if (userService.getUser(recipient)==null) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Пользователь с таким логином не существует");
        } else {
            Message message = new Message(user.getLogin(), recipient, LocalDateTime.now(), mess);
            try {
                messageService.addMessage(message);
//                model.addAttribute("recipient", recipient);
            }catch (IllegalArgumentException e){
                model.addAttribute("error", true);
                model.addAttribute("message", e.getMessage());
            }
        }
        return "/views/message.jsp";
    }
}

//        if (!userInMessenger.getUsersInMessenger().containsKey(recipient)) {
//                req.setAttribute("error", true);
//                req.setAttribute("message", "Пользователь с таким логином не существует");
