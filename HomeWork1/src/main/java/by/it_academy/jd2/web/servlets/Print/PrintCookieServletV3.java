package by.it_academy.jd2.web.servlets.Print;

import by.it_academy.jd2.core.dto.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Cервлет, в котором через заголовок(HEADER) можно указать откуда брать данные(сессия либо куки).
 * При наличии и соответствии всех параметров выводит указанные параметры на экран.
 */
@WebServlet(name = "PrintCookieServletV3", urlPatterns = "/printCookieV3")
public class PrintCookieServletV3 extends HttpServlet {

    /** Поле имя */
    private static final String FIRST_PARAM = "firstname";
    /** Поле фамилия */
    private static final String LAST_PARAM = "lastname";
    /** Поле возраст */
    private static final String AGE_PARAM = "age";
    /** Поле куки */
    private static final String nameStorage1 = "cookies";
    /** Поле сессия */
    private static final String nameStorage2 = "sessions";

    /**
     * Метод, обрабатывающий GET запросы
     * @param req - запрос от пользователя
     * @param resp - ответ пользователю
     * @throws IOException - ошибка ввода-вывода
     * @see IOException
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            String first = req.getParameter(FIRST_PARAM);
            String last = req.getParameter(LAST_PARAM);
            String age = req.getParameter(AGE_PARAM);
            Person user = new Person(last, first, age);
            String choice = req.getHeader("choice");


            //     choice.equals(nameStorage2)
            if (choice.equalsIgnoreCase(nameStorage2)) {
                HttpSession session = req.getSession();
                if (first != null && last != null && age != null && !session.isNew()) {
                    session.setAttribute("person", user);
                }
                if (first == null || last == null || age == null) {
                    if (!session.isNew()) {
                        user = (Person) session.getAttribute("person");
                    }else{
                        throw new IllegalArgumentException("not all parameters");
                    }

                }
                session.setAttribute("person", user);
//                user = (Person) session.getAttribute("person");
            }

            if (choice.equalsIgnoreCase(nameStorage1)) {
                Cookie[] cookies = req.getCookies();
                if (first != null && last != null && age != null ) {
                    Cookie firstName = new Cookie(FIRST_PARAM, first);
                    Cookie lastName = new Cookie(LAST_PARAM, last);
                    Cookie aGe = new Cookie(AGE_PARAM, req.getParameter(AGE_PARAM));
                    firstName.setMaxAge(60);
                    lastName.setMaxAge(60);
                    aGe.setMaxAge(60);
                    resp.addCookie(firstName);
                    resp.addCookie(lastName);
                    resp.addCookie(aGe);
                }
                if (first == null || last == null || age == null) {
                    if(cookies !=null){
                        user.setFirstname(Arrays.stream(req.getCookies())
                                .filter(c -> FIRST_PARAM.equals(c.getName()))
                                .map(Cookie::getValue)
                                .findFirst()
                                .orElse(null));
                        user.setLastname(Arrays.stream(req.getCookies())
                                .filter(c -> LAST_PARAM.equals(c.getName()))
                                .map(Cookie::getValue)
                                .findFirst()
                                .orElse(null));
                        user.setAge(Arrays.stream(req.getCookies())
                                .filter(c -> AGE_PARAM.equals(c.getName()))
                                .map(Cookie::getValue)
                                .findFirst()
                                .orElse(null));
                    }
                    throw new IllegalArgumentException("not all parameters");
                }

            }

            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<p>" + user.getLastname() + " " + user.getFirstname() + " " + user.getAge() + "</p>");

        } catch (Exception e) {
            PrintWriter writer = resp.getWriter();
            writer.write("<p>" + "not all parameters" + "</p>");
        }
    }
}


