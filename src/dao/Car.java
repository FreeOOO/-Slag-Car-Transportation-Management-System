package dao;

public class Car {
	private int carNo; // 编号
	private String carNum; // 车牌号
	private String driver; // 车辆所有人
	private String carType;// 车辆类型
	private String identificationNum; // 车辆识别代号
	private String engines; // 发动机号
	private String tariff; // 购置税税号
	private String insurance; // 车辆保险
	private String insuranceNum; // 保险号
	private String insuranceTime; // 保险起始日期
	private String maintainTime; // 保养时间

	public String getCarType() {
		return carType;
	}

	public int getCarNo() {
		return carNo;
	}

	public String getCarNum() {
		return carNum;
	}

	public String getDriver() {
		return driver;
	}

	public String getEngines() {
		return engines;
	}

	public String getIdentificationNum() {
		return identificationNum;
	}

	public String getInsurance() {
		return insurance;
	}

	public String getInsuranceNum() {
		return insuranceNum;
	}

	public String getInsuranceTime() {
		return insuranceTime;
	}

	public String getMaintainTime() {
		return maintainTime;
	}

	public String getTariff() {
		return tariff;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setEngines(String engines) {
		this.engines = engines;
	}

	public void setIdentificationNum(String identificationNum) {
		this.identificationNum = identificationNum;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public void setInsuranceNum(String insuranceNum) {
		this.insuranceNum = insuranceNum;
	}

	public void setInsuranceTime(String insuranceTime) {
		this.insuranceTime = insuranceTime;
	}

	public void setMaintainTime(String maintainTime) {
		this.maintainTime = maintainTime;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

}