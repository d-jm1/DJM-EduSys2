package Mappers;

import Pojo.Teacher;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 特殊SQL语句
 * 1. 模糊查询 #{}失效,但是${}依旧有效
 * 2. concat()函数
 * 3. "%"#{param}"%" 直接拼接
 */
public interface SQLMapper {
    /**
     * 根据毕业学校模糊查询
     */
//    1. ${}
    List<Teacher> getTeacherByLike(@Param("graduate")String graduate);
//    2. concat
    List<Teacher> getTeacherByLikeWithConcat(@Param("graduate")String graduate);
//    3. "%"#{param}"%"
    List<Teacher> getTeacherByLike3(@Param("graduate")String graduate);
    /**
     * 批量删除
     * 1. ${}
     */
//    1. ${}
    int deleteMore(@Param("ids")String ids);
    /**
     * 动态设置表名
     * 1. ${}
     */
    @MapKey("id")
    Map<String,Object> selectTable(@Param("tableName")String tableName);

    /**
     * insert同时获取主键键值
     * 键值会通过keyProperty 利用实体类的set方法传递到实体类中
     */
    void insertTeacherWithGenerateKey(Teacher teacher);
}
