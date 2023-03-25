package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.libraryDAO;
import dto.account;
import util.GenerateHashedPw;

/**
 * Servlet implementation class DeleteServlet2
 */
@WebServlet("/DeleteServlet2")
public class DeleteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path="";
		
		String pass=request.getParameter("pass");
		HttpSession session=request.getSession();
		account user=(account)session.getAttribute("info");
		String salt=libraryDAO.getSalt(user.getMail());
		String hashpw=GenerateHashedPw.getSafetyPassword(pass,salt);
		System.out.println(hashpw);
		System.out.println(user.getPass());
		if(user.getPass().equals(hashpw)) {
			List<String> checklist=libraryDAO.Nowlendlist(user);
			if(checklist.isEmpty()) {
				path="WEB-INF/view/DeleteUserAccount_success.jsp";
				RequestDispatcher dispatcher=request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				return;
			}else {
				path="WEB-INF/view/DeleteUserAccount_fail.jsp";
				RequestDispatcher dispatcher=request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				return;
			}
		}else {
			path="WEB-INF/view/DeleteUserAccount_fail.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			return;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
