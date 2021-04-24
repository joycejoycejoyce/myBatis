package com.joyce.service.impl;

import com.joyce.bean.Student;
import com.joyce.mapper.StudentMapper;

import com.joyce.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> selectAll() {
        List<Student> students = null;
        SqlSession session = null;
        InputStream stream = null;

        try {
            stream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession(true);

            StudentMapper mapper = session.getMapper(StudentMapper.class);
            students = mapper.selectAll();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }

            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return students;
    }

    @Override
    public Student selectById(Integer id) {
        Student student = null;
        SqlSession session = null;
        InputStream stream = null;

        try {
            stream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession(true);

            StudentMapper mapper = session.getMapper(StudentMapper.class);
            student = mapper.selectById(id);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }

            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public Integer insert(Student student) {
        int result = 0;
        SqlSession session = null;
        InputStream stream = null;

        try {
            stream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession(true);

            StudentMapper mapper = session.getMapper(StudentMapper.class);
            result = mapper.insert(student);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }

            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Integer update(Student student) {
        int result = 0;
        SqlSession session = null;
        InputStream stream = null;

        try {
            stream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession(true);

            StudentMapper mapper = session.getMapper(StudentMapper.class);
            result = mapper.update(student);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }

            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        int result = 0;
        SqlSession session = null;
        InputStream stream = null;

        try {
            stream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession(true);

            StudentMapper mapper = session.getMapper(StudentMapper.class);
            result = mapper.delete(id);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }

            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
