package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;
import dao.Customer;

/**
 * Servlet implementation class AddCustomer
 */
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Customer customer = new Customer();
		//获取页面传递的值
		customer.setName(request.getParameter("name"));
		customer.setCompany(request.getParameter("company"));
		customer.setPhone(request.getParameter("phone"));
		customer.setOrdersContent(request.getParameter("ordersContent"));
		customer.setIndustry(request.getParameter("industry"));
		customer.setCredit(request.getParameter("credit"));
		customer.setEmail(request.getParameter("email"));
		customer.setUnitWebsite(request.getParameter("unitWebsite"));
		if(!request.getParameter("transactions").equals("")){
			customer.setTransactions(Integer.parseInt(request.getParameter("transactions")));
		}
		if(!request.getParameter("transactionAmount").equals("")){
			customer.setTransactionAmount(Integer.parseInt(request.getParameter("transactionAmount")));
		}
		customer.setFirstTransaction(request.getParameter("firstTransaction"));
		customer.setRecentTransactions(request.getParameter("recentTransactions"));
		CustomerService service = new CustomerService();
		service.addCustomer(customer);
		//ShowAllCustomerInfo界面
		request.getRequestDispatcher("ShowAllCustomerInfo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
