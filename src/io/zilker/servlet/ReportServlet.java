package io.zilker.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.zilker.application.UserInterface;
import io.zilker.bean.StaffDetails;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/reportservlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(session.getAttribute("staff")==null) {
			RequestDispatcher dispatcher =request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			}
			else if(request.getParameter("id")==null) {
				RequestDispatcher dispatcher =request.getRequestDispatcher("jsps/hod.jsp");
				dispatcher.forward(request, response);
				
			}
	

		else  {
			 if(request.getParameter("id").equals("delete")) {
				response.getWriter().print(UserInterface.personalReportDelete(request, (StaffDetails) session.getAttribute("staff")));
			}
			else if(request.getParameter("id").equals("edit")) {
				response.getWriter().print(UserInterface.personalReportEdit(request, (StaffDetails) session.getAttribute("staff")));		
			}
			
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
