package Mappers;

import Pojo.Teacher;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface SelectMapper {
//    根据ID查询Teahcer信息
    Teacher getTeacherById(@Param("id")int id);

    int getCount();

    Map<String ,Object> getTeacherByIdToMap(@Param("id")int id);

    @MapKey("id")
    Map<String,Object> getTeacherToMap();
}
