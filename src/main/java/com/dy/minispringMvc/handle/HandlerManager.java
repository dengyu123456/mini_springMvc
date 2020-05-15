package com.dy.minispringMvc.handle;

import com.dy.minispringMvc.mvc.CustomController;
import com.dy.minispringMvc.mvc.CustomRequestMapping;
import com.dy.minispringMvc.mvc.CustomResqusetParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建所有Url和Controller的映射
 */
public class HandlerManager {
    private static Map<String, HandlerMapping> handlerMappingMap = new ConcurrentHashMap<String, HandlerMapping>();

    public static HandlerMapping getHandler(String url) {
        return handlerMappingMap.get(url);
    }

    public static void resolveMappingHandler(List<Class<?>> classList) {
        for (Class<?> cls : classList) {
            if (cls.isAnnotationPresent(CustomController.class)) {
                parseHandlerFromController(cls);
            }
        }
    }

//    private static void parseHandlerFromController(Class<?> cla) {
//        Method[] methods = cla.getMethods();
//        for (Method method : methods) {
//            if (!method.isAnnotationPresent(CustomRequestMapping.class)) {
//                continue;
//            }
//            String url = method.getDeclaredAnnotation(CustomRequestMapping.class).value();
//            List<String> parmasKey = new ArrayList<>();
//            for (Parameter parameter : method.getParameters()) {
//                if (!parameter.isAnnotationPresent(CustomResqusetParam.class)) {
//                    continue;
//                }
//                parmasKey.add(parameter.getDeclaredAnnotation(CustomResqusetParam.class).value());
//            }
//            parmasKey.toArray();
//            String[] args = parmasKey.toArray(new String[parmasKey.size()]);
//            HandlerMapping handlerMapping = new HandlerMapping(url, method, cla, args);
//            handlerMappingMap.put(url, handlerMapping);
//        }
//
//    }
private static void parseHandlerFromController(Class<?> cla) {
    Method[] methods = cla.getMethods();
    for (Method method : methods) {
        if (!method.isAnnotationPresent(CustomRequestMapping.class)) {
            continue;
        }
        String url = method.getDeclaredAnnotation(CustomRequestMapping.class).value();
        List<String> parmasKey = new ArrayList<>();
        for (Parameter parameter : method.getParameters()) {
            if (!parameter.isAnnotationPresent(CustomResqusetParam.class)) {
                continue;
            }
            parmasKey.add(parameter.getDeclaredAnnotation(CustomResqusetParam.class).value());
        }
        parmasKey.toArray();
        String[] args = parmasKey.toArray(new String[parmasKey.size()]);
        HandlerMapping handlerMapping = new HandlerMapping(url, method, cla, args);
        handlerMappingMap.put(url, handlerMapping);
    }

}

}
