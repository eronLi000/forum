package life.yg.forum.dto;

import lombok.Data;

/**
 * modified by yigang on 20202/12/21
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
