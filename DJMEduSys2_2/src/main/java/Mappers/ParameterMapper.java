package Mappers;

import Pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ParameterMapper {
    List<Teacher> selectAll();

    Teacher getTeacherById(int id);

    List<Teacher> getTeacherByAgeAndSalaryWithDefaultParam(int age, int salary);

    List<Teacher> getTeacherByAgeAndSalaryWithParam(@Param("age")int age,@Param("salary")int salary);

    List<Teacher> getTeacherByAgeAndSalaryWithMap(Map<String, Object> map);

    List<Teacher> getTeacherByAgeAndSalaryWithTeacher(Teacher teacher);

    int insertTeacher(Teacher teacher);
}
