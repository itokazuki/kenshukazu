package sample.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sample.entity.Todo;

public class TodoDAO  extends MySQLDAO{
	public List<Todo> select() throws Exception{
		String sql = "SELECT title , task , limitdate , lastupdate , userid , status FROM todo_list WHERE userid like CONCAT('%' , ? , '%')";

		PreparedStatement statement =  connection.prepareStatement(sql);

		statement.setString(1,"USER");

		ResultSet rs = statement.executeQuery();

		List<Todo> resultList = new ArrayList<Todo>();

		while (rs.next()){

			Todo todo = new Todo();
			todo.setTitle(rs.getString("title"));
			todo.setTask(rs.getString("task"));
			todo.setLimitdate(rs.getString("limitdate"));
			todo.setLastupdate(rs.getString("lastupdate"));
			todo.setUserid(rs.getString("userid"));
			todo.setStatus(rs.getInt("status"));

			resultList.add(todo);
		}

		return resultList;

	}

	public void insert()  throws Exception{

		String sql = "INSERT INTO lecture.todo_list (title , task , limitdate , lastupdate , userid , status " + " VALUES (? , ? , ? , now() , ? ,?);";

		try{
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1,"講習会準備");
			statement.setString(2,"講習会のスライド作成、配布ソースコードの準備");
			statement.setString(3,"2012-06-12");
			statement.setString(4,"USER99");
			statement.setInt(5,0);

			int count = statement.executeUpdate();
			System.out.println("１つ目の追加:" + count);

			connection.commit();
		}catch(Exception e){
			connection.rollback();
			throw e;
		}
	}
}













