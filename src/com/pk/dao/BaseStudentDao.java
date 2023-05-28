package com.pk.dao;

import com.pk.domain.Student;

import java.util.ArrayList;

public interface BaseStudentDao {

    //获取全部学生信息
    ArrayList<Student> findAll();

    //添加学生信息
    boolean addStudent(Student student);

    //根据id删除学生信息
    Boolean remove(String id);

    //根据id查找学生
    Student getById(String id);

    //修改学生信息
    Boolean updateStudent(Student newStudent);

    //根据id获得学生信息所在集合的索引
    int getIndexById(String id);
}
