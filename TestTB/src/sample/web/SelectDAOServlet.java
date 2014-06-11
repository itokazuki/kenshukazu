package sample.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.TodoDAO;
import sample.entity.Todo;



/**
 * Servlet implementation class SelectDAOServlet
 */
@WebServlet("/SelectDAOServlet")
public class SelectDAOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDAOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		TodoDAO db = new TodoDAO();

		try{

			db.getConnection();
			List<Todo> resultList = db.select();

			request.setAttribute("list", resultList);

			request.getRequestDispatcher("/list.jsp").forward(request,response);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}finally{
			db.closeConnection();
		}
	}
}






