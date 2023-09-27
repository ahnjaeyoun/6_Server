package edu.kh.member.model.service;

import java.sql.Connection;

import edu.kh.member.model.dao.MemberDAO;
import edu.kh.member.model.dto.Member;
import static edu.kh.todo.common.JDBCTemplate.*;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO(); 

	public Member login(String inputId, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return loginMember;
	}

	public int signup(Member member) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.signup(conn, member);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);		
		
		close(conn);
		
		return result;
	}

	

}
