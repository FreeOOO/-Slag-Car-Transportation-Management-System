//CustomerService类
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Customer;
import dao.ConnectMysql;

public class CustomerService {
	//获取从start到pagesize的数据
	public List getCustomerInfoList(int start,int pagesize){
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from customerinfo";
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);//查找数据库，并把结果放入ResultSet中
			rs.absolute(start);//定位start条数据
			//循环读pagesize条数据，存入链表中
			for(int i = 0;i < pagesize;i++){
				Customer customer = new Customer();
				customer.setCustomerNum(rs.getInt("customerNum"));
				customer.setName(rs.getString("name"));
				customer.setCompany(rs.getString("company"));
				customer.setPhone(rs.getString("phone"));
				customer.setOrdersContent(rs.getString("ordersContent"));
				customer.setIndustry(rs.getString("industry"));
				customer.setCredit(rs.getString("credit"));
				customer.setEmail(rs.getString("email"));
				customer.setUnitWebsite(rs.getString("unitWebsite"));
				customer.setTransactions(rs.getInt("transactions"));
				customer.setTransactionAmount(rs.getInt("transactionAmount"));
				customer.setFirstTransaction(rs.getString("firstTransaction"));
				customer.setRecentTransactions(rs.getString("recentTransactions"));
				list.add(customer);
				if(rs.next() == false){
					break;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ConnectMysql.closeSta(sta);
				ConnectMysql.closeRs(rs);
				ConnectMysql.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//添加 customer对象
	public void addCustomer(Customer c){
		Connection conn = null;
		Statement sta = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			int i = 0;
			//找最大的customerNum
			ResultSet rs = sta.executeQuery("select max(customerNum) from customerinfo");
			while(rs.next()){
				i = rs.getInt(1);
			}
			//更新主键为i值
			sta.execute("alter table customerinfo AUTO_INCREMENT=" + i);
			ps = conn.prepareStatement("insert into customerinfo(name ,company ,phone ,ordersContent ,industry ,credit ,email ,unitWebsite ,transactions ,transactionAmount ,firstTransaction ,recentTransactions) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getCompany());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getOrdersContent());
			ps.setString(5, c.getIndustry());
			ps.setString(6, c.getCredit());
			ps.setString(7, c.getEmail());
			ps.setString(8, c.getUnitWebsite());
			ps.setInt(9, c.getTransactions());
			ps.setInt(10, c.getTransactionAmount());
			ps.setString(11, c.getFirstTransaction());
			ps.setString(12, c.getRecentTransactions());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ConnectMysql.closeSta(ps);
				ConnectMysql.closeSta(sta);
				ConnectMysql.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//删除主键为customerNum的数据
	public void delCustomer(int customerNum){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("delete from customerinfo where customerNum=" + customerNum);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ConnectMysql.closeSta(ps);
				ConnectMysql.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//查找主键为customerNum的数据
	public Customer searchCustomer(int customerNum){
		Customer customer = new Customer();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select * from customerinfo where customerNum=" + customerNum);
			rs = ps.executeQuery();
			while(rs.next()){
				customer.setCustomerNum(rs.getInt("customerNum"));
				customer.setName(rs.getString("name"));
				customer.setCompany(rs.getString("company"));
				customer.setPhone(rs.getString("phone"));
				customer.setOrdersContent(rs.getString("ordersContent"));
				customer.setIndustry(rs.getString("industry"));
				customer.setCredit(rs.getString("credit"));
				customer.setEmail(rs.getString("email"));
				customer.setUnitWebsite(rs.getString("unitWebsite"));
				customer.setTransactions(rs.getInt("transactions"));
				customer.setTransactionAmount(rs.getInt("transactionAmount"));
				customer.setFirstTransaction(rs.getString("firstTransaction"));
				customer.setRecentTransactions(rs.getString("recentTransactions"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ConnectMysql.closeSta(ps);
				ConnectMysql.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}
	//更新对象c的数据
	public void updateCustomer(Customer c){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("update customerinfo set name=? ,company=? ,phone=? ,ordersContent=? ,industry=? ,credit=? ,email=? ,unitWebsite=? ,transactions=? ,transactionAmount=? ,firstTransaction=? ,recentTransactions=? where customerNum=?");
			ps.setString(1, c.getName());
			ps.setString(2, c.getCompany());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getOrdersContent());
			ps.setString(5, c.getIndustry());
			ps.setString(6, c.getCredit());
			ps.setString(7, c.getEmail());
			ps.setString(8, c.getUnitWebsite());
			ps.setInt(9, c.getTransactions());
			ps.setInt(10, c.getTransactionAmount());
			ps.setString(11, c.getFirstTransaction());
			ps.setString(12, c.getRecentTransactions());
			ps.setInt(13, c.getCustomerNum());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ConnectMysql.closeSta(ps);
				ConnectMysql.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//获取表customerinfo中的数据条数
	public int getCount(){
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 1;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select count(*) from customerinfo");
			rs = ps.executeQuery();
			while(rs.next())
				count = rs.getInt(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
