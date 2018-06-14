package com.ypw.aon;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 2429219028@qq.com
 * @date 2018/6/14 14:50
 * 描述：findViewById注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindView {
    // 使用value命名，则使用的时候可以忽略，否则使用时就得把参数名加上
    int value();
}
