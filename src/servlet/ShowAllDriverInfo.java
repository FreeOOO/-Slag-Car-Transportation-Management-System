package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DriverService;
import dao.Driver;

/**
 * Servlet implementation class ShowAllDriverInfo
 */
public class ShowAllDriverInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllDriverInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		List<Driver> list = new ArrayList<Driver>();
		DriverService service = new DriverService();
		int count = service.getCount();		//总条数
		int pagesize = 10;			//每页条数
		int pagecount = 1;			//总页数
		int page = 1;			//页码
		int flag = 0;
		String strpage = request.getParameter("page");
		if(strpage != null && !strpage.equals("")){
			page = Integer.parseInt(strpage);
		}
		//计算总页数
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
		//计算从第几条开始
		int start = (page - 1) * pagesize + 1;
		list = service.getDriverInfoList(start,pagesize);
		request.setAttribute("count", count);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("page", page);
		request.setAttribute("infolist", list);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher("ShowAllDriver.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
