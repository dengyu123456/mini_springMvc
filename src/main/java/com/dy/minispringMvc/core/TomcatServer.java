package com.dy.minispringMvc.core;

import com.dy.minispringMvc.Servlet.CustomDispatcherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    private Tomcat tomcat;
    private String[] args;

    public TomcatServer(String[] args) {
        this.args = args;
    }

    //把自定义servlet注册到tomcat容器当中
    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(7788);
        tomcat.start();

        Context context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        CustomDispatcherServlet servlet = new CustomDispatcherServlet();

        tomcat.addServlet(context, "servlet", servlet).setAsyncSupported(true);
        context.addServletMappingDecoded("/", "servlet");
        tomcat.getHost().addChild(context);
        Thread waitThread = new Thread() {
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };
        waitThread.start();
    }


}
