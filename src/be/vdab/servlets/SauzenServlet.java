package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.dao.SausDAO;

/**
 * Servlet implementation class SauzenServlet
 */
@WebServlet("/sauzen.htm")
public class SauzenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
	@Resource(name = SausDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource){
		sausDAO.setDataSource(dataSource);
	}
	private final transient SausDAO sausDAO = new SausDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		List<Saus> sauzen = new ArrayList<>();	
		sauzen.add(new Saus(1L, "cocktail", Arrays.asList("cock","tail","ketchup","mayonaise")));		
		sauzen.add(new Saus(1L, "mayonaise", Arrays.asList("mayo","naise", "citroen")));
		sauzen.add(new Saus(1L, "mosterd", Arrays.asList("mos","terd")));
		sauzen.add(new Saus(1L, "tartare", Arrays.asList("tar","tare")));
		sauzen.add(new Saus(1L, "vinaigrette", Arrays.asList("vinaigr","ette")));		
		*/
		
		request.setAttribute("sauzen", sausDAO.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}


}
