package edu.kh.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String todoTitle = req.getParameter("insertTitle");
			String todoMemo = req.getParameter("insertMemo");
			
			TodoService service = new TodoService();
			Todo insertTodo = new Todo();
			
			insertTodo.setTodoTitle(todoTitle);
			insertTodo.setTodoMemo(todoMemo);
			
			int result = service.insert(todoTitle, todoMemo);
			
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
