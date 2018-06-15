package com.ypw.aon;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 2429219028@qq.com
 * @date 2018/6/14 14:50
 * 描述：注解解析类
 */
public class Aon {

    /**
     * 解析
     * @param target 解析目标
     */
    public static void bind(final Activity target) {
        bind(target, target.getWindow().getDecorView());
    }

    /**
     * 解析
     * @param target 解析目标
     */
    public static void bind(final Object target, View view) {
        try {
            Class<?> clazz = target.getClass();
            // 获取所有的字段
            Field[] fields = clazz.getDeclaredFields();

            FindView findView;
            int id;

            // 对所有字段进行遍历
            for (Field field : fields){
                // 获取字段所有的注解
                Annotation[] annotations = field.getAnnotations();
                // 对注解进行遍历
                for(Annotation annotation:annotations) {
                    // FindView注解
                    if (annotation instanceof FindView) {
                        // 获取FindViewById对象
                        findView = field.getAnnotation(FindView.class);
                        // 反射访问私有成员，必须进行此操作
                        field.setAccessible(true);
                        // 注解值
                        id = findView.value();
                        field.set(target, view.findViewById(id));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
