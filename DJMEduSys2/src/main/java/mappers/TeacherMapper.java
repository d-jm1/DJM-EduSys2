package mappers;

import Pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Teacher> selectAll();
    int insertOne();
    int updateOne();
}
