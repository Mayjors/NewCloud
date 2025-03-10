package demo.eu.mapper;

import demo.eu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from sys_user where id = #{id}")
    User findById(@Param("id") Long id);
}
