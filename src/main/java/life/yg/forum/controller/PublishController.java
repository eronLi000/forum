package life.yg.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * created  by yigang on 2020/12/20
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
       return "publish";
    }
}
