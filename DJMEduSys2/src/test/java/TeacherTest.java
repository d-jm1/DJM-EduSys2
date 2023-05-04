import Pojo.Teacher;
import mappers.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TeacherTest {
    private String res="mybatis-config.xml";
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private TeacherMapper teacherMapper;
    @Before
    public void firstDo()throws IOException {
        inputStream = Resources.getResourceAsStream(res);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
    }

    @Test
    public void testSelectAll()throws IOException{
        List<Teacher> teachers = teacherMapper.selectAll();
        System.out.println(teachers);
    }

    @Test
    public void testInsert(){
        System.out.println(teacherMapper.insertOne());
        session.commit();
    }
    @Test
    public void testUpdate(){
        System.out.println(teacherMapper.updateOne());
        session.commit();
    }
    @After
    public void lastDo()throws IOException{
        session.close();
        inputStream.close();
    }

}
