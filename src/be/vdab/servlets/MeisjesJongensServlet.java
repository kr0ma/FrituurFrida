package be.vdab.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeisjesJongensServlet
 */
@WebServlet("/meisjesjongens.htm")
public class MeisjesJongensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/cookies.jsp";
	private static final int COOKIE_MAXIMUM_LEEFTIJD = 60 /* seconden */* 30 /* minuten */;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getCookies() != null){
			for (Cookie cookie : request.getCookies()){
				if ("meisjesjongens".equals(cookie.getName())){					
					request.setAttribute("classe", URLDecoder.decode(cookie.getValue(), "UTF-8"));		
					break;
				}
			}
		}		
		System.out.println(request.getAttribute("classe"));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Cookie meisjesJongens = 
				new Cookie("meisjesjongens", URLEncoder.encode(request.getParameter("meisjesjongens"),"UTF-8"));
		meisjesJongens.setMaxAge(COOKIE_MAXIMUM_LEEFTIJD);
		response.addCookie(meisjesJongens);
		response.sendRedirect(request.getRequestURI());
	}

}
