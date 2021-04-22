package kr.or.connect.todolist.dao;



import kr.or.connect.todolist.dto.TodoDto;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoDao {
	private static String dburl ="jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";


	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM todo";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String title = rs.getString(3);
					int sequence = rs.getInt(4);
					String type = rs.getString(5);


					TodoDto todo = new TodoDto(id, name, title, sequence, type);
					list.add(todo); // list에 반복할때마다 Todo인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO todo (name, title, sequence) VALUES ( ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getName());
			ps.setString(2, todo.getTitle());
			ps.setInt(3, todo.getSequence());


			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}

	public int updateTodo(int id , String type) {
		int updateCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		String sql = "UPDATE todo SET type = ? WHERE id = ? ";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			String updateType ="";
			if("TODO".equals(type)) {
				updateType = "DOING";
			}
			else if("DOING".equals(type)) {
				updateType = "DONE";
			}
			
			ps.setString(1, updateType);
			ps.setInt(2, id);
			
			updateCount = ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return updateCount;
		
	}
	
	
}








