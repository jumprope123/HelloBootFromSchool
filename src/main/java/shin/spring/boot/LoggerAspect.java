package shin.spring.boot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LoggerAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    //로그를 출력하기 위한 로그객체 초기화

    //Pointcut은 특정 기능이 끼어들 지점/대상
    @Pointcut("execution(* shin.spring.boot.AopController.*(..))")
    public void callPointCut(){

    }

    //포인트컷 메소드가 실행되기 전에 지정한 코드 실행
    @Before("callPointCut()")
    public void BeforePointCut(JoinPoint jp){
        String method = jp.getSignature().getName();

        HttpSession sess = null;
        for (Object o : jp.getArgs()){ // 포인트컷에 선언된 인자들을 가져옴
            if (o instanceof HttpSession){
                sess = (HttpSession) o;
            }
            if (sess != null){
                MemberVO mvo = (MemberVO) sess.getAttribute("logininfo");
                if (mvo != null){
                    log.info(mvo.getUserid()+"로그인 함");
                }
            }
        }

        log.info(method + "실행전");
    }

    //포인트컷 메소드가 실행된 후에 지정한 코드 실행
    @After("callPointCut()")
    public void AfterPointCut(JoinPoint jp){
        String method = jp.getSignature().getName();
        log.info(method + "실행후");
    }


}
