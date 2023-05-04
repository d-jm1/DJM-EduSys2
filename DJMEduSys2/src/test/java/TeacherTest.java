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
    /**
     * SqlSession 默认不自动提交事务
     * 可以使用SqlSessionFactory.openSession(true) 使之自动提交
     */
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
    public void testInsert(){
        System.out.println(teacherMapper.insertOne());
        session.commit();
    }
    @Test
    public void testUpdate(){
        System.out.println(teacherMapper.updateOne());
        session.commit();
    }
    @Test
    public void testDelete(){
        System.out.println(teacherMapper.deleteOne());
        session.commit();
    }
    @Test
    public void testSelectAll()throws IOException{
        List<Teacher> teachers = teacherMapper.selectAll();
        System.out.println(teachers);
    }
    @Test
    public  void testSelectGetAll() throws IOException{
        List<Teacher> teachers= (List<Teacher>) teacherMapper.selectGetAll();
        teachers.forEach(teacher-> System.out.println(teacher));
    }
    @After
    public void lastDo()throws IOException{
        session.close();
        inputStream.close();
    }

}
