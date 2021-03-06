package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarService;
import dao.Car;

/**
 * Servlet implementation class ShowAllCarInfo
 */
public class ShowAllCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllCarInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		List<Car> list = new ArrayList<Car>();
		CarService service = new CarService();
		int count = service.getCount();		//总条数
		int pagesize = 10;			//每页条数
		int pagecount = 1;			//总页数
		int page = 1;			//页码
		String strpage = request.getParameter("page");
		if(strpage != null && !strpage.equals("")){
			page = Integer.parseInt(strpage);
		}
		if(count % pagesize != 0){
			pagecount = count / pagesize + 1;
		}else{
			pagecount = count / pagesize;
		}
		if(page <= 1){
			page = 1;
		}if(page > pagecount){
			page = pagecount;
		}
		int start = (page - 1) * pagesize + 1;
		list = service.getCarInfoList(start,pagesize);
		request.setAttribute("count", count);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("page", page);
		request.setAttribute("infolist", list);
		request.getRequestDispatcher("ShowAllCar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
