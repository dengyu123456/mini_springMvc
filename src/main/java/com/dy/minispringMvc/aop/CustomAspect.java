package com.dy.minispringMvc.aop;

import java.lang.annotation.*;

/**
 * 声明一个类是切面类
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAspect {
}
