package life.yg.forum.mapper;

import life.yg.forum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * created by yigang on 2020/12/20
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user " +
            "(name,account_id,token,gmt_create,gmt_modified) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
