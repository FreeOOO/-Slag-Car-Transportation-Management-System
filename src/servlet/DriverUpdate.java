package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DriverService;
import dao.Driver;

/**
 * Servlet implementation class DriverUpdate
 */
public class DriverUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");	
		int id = Integer.parseInt(request.getParameter("id"));
		DriverService service = new DriverService();
		Driver driver = service.searchDir(id);
		driver.setName(request.getParameter("name"));
		driver.setSex(request.getParameter("sex"));
		driver.setAge(Integer.parseInt(request.getParameter("age")));
		driver.setIdCard(request.getParameter("idCard"));
		driver.setDriverNum(request.getParameter("driverNum"));
		driver.setEducation(request.getParameter("education"));
		driver.setTel(request.getParameter("tel1") + "-" + request.getParameter("tel2"));
		driver.setPhone(request.getParameter("phone"));
		driver.setAddress(request.getParameter("address"));
		driver.setHireTime(request.getParameter("scnf1"));
		driver.setStartTime(request.getParameter("scnf2") + "~" + request.getParameter("scnf3"));
		service.updateDir(driver);
		request.getRequestDispatcher("DriDetails?id="+id).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
