package com.joyce.paging;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joyce.bean.Student;
import com.joyce.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
    @Test
    public void selectPaging() throws Exception {
        InputStream stream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession(true);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        PageHelper.startPage(3, 3);

        List<Student> students = mapper.selectAll();

        for(Student s: students){
            System.out.println(s);
        }

        PageInfo<Student> info = new PageInfo<>(students);
        System.out.println("total rows: "+info.getTotal());
        System.out.println("total pages: "+info.getPages());
        System.out.println("current page: "+info.getPageNum());
        System.out.println("total item per page: "+info.getPageSize());
        System.out.println("prev page: "+info.getPrePage());
        System.out.println("first page? "+info.isIsFirstPage());

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
