package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DriverService;
import sun.util.resources.CalendarData;
import dao.Driver;

/**
 * Servlet implementation class AddDriver
 */
public class AddDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Driver driver = new Driver();
		int page = Integer.parseInt(request.getParameter("page"));
		driver.setName(request.getParameter("name"));
		String idCard = request.getParameter("idCard");
		if(idCard.charAt(16) % 2 == 0){
			driver.setSex("女");
		}else{
			driver.setSex("男");
		}
		Calendar ca = Calendar.getInstance();
		int nowYear = ca.get(Calendar.YEAR);
		int oldYear = Integer.parseInt(idCard.substring(6, 10));//第7位到第10位
		driver.setAge(nowYear - oldYear + 1);
		driver.setIdCard(request.getParameter("idCard"));
		driver.setDriverNum(request.getParameter("driverNum"));
		if(request.getParameter("education").equals("1")){
			driver.setEducation("小学");
		}else if(request.getParameter("education").equals("2")){
			driver.setEducation("初中");
		}else if(request.getParameter("education").equals("3")){
			driver.setEducation("大学");
		}else{
			driver.setEducation("其他");
		}
		driver.setTel(request.getParameter("tel1") + "-" + request.getParameter("tel2"));
		driver.setPhone(request.getParameter("phone"));
		driver.setAddress(request.getParameter("address"));
		driver.setHireTime(request.getParameter("scnf1"));
		driver.setStartTime(request.getParameter("scnf2") + "~" + request.getParameter("scnf3"));
		DriverService service = new DriverService();
		service.addDri(driver);
		request.getRequestDispatcher("ShowAllDriverInfo?page=" + page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
