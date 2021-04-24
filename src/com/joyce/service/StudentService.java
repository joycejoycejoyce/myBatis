package com.joyce.service;

import com.joyce.bean.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> selectAll();

    public abstract Student selectById(Integer id);

    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    public abstract Integer delete(Integer id);
}
