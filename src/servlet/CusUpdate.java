package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;
import dao.Customer;

/**
 * Servlet implementation class CusUpdate
 */
public class CusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int customerNum = Integer.parseInt(request.getParameter("customerNum"));
		CustomerService service = new CustomerService();
		Customer customer = service.searchCustomer(customerNum);
		customer.setName(request.getParameter("name"));
		customer.setCompany(request.getParameter("company"));
		customer.setPhone(request.getParameter("phone"));
		customer.setOrdersContent(request.getParameter("ordersContent"));
		customer.setIndustry(request.getParameter("industry"));
		customer.setCredit(request.getParameter("credit"));
		customer.setEmail(request.getParameter("email"));
		customer.setUnitWebsite(request.getParameter("unitWebsite"));
		customer.setTransactions(Integer.parseInt(request.getParameter("transactions")));
		customer.setTransactionAmount(Integer.parseInt(request.getParameter("transactionAmount")));
		customer.setFirstTransaction(request.getParameter("firstTransaction"));
		customer.setRecentTransactions(request.getParameter("recentTransactions"));
		service.updateCustomer(customer);
		request.getRequestDispatcher("CustomerDetails?customerNum="+customerNum).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
