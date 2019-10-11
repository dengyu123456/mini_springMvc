package com.dy.minispringMvc.beans;

import com.dy.minispringMvc.mvc.CustomController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomBeanfactory {
    private static Map<Class<?>, Object> beanMap = new ConcurrentHashMap<Class<?>, Object>();

    public static Object getBean(Class<?> cla) {
        return beanMap.get(cla);
    }

    public static void ininBean(List<Class<?>> classes) throws InstantiationException, IllegalAccessException {
        List<Class<?>> classList = new ArrayList<Class<?>>(classes);
        while (!classList.isEmpty() && classList.size() > 0) {
            //记录一下需要扫描的总数
            int size = classList.size();

            for (int i = 0; i < classList.size(); i++) {
                if (crateBean(classList.get(i))) {
                    classList.remove(i);
                }
            }
            //如果出现相互依赖的情况，则抛出一个异常
            if (size == classList.size()) {
                throw new RuntimeException("创建失败，暂未解决相互依赖问题");
            }
        }
    }

    private static boolean crateBean(Class<?> cla) throws IllegalAccessException, InstantiationException {
        //如果是不需要处理的类，则直接删除
        if (!cla.isAnnotationPresent(CustomBean.class) && !cla.isAnnotationPresent(CustomController.class)) {
            return true;
        }
        Object obj = cla.newInstance();
        Field[] declaredFields = cla.getDeclaredFields();
        //设置需要创建的对象的属性
        for (Field field : declaredFields) {
            //如果是CustomAutoWired注解修饰的属性，则从我们的BeanFactory取，取不到则返回false，因为while循环，会一直
            //找当前的依赖，当依赖创建好以后，直接从beanMap取即可。
            if (field.isAnnotationPresent(CustomAutoWired.class)) {
                Class<?> fieldType = field.getType();
                Object fieldObj = beanMap.get(fieldType);
                if (fieldObj == null) {
                    return false;
                }
                //将取到的依赖set到需要创建的bean中
                //大坑 这里必须设置为true，不然不能进行set
                field.setAccessible(true);
                field.set(obj, fieldObj);
            }
        }
        beanMap.put(cla, obj);
        return true;
    }
}
