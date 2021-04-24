package com.joyce.mapper;

import com.joyce.bean.Student;

import java.util.List;

public interface StudentMapper {
    public abstract List<Student> selectAll();

    public abstract Student selectById(Integer id);

    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    public abstract Integer delete(Integer id);
}
