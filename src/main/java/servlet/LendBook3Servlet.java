package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.bookDAO;
import dto.account;
import dto.lendbook;

/**
 * Servlet implementation class LendBook3Servlet
 */
@WebServlet("/LendBook3Servlet")
public class LendBook3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendBook3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		account ac = (account) session.getAttribute("account");
		
		int userid = ac.getId();
		String idb = request.getParameter("id");
		int bookid = Integer.parseInt(idb);
		LocalDate lenddate = LocalDate.now();
		String lend_date = lenddate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int brand = bookDAO.getbrand(bookid);
		LocalDate delaydate = bookDAO.getdelaydate(brand);
		String delay_date = delaydate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String returndate = null;
		lendbook lend = new lendbook(0, lend_date, returndate, delay_date, userid, bookid);
		int result = bookDAO.Rendbook(lend);
		String path = "";
		
		if(result==1) {
			path="WEB-INF/view/lendbook_success.jsp";
		}else {
			path="WEB-INF/view/lendbook_2nd.jsp";
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
