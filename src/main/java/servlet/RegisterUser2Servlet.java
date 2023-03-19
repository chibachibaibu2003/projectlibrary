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

/**
 * Servlet implementation class RegisterUser2Servlet
 */
@WebServlet("/RegisterUser2Servlet")
public class RegisterUser2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String button=request.getParameter("button");
		if(button==null||email.length()<5 ) {
			String view = "WEB-INF/view/registerUser_1st.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else{
			String subject="本人確認用URL";
			String urlStr="http://localhost:8080/projectlibrary/RegisterUser3Servlet?email=";
			String url=urlStr.concat(email);
			String text="""
					こちらのURLにアクセスし、新規登録の手続きをお願いします。
					""";
			URL URL=new URL(url);
			libraryDAO.sendMail(email, subject,text, URL);
			String path="WEB-INF/view/registerUser_2nd.jsp";
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
