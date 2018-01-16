package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectMysql;
import dao.Dri1;
import dao.Driver;

public class DriverService {
	//获取从start到pagesize的数据
	public List getDriverInfoList(int start,int pagesize){
		List<Driver> list = new ArrayList<Driver>();
		String sql = "select * from driverinfo";
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
				Driver driver = new Driver();
				driver.setId(rs.getInt("id"));
				driver.setName(rs.getString("name"));
				driver.setSex(rs.getString("sex"));
				driver.setAge(rs.getInt("age"));
				driver.setIdCard(rs.getString("idCard"));
				driver.setDriverNum(rs.getString("driverNum"));
				driver.setEducation(rs.getString("education"));
				driver.setTel(rs.getString("tel"));
				driver.setPhone(rs.getString("phone"));
				driver.setAddress(rs.getString("address"));
				driver.setHireTime(rs.getString("hireTime"));
				driver.setStartTime(rs.getString("startTime"));
				list.add(driver);
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
	//获取所有数据
	public List getAllDriverInfoList(){
		List<Driver> list = new ArrayList<Driver>();
		String sql = "select * from driverinfo";
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next() != false){
				Driver driver = new Driver();
				driver.setId(rs.getInt("id"));
				driver.setName(rs.getString("name"));
				driver.setSex(rs.getString("sex"));
				driver.setAge(rs.getInt("age"));
				driver.setIdCard(rs.getString("idCard"));
				driver.setDriverNum(rs.getString("driverNum"));
				driver.setEducation(rs.getString("education"));
				driver.setTel(rs.getString("tel"));
				driver.setPhone(rs.getString("phone"));
				driver.setAddress(rs.getString("address"));
				driver.setHireTime(rs.getString("hireTime"));
				driver.setStartTime(rs.getString("startTime"));
				list.add(driver);
			}
			if(list.get(0).getName() == ""){
				return null;
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
	//添加 Driver对象
	public void addDri(Driver d){
//		String sql = "insert into driverinfo(id,name,sex,age,idCard,driverNum,education,tel,phone,address,hireTime,startTime) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		Statement sta = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			int i = 0;
			//找最大的id值
			ResultSet rs = sta.executeQuery("select max(id) from driverinfo");
			while(rs.next()){
				i = rs.getInt(1);
			}
			//更新主键为i值
			sta.execute("alter table driverinfo AUTO_INCREMENT=" + i);
			ps = conn.prepareStatement("insert into driverinfo(name,sex,age,idCard,driverNum,education,tel,phone,address,hireTime,startTime) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, d.getName());
			ps.setString(2, d.getSex());
			ps.setInt(3, d.getAge());
			ps.setString(4, d.getIdCard());
			ps.setString(5, d.getDriverNum());
			ps.setString(6, d.getEducation());
			ps.setString(7, d.getTel());
			ps.setString(8, d.getPhone());
			ps.setString(9, d.getAddress());
			ps.setString(10, d.getHireTime());
			ps.setString(11, d.getStartTime());
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
	//删除主键为id的数据
	public void delDri(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("delete from driverinfo where id=" + id);
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
	//查找主键为id的数据
	public Driver searchDir(int id){
		Driver driver = new Driver();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select * from driverinfo where id=" + id);
			rs = ps.executeQuery();
			while(rs.next()){
				driver.setId(rs.getInt("id"));
				driver.setName(rs.getString("name"));
				driver.setSex(rs.getString("sex"));
				driver.setAge(rs.getInt("age"));
				driver.setIdCard(rs.getString("idCard"));
				driver.setDriverNum(rs.getString("driverNum"));
				driver.setEducation(rs.getString("education"));
				driver.setTel(rs.getString("tel"));
				driver.setPhone(rs.getString("phone"));
				driver.setAddress(rs.getString("address"));
				driver.setHireTime(rs.getString("hireTime"));
				driver.setStartTime(rs.getString("startTime"));
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
		return driver;
	}
	//更新对象d的数据
	public void updateDir(Driver d){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("update driverinfo set name=?,sex=?,age=?,idCard=?,driverNum=?,education=?,tel=?,phone=?,address=?,hireTime=?,startTime=? where id=?");
			ps.setString(1, d.getName());
			ps.setString(2, d.getSex());
			ps.setInt(3, d.getAge());
			ps.setString(4, d.getIdCard());
			ps.setString(5, d.getDriverNum());
			ps.setString(6, d.getEducation());
			ps.setString(7, d.getTel());
			ps.setString(8, d.getPhone());
			ps.setString(9, d.getAddress());
			ps.setString(10, d.getHireTime());
			ps.setString(11, d.getStartTime());
			ps.setInt(12, d.getId());
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
	//获取表driverinfo中的数据条数
	public int getCount(){
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 1;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select count(*) from driverinfo");
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
	//查找指定name的数据
	public Driver searchByName(String name){
		Driver driver = new Driver();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select * from driverinfo where name=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				driver.setId(rs.getInt("id"));
				driver.setName(rs.getString("name"));
				driver.setSex(rs.getString("sex"));
				driver.setAge(rs.getInt("age"));
				driver.setIdCard(rs.getString("idCard"));
				driver.setDriverNum(rs.getString("driverNum"));
				driver.setEducation(rs.getString("education"));
				driver.setTel(rs.getString("tel"));
				driver.setPhone(rs.getString("phone"));
				driver.setAddress(rs.getString("address"));
				driver.setHireTime(rs.getString("hireTime"));
				driver.setStartTime(rs.getString("startTime"));
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
		return driver;
	}
	//获取只包含id和name的所有数据
	public List getCarOwnerList(){
		List<Dri1> list = new ArrayList<Dri1>();
		String sql = "select id,name from driverinfo";
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next() != false){
				Dri1 dri = new Dri1();
				dri.setName(rs.getString("name"));
				list.add(dri);
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
}