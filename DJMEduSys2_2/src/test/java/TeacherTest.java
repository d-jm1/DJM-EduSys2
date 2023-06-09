import Mappers.ParameterMapper;
import Mappers.SQLMapper;
import Mappers.SelectMapper;
import Pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.text.Format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TeacherTest {
    private String res="mybatis-config.xml";
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private ParameterMapper parameterMapper;

    @Before
    public void firstDo() throws IOException{
        inputStream= Resources.getResourceAsStream(res);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        parameterMapper = session.getMapper(ParameterMapper.class);
    }

    @Test
    public void testSelectAll(){
        List<Teacher> teachers = parameterMapper.selectAll();
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }
    @Test
    public void testGetTeacherById(){
        Teacher teacher=parameterMapper.getTeacherById(18);
        System.out.println(teacher);
    }

    @Test
    public void testGetTeacherByAgeAndSalaryWithDefaultParam(){
        List<Teacher> teachers = parameterMapper.getTeacherByAgeAndSalaryWithDefaultParam(40,4000);
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }

    @Test
    public void testGetTeacherByAgeAndSalaryWithParam(){
        List<Teacher> teachers = parameterMapper.getTeacherByAgeAndSalaryWithParam(40,4000);
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }

    @Test
    public void testGetTeacherByAgeAndSalaryWithMap(){
//        Map<String, Object> map=new HashMap<>();
        Map map= new HashMap();
        map.put("age",40);
        map.put("salary",4000);
        List<Teacher> teachers = parameterMapper.getTeacherByAgeAndSalaryWithMap(map);
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }



    @Test
    public void testGetTeacherByAgeAndSalaryWithTeacher(){
        Teacher teacher=new Teacher();
        teacher.setAge(40);
        teacher.setSalary(4000);
        List<Teacher> teachers = parameterMapper.getTeacherByAgeAndSalaryWithTeacher(teacher);
        teachers.forEach(t -> {
            System.out.println(t);
        });
    }

    @Test
    public void testInsertTeacher(){
        int i = parameterMapper.insertTeacher(new Teacher("t001","李白",45,"中国科技大学",2000,0010));
        System.out.println(i);
        session.commit();
    }
    @Test
    public void testGetTeacherByIdInSelectMapper()throws IOException{
        SelectMapper selectMapper = session.getMapper(SelectMapper.class);
        Teacher teacher = selectMapper.getTeacherById(14);
        System.out.println(teacher);
    }

    @Test
    public void testGetCountInSelectMapper()throws IOException{
        SelectMapper selectMapper = session.getMapper(SelectMapper.class);
        int count = selectMapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetTeacherByIdToMap(){
        SelectMapper selectMapper = session.getMapper(SelectMapper.class);
        Map<String, Object> teacher = selectMapper.getTeacherByIdToMap(12);
        System.out.println(teacher);
    }

    @Test
    public void testGetTeacherToMap(){
        SelectMapper selectMapper = session.getMapper(SelectMapper.class);
        Map<String, Object> teacher = selectMapper.getTeacherToMap();
        System.out.println(teacher);
    }

//    模糊查询
    @Test
    public void testGetTeacherByLike(){
        SQLMapper sqlMapper = session.getMapper(SQLMapper.class);
        List<Teacher> teachers = sqlMapper.getTeacherByLike("科技大学");
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }
    @Test
    public void testGetTeacherByLikeWithConcat(){
        SQLMapper sqlMapper = session.getMapper(SQLMapper.class);
        List<Teacher> teachers = sqlMapper.getTeacherByLikeWithConcat("科技大学");
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }

    @Test
    public void testGetTeacherByLike3(){
        SQLMapper sqlMapper = session.getMapper(SQLMapper.class);
        List<Teacher> teachers = sqlMapper.getTeacherByLike3("科技大学");
        teachers.forEach(teacher -> {
            System.out.println(teacher);
        });
    }
    @Test
    public void testDeleteMore(){
        SQLMapper sqlMapper = session.getMapper(SQLMapper.class);
        System.out.println(String.format("%d",sqlMapper.deleteMore("1,2,3,4")));
    }

    @Test
    public void testSelectTable(){
        SQLMapper sqlMapper = session.getMapper(SQLMapper.class);
        Map<String, Object> teachers = sqlMapper.selectTable("teacher");
        System.out.println(teachers.get(1));
    }

    @Test
    public void testInsertTeacherWithGenerateKey(){
        SQLMapper sqlMapper = session.getMapper(SQLMapper.class);
        Teacher teacher=new Teacher();
        teacher.setTName("王安石");
        sqlMapper.insertTeacherWithGenerateKey(teacher);
        System.out.println(teacher.getId());
        session.commit();
    }
    @After
    public void lastDo() throws IOException{
        session.close();
        inputStream.close();
    }
}
