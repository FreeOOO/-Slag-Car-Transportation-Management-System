package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarService;

/**
 * Servlet implementation class DelCar
 */
public class DelCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		CarService service = new CarService();
		if(request.getParameter("carNo") != null){
			service.delCar(Integer.parseInt(request.getParameter("carNo")));
		}
		if(request.getParameterValues("checkbox0") != null){
			String []s = request.getParameterValues("checkbox0");
			for(int i = 0;i < s.length;i++){
				service.delCar((Integer.parseInt(s[i])));
			}
		}
		request.getRequestDispatcher("ShowAllCarInfo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
