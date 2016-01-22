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
 * Servlet implementation class SauzenMetIngredientServlet
 */
@WebServlet("/sauzen/ingredient.htm")
public class SauzenMetIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzenmetingredient.jsp";
	
	@Resource(name = SausDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource){
		sausDAO.setDataSource(dataSource);
	}
	private final transient SausDAO sausDAO = new SausDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("ingredient") != null){
			if (request.getParameter("ingredient").length() > 0){
				request.setAttribute("sauzen", sausDAO.findWithIngredient(request.getParameter("ingredient")));
			}else{
				request.setAttribute("fout", "Verplicht in te vullen");
			}			
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
