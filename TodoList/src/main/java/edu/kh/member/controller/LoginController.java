package edu.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			
			Member loginMember = service.login(inputId, inputPw);
			
			HttpSession session = req.getSession();
			
			if( loginMember != null ) {
				session.setAttribute("loginMember", loginMember);
				
				resp.sendRedirect("/");
			} else {
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
