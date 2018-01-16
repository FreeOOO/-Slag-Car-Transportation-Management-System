package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DriverService;

/**
 * Servlet implementation class DelDriver
 */
public class DelDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelDriver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		DriverService service = new DriverService();
		int page = Integer.parseInt(request.getParameter("page"));
		if (request.getParameter("id") != null) {
			service.delDri(Integer.parseInt(request.getParameter("id")));
		}
		if (request.getParameterValues("checkbox0") != null) {
			String[] s = request.getParameterValues("checkbox0");
			for (int i = 0; i < s.length; i++) {
				service.delDri(Integer.parseInt(s[i]));
			}
		}
		request.getRequestDispatcher("ShowAllDriverInfo?page=" + page).forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
