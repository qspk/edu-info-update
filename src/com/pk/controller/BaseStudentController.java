package com.pk.controller;

import com.pk.domain.Student;
import com.pk.server.StudentServer;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseStudentController {
    Scanner sc = new Scanner(System.in);
    StudentServer studentServer = new StudentServer();

    //展示学生信息管理界面
    public final void start() {
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            switch (sc.next()) {
                case "1":
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteById();
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent();
                    break;
                case "4":
                    System.out.println("查看学生");
                    printAllStudent();
                    break;
                case "5":
                    System.out.println("即将退出学生管理界面,返回主界面");
                    return;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }

    //修改学生信息
    public void updateStudent() {
        if (studentServer.isNull() == null) {
            System.out.println("系统中还没有学生信息,请先添加哦~");
            return;
        }
        System.out.println("请输入学生id:");
        String id = sc.next();
        if (studentServer.exist(id)) {
            Student newStudent = inputInfo(id);
            studentServer.updateStudent(newStudent);
            System.out.println("修改成功");
        } else {
            System.out.println("未查询到学生id,请检重试!");
        }
    }

    //通过id删除学生
    public void deleteById() {
        if (studentServer.isNull() == null) {
            System.out.println("系统中还没有学生信息,请先添加哦~");
            return;
        }
        System.out.println("请输入学生id:");
        String id = sc.next();
        if (studentServer.remove(id)) {
            System.out.println("删除成功");
        } else {
            System.out.println("未查询到学生id,请检重试!");
        }

    }


    //查看全部学生
    public void printAllStudent() {
        //判断有无学生信息
        ArrayList<Student> students = studentServer.isNull();
        if (students == null) {
            System.out.println("系统中还没有学生信息,请先添加哦~");
        } else {
            System.out.println("学号" + "\t\t\t" + "姓名" + "\t\t" + "年龄" + "\t\t生日");
            for (Student student : students) {
                if (student == null) {
                    return;
                }
                System.out.println(student.getId() + "\t" + student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getBirthday());
            }
        }
    }

    //添加学生
    public void addStudent() {
        String id = inputId();
        Student student = inputInfo(id);
        //向server 发送添加请求 通过返回值判断是否成功
        if (studentServer.addStudent(student)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败,学生人数太多啦~");
        }
    }


    //录入学生信息 并封装
    public Student inputInfo(String id) {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        return new Student(id, name, age, birthday);
    }

    //录入id信息 判断id是否存在
    public String inputId() {
        while (true) {
            System.out.println("请输入学生id: ");
            String id = sc.next();
            if (studentServer.exist(id)) {
                System.out.println("id已存在,请重新输入");
            } else {
                return id;
            }
        }
    }
}
