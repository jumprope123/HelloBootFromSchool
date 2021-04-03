package shin.spring.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AopController {

    @GetMapping("/a")
    public String aaa(HttpSession sess) {
        return "aaa실행";
    }

    @GetMapping("/b")
    public String bbb(HttpSession sess) {
        return "bbb실행";
    }

    @GetMapping("/c")
    public String ccc(HttpSession sess) {
        return "ccc실행";
    }

}