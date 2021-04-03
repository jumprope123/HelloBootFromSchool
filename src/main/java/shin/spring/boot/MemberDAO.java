package shin.spring.boot;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDAO {
	
	@Autowired SqlSession sqlSession;

	public int insertMember(MemberVO mvo) {
		return sqlSession.insert("member.joinmember", mvo);	
	}

	public int loginMember(MemberVO mvo) {
		return sqlSession.selectOne("member.loginmember",mvo);
	}
}




