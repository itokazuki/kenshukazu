package sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/InsertServret")
public class InsertServret extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServret() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection connection = null;

		try{
			InitialContext initCtx = new InitialContext();

			DataSource ds  = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");

			connection = ds.getConnection();

			connection.setAutoCommit(false);

			log("接続を開きました");

			insert(connection);
		}catch (Exception e){
			throw new ServletException(e);
		}finally{
			try{
				connection.close();
				log("接続を閉じました");
			}catch(SQLException e){
				throw new ServletException(e);
			}
		}

		request.getRequestDispatcher("/complete.html").forward(request, response);
	}

	private void insert(Connection connection) throws Exception{

		String sql = "INSERT INTO lecture.todo_list ( title,task,limitdate,lastupdate,userid,status " + ") VALUES(?,?,?,now(),?,?);";



			try{

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1,"講習会準備");
			statement.setString(2,"講習会のスライド作成、配布ソースコードの準備");
			statement.setString(3,"2012-06-12");
			statement.setString(4,"USER99");
			statement.setInt(5,0);

			int count = statement.executeUpdate();
			log("１つ目の追加:" + count);

			statement.setString(1,"講演会");
			statement.setString(2,"2012年7月の講習会を実施");
			statement.setString(3,"2012-07-01");
			statement.setString(4,"USER99");
			statement.setInt(5,0);

			count = statement.executeUpdate();
			log("２つ目の追加:" + count);

			connection.commit();
		}catch (Exception e){
			connection.rollback();
			throw e;
		}




	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
