//CarService��
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Car;
import dao.ConnectMysql;

public class CarService {
	//��ȡ��start��pagesize������
	public List getCarInfoList(int start,int pagesize){
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from carinfo";
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
				Car car = new Car();
				car.setCarNo(rs.getInt("carNo"));
				car.setCarType(rs.getString("carType"));
				car.setDriver(rs.getString("driver"));
				car.setCarNum(rs.getString("carNum"));
				car.setIdentificationNum(rs.getString("identificationNum"));
				car.setEngines(rs.getString("engines"));
				car.setTariff(rs.getString("tariff"));
				car.setInsurance(rs.getString("insurance"));
				car.setInsuranceNum(rs.getString("insuranceNum"));
				car.setInsuranceTime(rs.getString("insuranceTime"));
				car.setMaintainTime(rs.getString("maintainTime"));
				list.add(car);
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
	//���Car����
	public void addCar(Car c){
		Connection conn = null;
		Statement sta = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			sta = conn.createStatement();
			int i = 0;
			//�ҵ����ݿ�������carNo������ȡֵ��ֵ��i
			ResultSet rs = sta.executeQuery("select max(carNo) from carinfo");
			while(rs.next()){
				i = rs.getInt(1);
			}
			//����������Ϊiֵ
			sta.execute("alter table carinfo AUTO_INCREMENT=" + i);
			//��������
			ps = conn.prepareStatement("insert into carinfo(carType ,driver ,carNum ,identificationNum ,engines ,tariff ,insurance ,insuranceNum ,insuranceTime ,maintainTime) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getCarType());
			ps.setString(2, c.getDriver());
			ps.setString(3, c.getCarNum());
			ps.setString(4, c.getIdentificationNum());
			ps.setString(5, c.getEngines());
			ps.setString(6, c.getTariff());
			ps.setString(7, c.getInsurance());
			ps.setString(8, c.getInsuranceNum());
			ps.setString(9, c.getInsuranceTime());
			ps.setString(10, c.getMaintainTime());
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
	//ɾ������ΪcarNo�Ķ���
	public void delCar(int carNo){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("delete from carinfo where carNo=" + carNo);
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
	//��������ΪcarNo������
	public Car searchCar(int carNo){
		Car car = new Car();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select * from carinfo where carNo=" + carNo);
			rs = ps.executeQuery();
			while(rs.next()){
				car.setCarNo(rs.getInt("carNo"));
				car.setCarType(rs.getString("carType"));
				car.setDriver(rs.getString("driver"));
				car.setCarNum(rs.getString("carNum"));
				car.setIdentificationNum(rs.getString("identificationNum"));
				car.setEngines(rs.getString("engines"));
				car.setTariff(rs.getString("tariff"));
				car.setInsurance(rs.getString("insurance"));
				car.setInsuranceNum(rs.getString("insuranceNum"));
				car.setInsuranceTime(rs.getString("insuranceTime"));
				car.setMaintainTime(rs.getString("maintainTime"));
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
		return car;
	}
	//��������
	public void updateCar(Car c){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("update carinfo set carType=?,driver=?,carNum=?,identificationNum=?,engines=?,tariff=?,insurance=?,insuranceNum=?,insuranceTime=?,maintainTime=? where carNo=?");
			ps.setString(1, c.getCarType());
			ps.setString(2, c.getDriver());
			ps.setString(3, c.getCarNum());
			ps.setString(4, c.getIdentificationNum());
			ps.setString(5, c.getEngines());
			ps.setString(6, c.getTariff());
			ps.setString(7, c.getInsurance());
			ps.setString(8, c.getInsuranceNum());
			ps.setString(9, c.getInsuranceTime());
			ps.setString(10, c.getMaintainTime());
			ps.setInt(11, c.getCarNo());
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
	//��ȡ��carinfo����������
	public int getCount(){
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 1;
		try {
			conn = ConnectMysql.connectMysql();
			ps = conn.prepareStatement("select count(*) from carinfo");
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
