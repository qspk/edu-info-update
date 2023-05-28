package com.pk.dao;

import com.pk.domain.Student;

import java.util.ArrayList;

public class StudentDao implements BaseStudentDao {

    private static final ArrayList<Student> students = new ArrayList<>();
    static{
        students.add(new Student("heima005", "赵六", "23", "2001-01-22"));
        students.add(new Student("heima004", "陈七", "25", "1999-01-22"));
    }

    //返回server层全部学生信息,即 学生信息集合students
    @Override
    public ArrayList<Student> findAll() {
        return students;
    }

    @Override
    public boolean addStudent(Student student) {
        //学生容量 9999999
        if (students.size() < 9999999) {
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean remove(String id) {
        Student student = getById(id);
        return students.remove(student);
    }

    //根据id获取学生信息
    @Override
    public Student getById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    //根据id获取学生信息所在集合索引
    public int getIndexById(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public Boolean updateStudent(Student newStudent) {
        int index = getIndexById(newStudent.getId());
        if (index != -1) {
            students.set(index, newStudent);
            return true;
        } else {
            return false;
        }
    }


}
