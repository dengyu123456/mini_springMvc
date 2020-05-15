package com.dy.minispringMvc.core;


import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 自定义类加载 目的就是拿到当前jar包下所有java.lang.Class
 * <p>
 * 类的加载3个阶段
 * <p>
 * 通过一个类的全限定名来获取定义此类的二进制字节流
 * 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
 * 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口
 * <p>
 */
public class CustomClassLoader {
    public static List<Class<?>> loadeClass(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        String path = packageName.replace(".", "/");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = contextClassLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();//file:/C:/Users/root/Desktop/study/mini_springMvc/target/classes/com/dy/minispringMvc
            //只对jar包进行处理
            if (url.getProtocol().contains("jar")) {
                JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                String jarPath = jarURLConnection.getJarFile().getName();//拿到jar包绝对路径  C:\Users\root\Desktop\study\mini_springMvc\target\mini_springMvc-1.0-SNAPSHOT-shaded.jar
                classList.addAll(getClassFromJar(jarPath, path));
            } else {
                //其他暂时不做处理
            }
        }
        return classList;
    }

    private static List<Class<?>> getClassFromJar(String jarPath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        JarFile jarFile = new JarFile(jarPath);
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();//com/dy/minispringMvc/core/CustomClassLoader.class  这个jar包下的资源路径
            //如果是class文件,并且是我们建的包，非依赖包
            if (name.startsWith(path) && name.endsWith(".class")) {
                //去掉.class后缀
                String className = name.replace("/", ".").substring(0, name.length() - 6);//com.dy.minispringMvc.core.CustomClassLoader
                classList.add(Class.forName(className));
            }
        }
        return classList;
    }
}
