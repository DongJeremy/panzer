package org.cloud.panzer.mapper;

import org.apache.ibatis.annotations.*;
import org.cloud.panzer.domain.TokenModel;

import java.util.Set;

@Mapper
public interface TokenMapper {
    @Insert("insert into t_token(id, val, expire_time, create_time, update_time) values (#{id}, #{val}, #{expireTime}, #{createTime}, #{updateTime})")
    int save(TokenModel model);

    @Select("select * from t_token t where t.id = #{id}")
    @Results({
            @Result(property = "expireTime", column = "expire_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })
    TokenModel getById(String id);

    @Select("select distinct id from t_token t")
    Set<String> getAll();

    @Update("update t_token t set t.val = #{val}, t.expire_time = #{expireTime}, t.update_time = #{updateTime} where t.id = #{id}")
    int update(TokenModel model);

    @Delete("delete from t_token where id = #{id}")
    int delete(String id);
}
