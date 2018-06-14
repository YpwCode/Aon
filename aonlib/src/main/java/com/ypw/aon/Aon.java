package com.ypw.aon;

import android.app.Activity;
import android.util.Log;
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
        try {
            Class<?> clazz = target.getClass();
            // 获取所有的字段
            Field[] fields = clazz.getDeclaredFields();

            FindView findView;
            View view;
            int id;
            String name;

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
                        // 字段名
                        name = field.getName();
                        // 注解值
                        id = findView.value();

                        // 查找对象
                        view = target.findViewById(id);
                        if (view != null) {
                            // 赋值
                            field.set(target, view);
                        } else {
                            Log.e("TAG", "bind: 没有找到" + name);
                        }

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
