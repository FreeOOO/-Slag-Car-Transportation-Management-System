package dao;

public class Car {
	private int carNo; // ���
	private String carNum; // ���ƺ�
	private String driver; // ����������
	private String carType;// ��������
	private String identificationNum; // ����ʶ�����
	private String engines; // ��������
	private String tariff; // ����˰˰��
	private String insurance; // ��������
	private String insuranceNum; // ���պ�
	private String insuranceTime; // ������ʼ����
	private String maintainTime; // ����ʱ��

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