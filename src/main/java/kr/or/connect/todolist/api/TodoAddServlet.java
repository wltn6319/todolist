package kr.or.connect.todolist.api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todolist.dao.TodoDao;
import kr.or.connect.todolist.dto.TodoDto;


@WebServlet("/addServlet")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);


		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = (String)request.getParameter("name");	
		String title = (String)request.getParameter("title");
		int sequence = Integer.parseInt(request.getParameter("sequence"));

		TodoDto todo = new TodoDto(name, title, sequence);
		TodoDao dao = new TodoDao();
		dao.addTodo(todo);
		
		  response.sendRedirect("main");

		


	}

}
