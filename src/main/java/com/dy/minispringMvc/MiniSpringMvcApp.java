package com.dy.minispringMvc;

import com.dy.minispringMvc.beans.CustomBeanfactory;
import com.dy.minispringMvc.core.CustomClassLoader;
import com.dy.minispringMvc.core.TomcatServer;
import com.dy.minispringMvc.handle.HandlerManager;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

public class MiniSpringMvcApp {
    public static void main(String[] args) throws LifecycleException, IOException {
        System.out.println("打包");
        System.out.println(MiniSpringMvcApp.class.getPackage().getName());
        try {
            List<Class<?>> classList = CustomClassLoader.loadeClass(MiniSpringMvcApp.class.getPackage().getName());
            CustomBeanfactory.ininBean(classList);
            HandlerManager.resolveMappingHandler(classList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TomcatServer tomCatServer=new TomcatServer(args);
        tomCatServer.startServer();
    }
}
