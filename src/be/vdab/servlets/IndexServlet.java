package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = "/index.htm", name ="indexservlet")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";	
	private final Adres adres = new Adres();
	
	/** replaced with init parameters
	public IndexServlet(){		
		adres.setHuisNr("12");
		adres.setStraat("PrinsesFridaStraat");
		
		Gemeente gemeente = new Gemeente();
		gemeente.setNaam("KingdomFrida");
		gemeente.setPostCode(9999);
		adres.setGemeente(gemeente);
	}
	*/
	@Override
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		adres.setStraat(context.getInitParameter("straat"));
		adres.setHuisNr(context.getInitParameter("huisNr"));
		Gemeente gemeente = new Gemeente();
		gemeente.setNaam(context.getInitParameter("gemeente"));
		gemeente.setPostCode(Integer.parseInt(context.getInitParameter("postCode")));
		adres.setGemeente(gemeente);		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("adres", adres);

		int dagVanDeWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		request.setAttribute("openGesloten",dagVanDeWeek == Calendar.MONDAY|| dagVanDeWeek == Calendar.FRIDAY ? "gesloten" : "open" );
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}
}
