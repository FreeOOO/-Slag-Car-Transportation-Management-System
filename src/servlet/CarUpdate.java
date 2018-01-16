package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarService;
import service.DriverService;
import dao.Car;
import dao.Dri1;

/**
 * Servlet implementation class CarUpdate
 */
public class CarUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		CarService service = new CarService();
		Car car = service.searchCar(carNo);
		request.setAttribute("Car", car);
		DriverService serviced = new DriverService();
		List<Dri1> list = serviced.getCarOwnerList();
		request.setAttribute("DriList", list);
		request.getRequestDispatcher("UpdateCar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
