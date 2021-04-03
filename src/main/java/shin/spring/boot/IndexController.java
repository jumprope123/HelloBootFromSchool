package shin.spring.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController //뷰 없이 바로 찍어준다.
@Controller
public class IndexController {

    @GetMapping("/index1")
    public String index1(){
        return "index";
    }

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }

}
