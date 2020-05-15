package com.dy.minispringMvc.handle;

import com.dy.minispringMvc.beans.CustomBeanfactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 */
public class HandlerMapping {
    private String url;
    private Method method;
    private Class<?> controller;
    //请求参数的key
    private String[] paramKey;

    private String[] paramValue;

    public HandlerMapping(String url, Method method, Class<?> controller, String[] args) {
        this.url = url;
        this.method = method;
        this.controller = controller;
        this.paramKey = args;
    }

    public boolean handler(HttpServletRequest req, HttpServletResponse res) throws InvocationTargetException, IllegalAccessException, IOException {
        paramValue=new String[paramKey.length];
        for (int i = 0; i < paramKey.length; i++) {
            paramValue[i] = req.getParameter(paramKey[i]);
        }
        Object bean = CustomBeanfactory.getBean(controller);
        Object response = method.invoke(bean, paramValue);
        res.getWriter().println(response.toString());
        return true;
    }
}
