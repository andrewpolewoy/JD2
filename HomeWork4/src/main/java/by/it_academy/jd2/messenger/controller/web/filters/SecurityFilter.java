package by.it_academy.jd2.messenger.controller.web.filters;

import by.it_academy.jd2.messenger.controller.web.servlets.LoginServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Фильтр, отвечающий за проверку: была ли удачна завершена аутентификация пользователя.
 * В противном случае происходит переадресация на страницу аутентификации {@link LoginServlet}.
 */
@WebFilter(urlPatterns = {"/chats","/message"})
public class SecurityFilter implements Filter {
    /**
     * Метод, обрабатывающий GET запросы
     * @param request - запрос от сервлета
     * @param response - ответ сервлета
     * @param chain - экземпляр интерфейса фильтра
     * @throws IOException - ошибка ввода-вывода
     * @see IOException
     * @throws ServletException - ошибка, связанная с обращением к сервлету
     * @see ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session !=null) && (session.getAttribute("login") !=null)){
            chain.doFilter(request,response);
        }else {
            res.sendRedirect(contextPath + "/signIn");
        }
    }
}
