package ru.innopolis.stc9.GradeSystem.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InnerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        if ((httpSession.getAttribute("login") != null)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpServletRespoonse = (HttpServletResponse) response;
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            httpServletRespoonse.sendRedirect(httpServletRequest.getContextPath() + "/login?errorMsg=noAuth");
        }
    }

    @Override
    public void destroy() {

    }
}
