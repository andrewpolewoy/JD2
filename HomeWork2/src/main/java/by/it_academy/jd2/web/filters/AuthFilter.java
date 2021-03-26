package by.it_academy.jd2.web.filters;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.servlet.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/orders"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session !=null) && (session.getAttribute("user") !=null)){
            chain.doFilter(request,response);
        }else {
            res.sendRedirect(contextPath + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
