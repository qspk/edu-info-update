package com.pk.server;

import com.pk.dao.BaseStudentDao;
import com.pk.dao.StudentDaoFactory;
import com.pk.domain.Student;

import java.util.ArrayList;

public class StudentServer {
    //通过StudentDao工厂 获取 Dao 层对象
    BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();

    //判断用户输入的 id 是否存在 ,若存在,返回true
    public boolean exist(String id) {
        //1.从Dao层获取全部学生信息
        ArrayList<Student> students = studentDao.findAll();
        //2.遍历学生信息数据,查看id是否存在
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //添加学生信息
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    //判断学生信息是否为空
    //获得学生集合,判断大小是否为0 ,是返回null, 否返回学生集合
    public ArrayList<Student> isNull() {
        ArrayList<Student> students = studentDao.findAll();
        if (students.size() == 0) {
            return null;
        } else {
            return students;
        }
    }

    //根据id删除学生
    public Boolean remove(String id) {
        return studentDao.remove(id);
    }

    public Boolean updateStudent(Student newStudent) {
        return studentDao.updateStudent(newStudent);
    }
}
