package life.yg.forum.dto;

import life.yg.forum.model.User;
import lombok.Data;

/**
 * Create by yigang on 2020/12/21
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}