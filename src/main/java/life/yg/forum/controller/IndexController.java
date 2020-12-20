package life.yg.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yigang on 2020/12/19
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){ return "index"; }
}
