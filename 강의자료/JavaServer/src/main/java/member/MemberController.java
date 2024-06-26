package member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mcontroller")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		
		
		MemberDAO dao;
		
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			dao = new MemberDAO();
		}
			
			protected void service(HttpSerlvetRequest req, HttpSerlvetResponse resp) throws ServletException
			String action = req.getParameter("action");
			String view= "";
		if(action == null) {
			getServletContext().getRequestDispatcher(view).forward(req, resp)
	}else {
			switch(action) {
			case "list": view = list(req, resp); break;
			case "insert": view = insert(req, resp);break;
			}
			getServletContext().getRequestDispatcher("/mcontrol?action=list").forward(req, resp);
		}
		
		
	}
	
	
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		req.setAtttibute("memberlist", dao.getAll());
		return "/memberinfo.jsp";
		
	}
	
	public String insert(HttpServletRequest req, HttpServletResponse resp) {
		Member m= new Member();
		m.setUsername(req.getParameter("username"));
		m.setCompany(req.getParameter("company"));
		m.setEmail(req.getParameter("email"));
		dao.insert(m);
		return list(req, resp);
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
