package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarService;
import dao.Car;

/**
 * Servlet implementation class AddCar
 */
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Car car = new Car();
		//获取页面传递的值
		car.setCarType(request.getParameter("carType"));
		car.setDriver(request.getParameter("driver"));
		car.setCarNum(request.getParameter("carNum"));
		car.setIdentificationNum(request.getParameter("identificationNum"));
		car.setEngines(request.getParameter("engines"));
		car.setTariff(request.getParameter("tariff"));
		car.setInsurance(request.getParameter("insurance"));
		car.setInsuranceNum(request.getParameter("insuranceNum"));
		car.setInsuranceTime(request.getParameter("scnf1") + "~" + request.getParameter("scnf2"));
		car.setMaintainTime(request.getParameter("scnf3"));
		CarService service = new CarService();
		service.addCar(car);
		//转到ShowAllCarInfo界面
		request.getRequestDispatcher("ShowAllCarInfo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
