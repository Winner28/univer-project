package com.leti.project.dao;

import com.leti.project.entities.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UsersMapper {

    @Select("SELECT * FROM users WHERE id = #{id} LIMIT 1")
    UserEntity getById(final Long id);

    @Insert("INSERT INTO users (email, passwordHash, firstName, lastName)"
            + "VALUES (#{email}, #{passwordHash}, #{firstName}, #{lastName}")
    @Options(useGeneratedKeys = true, keyColumn = "ID", keyProperty = "id")
    Long create(final UserEntity userEntity);

}
