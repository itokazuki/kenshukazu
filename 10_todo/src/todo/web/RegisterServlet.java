package todo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDAO;
import todo.entity.TodoValueObject;
import todo.util.SimpleMailSender;

/**
 * Servlet implementation class RejisterServlet
 */
@WebServlet("/todo/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String task = request.getParameter("task");
		String inputlimitdate = request.getParameter("limitdate");
		String userid = request.getParameter("userid");
		int status = Integer.parseInt(request.getParameter("status"));

		TodoValueObject vo = new TodoValueObject();
		vo.setId(id);
		vo.setTitle(title);
		vo.setTask(task);
		vo.setInputLimitdate(inputlimitdate);
		vo.setUserid(userid);
		vo.setStatus(status);



		TodoDAO dao = new TodoDAO();
		String message = "";
		try{

			if(id == 0){


				dao.getConnection();
				dao.registerInsert(vo);
				setMessage(request,"タスクの新規登録処理が完了しました。");
			}else{
				dao.getConnection();
				dao.registerUpdate(vo);
				setMessage(request, "タスク[ " + id + "]の更新処理が完了しました。");
			}
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();
		}

		String toAddr = "databasetest1991@yahoo.co.jp";
		String fromAddr = "databasetest1991@yahoo.co.jp";
		String personName = "伊藤一輝";
		String subject = "TODO管理アプリケーションからの報告です";

		SimpleMailSender mail = new SimpleMailSender();
		try{
			mail.sendMessage(toAddr, fromAddr, personName, subject , message);
		}catch (Exception e){
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/todo/search");
		rd.forward(request ,  response);
	}

	protected void setMessage(HttpServletRequest requset , String message){
		requset.setAttribute("message" , message);

	}



}
