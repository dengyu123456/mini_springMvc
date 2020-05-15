package com.dy.minispringMvc.aop;

import java.lang.annotation.*;

/**
 * 环绕通知，其中value是用户自定义注解的全限定名称
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomAround {
    String value();
}
