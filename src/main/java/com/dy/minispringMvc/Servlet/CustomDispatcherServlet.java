package com.dy.minispringMvc.Servlet;

import com.dy.minispringMvc.handle.HandlerManager;
import com.dy.minispringMvc.handle.HandlerMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CustomDispatcherServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HandlerMapping handler = HandlerManager.getHandler(httpServletRequest.getRequestURI());
       if (handler!=null){
           HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
           try {
               handler.handler(httpServletRequest,httpServletResponse);
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
