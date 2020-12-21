package life.yg.forum.mapper;

import life.yg.forum.model.Question;
import life.yg.forum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * created by yigang on 2020/12/21
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question " +
            "(title,description,gmt_create,gmt_modified,creator,tag) " +
            "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
