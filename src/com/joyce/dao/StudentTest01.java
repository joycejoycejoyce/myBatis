package com.joyce.dao;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import com.joyce.bean.Student;

public class StudentTest01 {

    @Test
    public void delete() throws Exception{
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sessionFactory.openSession();

        int result = session.delete("StudentMapper.delete", 5);

        session.commit();
        System.out.println(result);

        session.close();
        stream.close();
    }

    @Test
    public void modify() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        Student newStudent = new Student(5, "Five Five", 25);
        int result = session.insert("StudentMapper.update", newStudent);

        // can comment out
        session.commit();

        System.out.println(result);
        session.close();
        stream.close();
    }

    @Test
    public void insert() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

        // the parameter true means auto commit
        SqlSession session = sqlSessionFactory.openSession(true);
        Student newStudent = new Student(5, "Student Five", 25);
        int result = session.insert("StudentMapper.insert", newStudent);

        // can comment out
        // session.commit();

        System.out.println(result);
        session.close();
        stream.close();
    }

    @Test
    public void selectById() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = factory.openSession();
        Student student = sqlSession.selectOne("StudentMapper.selectById", 1);
        System.out.println(student);

        sqlSession.close();
        stream.close();
    }

    @Test
    public void selectAll() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");

        for (Student s: list){
            System.out.println(s);
        }

        sqlSession.close();
        stream.close();
    }

}
