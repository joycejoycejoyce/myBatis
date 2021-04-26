package com.joyce.dynamic;

import com.joyce.bean.Student;
import com.joyce.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
    @Test
    public void selectByIds() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession(true);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<Student> students = mapper.selectByIds(ids);

        for(Student s: students){
            System.out.println(s);
        }

        session.close();
        stream.close();
    }

    @Test
    public void selectCondition() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession(true);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setId(2);
        student.setName("Number Two");
        // student.setAge(22);

        List<Student> students = mapper.selectCondition(student);

        for(Student s: students){
            System.out.println(s);
        }

        session.close();
        stream.close();
    }
}
