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
 * Servlet implementation class SauzenVerwijderenServlet
 */
@WebServlet("/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REDIRECT_URL = "%s/sauzen.htm";
	@Resource(name = SausDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource){
		sausDAO.setDataSource(dataSource);
	}
	private final transient SausDAO sausDAO = new SausDAO();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] nummersAlsString = request.getParameterValues("nummer");
		if (nummersAlsString != null){
			for (String nummer:nummersAlsString){
				sausDAO.removeById(Long.parseLong(nummer));	
			}			
		}
		response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
	}

}
