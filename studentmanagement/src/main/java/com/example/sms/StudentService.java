package com.example.sms;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    // 添加学生
    public void addStudent(Student student) {
        students.add(student);
    }

    // 删除学生
    public boolean removeStudentById(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    // 更新学生信息
    public boolean updateStudent(String id, String name, String gender, int age) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(name);
                student.setGender(gender);
                student.setAge(age);
                return true;
            }
        }
        return false;
    }

    // 查询学生信息
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // 显示所有学生
    public List<Student> getAllStudents() {
        return students;
    }
}
