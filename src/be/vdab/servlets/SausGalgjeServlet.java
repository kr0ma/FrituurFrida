package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.SausGalgjeSpel;

/**
 * Servlet implementation class SausGalgjeServlet
 */
@WebServlet("/sausraden.htm")
public class SausGalgjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sausGalgje.jsp";
	private static final String SPEL = "spel";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute(SPEL) == null){			
			session.setAttribute(SPEL, new SausGalgjeSpel());			
		}		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (request.getParameter("nieuwspel") != null ){
			session.removeAttribute(SPEL);
		} else{
			if (request.getParameter("letter").length() > 0){
				char letter = request.getParameter("letter").charAt(0);
				SausGalgjeSpel spel = (SausGalgjeSpel) session.getAttribute(SPEL);
				spel.valideerLetter(letter);	
				session.setAttribute(SPEL, spel);
			}			
		}		
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

}
