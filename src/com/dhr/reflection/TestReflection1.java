package com.dhr.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 13:50
 * @Description: 动态的创建对象，通过反射
 */
public class TestReflection1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象 3种方式
        Class c1 = Class.forName("com.dhr.User");
//        Class c2 = User.class;
//        User user = new User();
//        Class c3 = user.getClass();


        //构造一个对象
//        User user = (User) c1.newInstance();//本质是调用类的无参构造器
//        System.out.println(user);

        //通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class);
//        User user = (User) constructor.newInstance("dhr", 112);
//        System.out.println(user);

        //通过反射操作方法
//        User user = (User) c1.newInstance();
//        Method setName = c1.getDeclaredMethod("setName", String.class);
//        //invoke: 激活的意思    （对象，方法的值）
//        setName.invoke(user, "dhr");
//        System.out.println(user);

        //通过反射操作属性
        User user = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要通过关闭安全监测，
        name.setAccessible(true);
        name.set(user, "dhr");
        System.out.println(user);
    }
}
