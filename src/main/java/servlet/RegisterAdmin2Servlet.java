package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.libraryDAO;
import dto.account;

/**
 * Servlet implementation class RegisterAdminServlet2Servlet
 */
@WebServlet("/RegisterAdmin2Servlet")
public class RegisterAdmin2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdmin2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String path="";
		int result=0;
		
		if(email==null||pass==null) {
			path="WEB-INF/view/registerAdmin_1st.jsp?error=1";
		}else {
			account user=new account(0,null,email,null,pass,0);
			result=libraryDAO.registerAdminAccount(user);
			if(result==1) {
				path="WEB-INF/view/registerAdmin_success.jsp";
			}else {
				path="WEB-INF/view/registerAdmin_1st.jsp?error=1";
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
