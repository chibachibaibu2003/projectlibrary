package servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.libraryDAO;
import dto.account;

/**
 * Servlet implementation class RegisterUser4Servlet
 */
@WebServlet("/RegisterUser4Servlet")
public class RegisterUser4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String firstname=request.getParameter("firstname");
		String familyname=request.getParameter("familyname");
		String pass=request.getParameter("pass");
		
		String subject="登録完了のお知らせ";
		String text="会員IDの新規登録が完了しました！";
		String urlStr="";
		URL url=new URL(urlStr);
		String path="";
		
		if(email.length()<5||firstname==null||familyname==null||pass.length()<=10) {
			path="WEB-INF/view/registerUser_3rd.jsp?email="+email+"&error=1";
		}else {
			String name=familyname.concat(firstname);
			account user=new account(0,name,email,null,pass,0);
			int result=libraryDAO.registerUserAccount(user);
			if(result==1) {
				path="WEB-INF/view/RegisterUser_4th.jsp";
				libraryDAO.sendMail(email, subject, text, url);
			}else {
				path="WEB-INF/view/registerUser_3rd.jsp?email="+email+"&error=1";
			}
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
