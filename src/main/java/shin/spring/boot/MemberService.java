package shin.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("msrv")
public class MemberService {

	@Autowired MemberDAO mdao;
	
	public String joinMember(MemberVO mvo) {
		String result = "redirect:/joinfail";
		
		int cnt = mdao.insertMember(mvo);
		if (cnt > 0) result = "redirect:/jlogin";
		
		return result;
	}

	public String loginMember(MemberVO mvo, HttpSession session) {
		String result = "redirect:/loginfail";

		int cnt = mdao.loginMember(mvo);
		if (cnt > 0) {
			result = "redirect:/jindex";
			session.setAttribute("logininfo",mvo);
		}

		return result;
	}
}

