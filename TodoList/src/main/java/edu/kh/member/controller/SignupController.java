package edu.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;

@WebServlet("/signup")
public class SignupController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputNickname = req.getParameter("inputNickname");
			
			MemberService service = new MemberService();
			Member member = new Member();
			
			member.setMemberId(inputId);
			member.setMemberPw(inputPw);
			member.setMemberNickname(inputNickname);
			
			int result = service.signup(member);
			
			if(result > 0) {
				resp.sendRedirect("/");
			} else {
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
