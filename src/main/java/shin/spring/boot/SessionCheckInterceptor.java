package shin.spring.boot;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component("sci")
public class SessionCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws IOException {
        HttpSession sess = req.getSession();
        MemberVO mvo = (MemberVO) sess.getAttribute("logininfo");

        if (ObjectUtils.isEmpty(mvo)){
            res.sendRedirect("/jlogin");
            return false;
        }else {
            sess.setMaxInactiveInterval(30*60); //세션 유지시간 30분
            return true;
        }



    }
}
