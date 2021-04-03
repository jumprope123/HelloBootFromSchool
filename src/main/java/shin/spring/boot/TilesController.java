package shin.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TilesController {
	
	@Autowired
	MemberService msrv;
	
	@GetMapping("/jindex")
	public String index() {
		//return "jsp/index";
		return "index.tiles";
	}
	
	@GetMapping("/jjoin")    // 회원가입 폼 
	public String join() {
		//return "jsp/join";
		return "join.tiles";
	}
	
	@PostMapping("/jjoinok") // 회원가입 처리
	public String joinok(MemberVO mvo) {
		
		String result = msrv.joinMember(mvo);

		return result;
	}
	
	@GetMapping("/jlogin")
	public String login() {
		//return "jsp/login";
		return "login.tiles";
	}

	@PostMapping("/jloginok")
	public String loginok(MemberVO mvo, HttpSession session) {
		String result = msrv.loginMember(mvo,session);
		return result;
	}
	@GetMapping("/jlogout")
	public String jlogout(HttpSession session) {
		session.invalidate();
		return "redirect:/jindex";
	}
	
	@GetMapping("/jlist")
	public String list() {
		return "list.tiles";
	}

	@GetMapping("/jmember")
	public String jmember() {
		return "member.tiles";
	}

}
