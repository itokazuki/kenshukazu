package sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import sample.entity.Todobook;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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

			log("接続を開きました");

			List<Todobook>resultList = select(connection);

			request.setAttribute("list",resultList);

			request.getRequestDispatcher("/book.jsp").forward(request,response);

			}catch(Exception e){
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

	public List<Todobook> select(Connection connection) throws Exception{

		String sql = "INSERT INTO lecture.book ( isbn,title,price,publish,published " + ") VALUES(?,?,?,?,?);";



			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1,"978-4-8222-9613-1");
			statement.setString(2,"アプリを作ろう！Anlroid入門");
			statement.setInt(3,1995);
			statement.setString(4,"日経BP");
			statement.setString(5,"2012-09-13");

			int count = statement.executeUpdate();
			log("１つ目の追加:" + count);

			statement.setString(1,"978-4-7981-2631-9");
			statement.setString(2,"10日でおぼえるPHP入門教室");
			statement.setInt(3,2709);
			statement.setString(4,"翔詠社");
			statement.setString(5,"2012-09-13");

			count = statement.executeUpdate();
			log("２つ目の追加:" + count);

			statement.setString(1,"978-4-7741-5067-3");
			statement.setString(2,"HTML5開発ポケットリファレンス");
			statement.setInt(3,2709);
			statement.setString(4,"義油つ評論社");
			statement.setString(5,"2012-04-17");

			count = statement.executeUpdate();
			log("３つ目の追加:" + count);

			statement.setString(1,"978-4-7980-3300-6");
			statement.setString(2,"はじめてのJSP/サーブレット");
			statement.setInt(3,2730);
			statement.setString(4,"秀和システム");
			statement.setString(5,"2012-03-24");

			count = statement.executeUpdate();
			log("４つ目の追加:" + count);

			statement.setString(1,"978-4-7741-4980-6");
			statement.setString(2,"Ruby on Rails3 ポケットリファレンス");
			statement.setInt(3,2780);
			statement.setString(4,"技術評論社");
			statement.setString(5,"2012-01-26");

			count = statement.executeUpdate();
			log("５つ目の追加:" + count);

			statement.setString(1,"978-4-8222-9465-6");
			statement.setString(2,"Windows Azure Platform開発入門");
			statement.setInt(3,3990);
			statement.setString(4,"日経BP");
			statement.setString(5,"2012-01-06");

			count = statement.executeUpdate();
			log("６つ目の追加:" + count);

			statement.setString(1,"978-4-7741-4948-6");
			statement.setString(2,"C#ポケットリファレンス");
			statement.setInt(3,2580);
			statement.setString(4,"技術評論社");
			statement.setString(5,"2011-12-03");

			count = statement.executeUpdate();
			log("７つ目の追加:" + count);

			statement.setString(1,"978-4-7980-3080-7");
			statement.setString(2,"ASP NET逆引き大全");
			statement.setInt(3,3150);
			statement.setString(4,"秀和システム");
			statement.setString(5,"2011-09-14");

			count = statement.executeUpdate();
			log("８つ目の追加:" + count);

			statement.setString(1,"978-4-88337-774-9");
			statement.setString(2,"Flash CS5.5で学ぶiPhone実践プログラミング");
			statement.setInt(3,2625);
			statement.setString(4,"ソシム");
			statement.setString(5,"2011-08-16");

			count = statement.executeUpdate();
			log("９つ目の追加:" + count);//PreparedStatement statement = connection.prepareStatement(sql);


			statement.setString(1,"978-4-7981-2151-2");
			statement.setString(2,"独習PHPP第２版");
			statement.setInt(3,3360);
			statement.setString(4,"翔詠社");
			statement.setString(5,"2010-04-12");

			count = statement.executeUpdate();
			log("１０つ目の追加:" + count);
			//statemaent.
			ResultSet rs = statement.executeQuery();

			List<Todobook> resultList = new ArrayList<Todobook>();

			while (rs.next()){
				Todobook todobook = new Todobook();
				todobook.setIsbn(rs.getString("isbn"));
				todobook.setTitle(rs.getString("title"));
				todobook.setPrice(rs.getInt("price"));
				todobook.setPublish(rs.getString("publish"));
				todobook.setPublished(rs.getString("published"));


				resultList.add(todobook);

			}

			return resultList;

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
