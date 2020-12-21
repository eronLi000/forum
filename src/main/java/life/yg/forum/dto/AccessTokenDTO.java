package life.yg.forum.dto;

import lombok.Data;

/**
 * created by yigang on 2020/12/19
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
