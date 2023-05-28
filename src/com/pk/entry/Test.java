package com.pk.entry;

import com.pk.controller.StudentController;

import java.util.Scanner;

public class Test {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("--------欢迎来到黑马信息管理系统--------");
            System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
            switch (sc.next()) {
                case "1":
                    System.out.println("进入学生信息管理界面");
                    new StudentController().start();
                    break;
                case "2":
                    System.out.println("进入老师信息管理界面");
//                    new TeacherController().start();
                    break;
                case "3":
                    System.out.println("感谢您的使用");
                    System.exit(0);
                default:
                    System.out.println("输入错误");
                    break;
            }
        }

    }
}
