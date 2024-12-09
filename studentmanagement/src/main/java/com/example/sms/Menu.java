package com.example.sms;

import java.util.Scanner;

public class Menu {
    private StudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n--- 学生管理系统 ---");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 更新学生信息");
            System.out.println("4. 查询学生信息");
            System.out.println("5. 显示所有学生");
            System.out.println("6. 退出");
            System.out.print("请选择操作: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 处理换行符

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> updateStudent();
                case 4 -> findStudent();
                case 5 -> listAllStudents();
                case 6 -> {
                    System.out.println("退出系统...");
                    return;
                }
                default -> System.out.println("无效选择，请重新输入！");
            }
        }
    }

    private void addStudent() {
        System.out.print("输入学号: ");
        String id = scanner.nextLine();
        System.out.print("输入姓名: ");
        String name = scanner.nextLine();
        System.out.print("输入性别: ");
        String gender = scanner.nextLine();
        System.out.print("输入年龄: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // 处理换行符

        studentService.addStudent(new Student(id, name, gender, age));
        System.out.println("学生添加成功！");
    }

    private void removeStudent() {
        System.out.print("输入要删除的学生学号: ");
        String id = scanner.nextLine();
        if (studentService.removeStudentById(id)) {
            System.out.println("学生删除成功！");
        } else {
            System.out.println("学生不存在！");
        }
    }

    private void updateStudent() {
        System.out.print("输入要更新的学生学号: ");
        String id = scanner.nextLine();
        System.out.print("输入新姓名: ");
        String name = scanner.nextLine();
        System.out.print("输入新性别: ");
        String gender = scanner.nextLine();
        System.out.print("输入新年龄: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // 处理换行符

        if (studentService.updateStudent(id, name, gender, age)) {
            System.out.println("学生信息更新成功！");
        } else {
            System.out.println("学生不存在！");
        }
    }

    private void findStudent() {
        System.out.print("输入要查询的学生学号: ");
        String id = scanner.nextLine();
        Student student = studentService.findStudentById(id);
        if (student != null) {
            System.out.println("学生信息: " + student);
        } else {
            System.out.println("学生不存在！");
        }
    }

    private void listAllStudents() {
        System.out.println("--- 所有学生信息 ---");
        for (Student student : studentService.getAllStudents()) {
            System.out.println(student);
        }
    }
}
