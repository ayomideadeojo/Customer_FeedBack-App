package ca.sheridancollege.controllers;

import java.io.IOException;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import ca.sheridancollege.beans.Feedback;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
   
	public ControllerServlet() {
        super();
        
        dao.populateFeedback();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Feedback feed = new Feedback();
		feed = (Feedback) request.getAttribute("feed");
		dao.insertFeedback(feed);
		List<Feedback> feedbackList = dao.queryFeedbackbydate(LocalDate.now().with(firstDayOfMonth()));
		
		request.setAttribute("feedbackList", feedbackList);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String department = request.getParameter("department");
		String feedback = request.getParameter("feedback");
		
		Feedback feed = new Feedback(department,feedback);
		feed.setDate(LocalDate.now());
		request.setAttribute("feed", feed);
		
		doGet(request,response);
	}

}
