package com.pk.dao;

public class StudentDaoFactory {    //工厂 利用多态解耦合  有多个Dao类时,返回需要的对象即可
    public static BaseStudentDao getStudentDao() {  //用static定义静态方法,可以直接用 类名.方法  调用
        return new StudentDao();
    }

}
