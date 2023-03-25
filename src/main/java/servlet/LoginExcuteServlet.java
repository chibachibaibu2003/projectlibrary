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

import dao.SendMailDAO;
import dao.libraryDAO;
import dto.account;
import dto.book;
import dto.reviewList;
import util.GenerateHashedPw;

/**
 * Servlet implementation class Login2servlet
 */
@WebServlet("/LoginExcuteServlet")
public class LoginExcuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginExcuteServlet() {
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
		String email=request.getParameter("email");
		
		if(email==null||pass==null) {
			path= "WEB-INF/view/login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			return;
		}
		
		String salt=libraryDAO.getSalt(email);
		if(salt==null) {
			path = "WEB-INF/view/login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			return;
		}
		String hashPw= GenerateHashedPw.getSafetyPassword(pass, salt);
		account account=libraryDAO.login(email, hashPw);
		if(account==null){
			path= "WEB-INF/view/login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			return;
		}else if(account.getUser_check()==0) {
			path="WEB-INF/view/home_after.jsp";
			
			HttpSession session=request.getSession();
			session.setAttribute("info",account);
			
			List<reviewList> lendlist=libraryDAO.LendNow4List(account);
			session.setAttribute("lendNowList", lendlist);
			
			List<book> highlist=libraryDAO.HighPointBook();
			session.setAttribute("HighPoint", highlist);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			return;
		}else if(account.getUser_check()==1){
			List<account> overlist=SendMailDAO.getOverInfo();
			if(overlist!=null) {
				SendMailDAO.SendOverNoticeMail(overlist);
			}
			List<account> nearlist=SendMailDAO.getNearInfo();
			if(overlist!=null) {
				SendMailDAO.SendNearNoticeMail(nearlist);
			}
			path="WEB-INF/view/administratorhome.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
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
