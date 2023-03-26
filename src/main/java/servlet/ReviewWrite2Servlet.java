package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.libraryDAO;
import dto.account;
import dto.review;

/**
 * Servlet implementation class ReviewWrite2Servlet
 */
@WebServlet("/ReviewWrite2Servlet")
public class ReviewWrite2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWrite2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path="";
		String pointStr=request.getParameter("option");
		int point=Integer.parseInt(pointStr);
		String title=request.getParameter("title");
		String comment=request.getParameter("comment");
		
		HttpSession session=request.getSession();
		account user=(account)session.getAttribute("info");
		String isbn=(String)session.getAttribute("reviewSelectisbn");
		if(pointStr==null||title==null||comment==null||isbn==null) {
			path="WEB-INF/view/home_after.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			return;
		}
		LocalDate currentDate=LocalDate.now();
		String date=String.valueOf(currentDate);
		review info=new review(0,point,title,comment,user.getId(),isbn,date);
		int result=libraryDAO.ReviewWrite(info);
		
		path="WEB-INF/view/mypage.jsp";
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
