package by.it_academy.jd2.web.servlets.Print;

import by.it_academy.jd2.core.dto.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

@WebServlet(name = "PrintCookieServletV3", urlPatterns = "/printCookieV3")
public class PrintCookieServletV3 extends HttpServlet {

    private static final String FIRST_PARAM = "firstname";
    private static final String LAST_PARAM = "lastname";
    private static final String AGE_PARAM = "age";

    private static final String nameStorage1 = "cookies";
    private static final String nameStorage2 = "sessions";


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
                    }
                    throw new IllegalArgumentException("not all parameters");
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


////     choice.equals(nameStorage2)
//            if (choice.equalsIgnoreCase(nameStorage2)) {
//                    HttpSession session = req.getSession();
//                    user = (Person) session.getAttribute("person");
//                    if (user == null) {
//                    if (first != null && last != null && age != null){
//                    user = new Person(last, first, age);
//                    session.setAttribute("person", user);
//                    }else {
//                    throw new IllegalArgumentException("Не передан один из обязательных параметров");
//                    }
//                    }
//                    }
//
//                    if (choice.equalsIgnoreCase(nameStorage1)) {
//                    req.getSession().invalidate();
//                    if (first != null && last != null && age != null) {
//                    Cookie firstName = new Cookie(FIRST_PARAM, first);
//                    Cookie lastName = new Cookie(LAST_PARAM, last);
//                    Cookie aGe = new Cookie(AGE_PARAM, req.getParameter(AGE_PARAM));
//                    firstName.setMaxAge(60);
//                    lastName.setMaxAge(60);
//                    aGe.setMaxAge(60);
//                    resp.addCookie(firstName);
//                    resp.addCookie(lastName);
//                    resp.addCookie(aGe);
//
//                    } else if (req.getCookies() != null ) {
//                    user.setFirstname(Arrays.stream(req.getCookies())
//                    .filter(c -> FIRST_PARAM.equals(c.getName()))
//                    .map(Cookie::getValue)
//                    .findFirst()
//                    .orElse(null));
//                    user.setLastname(Arrays.stream(req.getCookies())
//                    .filter(c -> LAST_PARAM.equals(c.getName()))
//                    .map(Cookie::getValue)
//                    .findFirst()
//                    .orElse(null));
//                    user.setAge(Arrays.stream(req.getCookies())
//                    .filter(c -> AGE_PARAM.equals(c.getName()))
//                    .map(Cookie::getValue)
//                    .findFirst()
//                    .orElse(null));
//                    } else {
//                    throw new IllegalArgumentException("Не передан один из обязательных параметров");
//                    }
//                    }