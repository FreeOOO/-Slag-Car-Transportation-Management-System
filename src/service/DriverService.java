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
	//��ȡ��start��pagesize������
	public List getDriverInfoList(int start,int pagesize){
		List<Driver> list = new ArrayList<Driver>();
		String sql = "select * from driverinfo";
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);//�������ݿ⣬���ѽ������ResultSet��
			rs.absolute(start);//��λstart������
			//ѭ����pagesize�����ݣ�����������
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
	//��ȡ��������
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
	//��� Driver����
	public void addDri(Driver d){
//		String sql = "insert into driverinfo(id,name,sex,age,idCard,driverNum,education,tel,phone,address,hireTime,startTime) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		Statement sta = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			int i = 0;
			//������idֵ
			ResultSet rs = sta.executeQuery("select max(id) from driverinfo");
			while(rs.next()){
				i = rs.getInt(1);
			}
			//��������Ϊiֵ
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
	//ɾ������Ϊid������
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
	//��������Ϊid������
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
	//���¶���d������
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
	//��ȡ��driverinfo�е���������
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
	//����ָ��name������
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
	//��ȡֻ����id��name����������
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