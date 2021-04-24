package com.joyce.controller;

import com.joyce.bean.Student;
import com.joyce.service.StudentService;
import com.joyce.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    @Test
    public void selectAll(){
        List<Student> students = service.selectAll();
        for (Student s: students){
            System.out.println(s);
        }
    }

    @Test
    public void selectById(){
        Student student = service.selectById(3);
        System.out.println(student);
    }

    @Test
    public void insert(){
        Student student = new Student(5, "Student Five", 25);
        Integer result = service.insert(student);
        System.out.println(result);
    }

    @Test
    public void update(){
        Student student = new Student(5, "Five Fivee", 26);
        Integer result = service.update(student);
        System.out.println(result);
    }

    @Test
    public void delete(){
        Integer result = service.delete(5);
        System.out.println(result);
    }
}
