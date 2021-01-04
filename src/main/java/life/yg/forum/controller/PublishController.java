package life.yg.forum.controller;

import life.yg.forum.mapper.QuestionMapper;
import life.yg.forum.model.Question;
import life.yg.forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * created  by yigang on 2020/12/20
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "tag", required = false) String tag,
                            HttpServletRequest request,
                            Model model) {
        //content check
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if (title == null || title == "") {
            model.addAttribute("error", "title cant be empty");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "description cant be empty");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "tag cant be empty");
            return "publish";
        }

        //cookie check and user session check
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "user not log in");
            return "publish";
        }


        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
