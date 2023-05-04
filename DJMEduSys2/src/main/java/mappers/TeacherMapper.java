package mappers;

import Pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    int insertOne();
    int updateOne();
    int deleteOne();
    List<Teacher> selectAll();
    List<Teacher> selectGetAll();
}
