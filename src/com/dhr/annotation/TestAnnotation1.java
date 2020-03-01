package com.dhr.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 15:57
 * @Description: 自定义注解
 */
@DhrClass(value = "myAnnotation", name = "dhr")
public class TestAnnotation1 {
    @DhrClass(value = "myAnnotation", name = "dhr", age = 22)
    private String sex;
}

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface DhrClass {
    String value();

    String name();

    int age() default 22;
}