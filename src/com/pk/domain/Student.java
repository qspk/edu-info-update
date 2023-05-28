package com.pk.domain;

/**
 *  继承依然需要写有参 (无参) 构造方法,不然无法使用有参 初始化
 */
public class Student extends Person {


    public Student() {
    }

    public Student(String id, String name, String age, String birthday) {
        super(id, name, age, birthday);
    }
}
