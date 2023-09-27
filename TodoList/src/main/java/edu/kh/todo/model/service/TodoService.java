package edu.kh.todo.model.service;

import java.sql.Connection;

import static edu.kh.todo.common.JDBCTemplate.*;
import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;

public class TodoService {
	
	private TodoDAO dao = new TodoDAO();

	public int insert(String todoTitle, String todoMemo) {
		
		Connection conn = getConnection();
		
		int result = dao.insert(conn, todoTitle, todoMemo);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);		
		
		close(conn);
		
		return result;
	}

}
