package com.dy.minispringMvc.aop;

import com.dy.minispringMvc.beans.CustomBeanfactory;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.naming.factory.BeanFactory;

import java.lang.reflect.Method;

public class CustomProxy_cglib implements MethodInterceptor {

    //需要代理的类
    private Object target;
    //自定义注解的方法的名称，也就是需要代理加强的方法
    private String pinCutName;


    //注解CustomAspect的类，代理类
    private Object objAspect;
    //需要织入的方法，也就是加强方法
    private Method methodAdvice;


    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target, String pinCutName,Method methodAdvice,Object objAspect) {
        this.target = target;
        this.pinCutName = pinCutName;
        this.objAspect=objAspect;
        this.methodAdvice=methodAdvice;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    // 回调方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
//        //执行加强的方法
//        methodAdvice.invoke(cla, args);
        if (method.getName().equals(pinCutName)) {
          methodAdvice.invoke(objAspect,null);
        }
        //执行原方法
        method.invoke(target, args);
        return proxy.invokeSuper(obj, args);

    }
}
