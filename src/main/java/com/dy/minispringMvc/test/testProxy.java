package com.dy.minispringMvc.test;

import com.dy.minispringMvc.aop.CustomProxy_cglib;
import com.dy.minispringMvc.aop.CustomProxy_jdk;

/**
 * 实现Aop的思路，目的：实现BeanFactory里面如果有被 用户自定义注解假设@User
 * 注解的方法，那么BeanFactory里应该是被代理的对象，不应该是原对象
 * <p>
 * 切面类：CustomProxy注解的类，CustomAround注解的方法就是需要织入带有@User注解的方法
 *
 * 织入和ioc容器的联系
 * 思路：建立ProxyFactory类，扫描含有CustomProxy注解的类 （记录），再扫描出CustomAround的方法（记录），
 * 取到CustomAround注解的value属性 假设@User，然后再扫描所有的类找出含有@User的方法 取到方法名（记录）
 * 和当前扫描的类（记录）
 * 最后创建cglib代理对象，放入BeanFactory里面
 */

public class testProxy {
    public static void main(String[] args) throws Throwable {
//        CustomProxy_jdk customProxy_jdk = new CustomProxy_jdk();
//        Ainte a_jdk = (Ainte) customProxy_jdk.newProxyInstance(new A());
//        System.out.println(a_jdk.getA());

//        CustomProxy_cglib customProxy_cglib = new CustomProxy_cglib();
//        A a_cglib = (A) customProxy_cglib.getInstance(new A(),"getA");
//        System.out.println(a_cglib.getA());
//        System.out.println(a_cglib.getSss());
//
//        Class bClass=Class.forName("b");
//        Class<?> aClass = Class.forName("a");
//        aClass.isAnnotationPresent(bClass);
    }
}
