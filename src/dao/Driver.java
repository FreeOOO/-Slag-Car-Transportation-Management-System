package dao;

public class Driver {
	private int id; // 工号
	private String name; // 姓名
	private String sex; // 性别
	private int age; // 年龄
	private String idCard; // 身份证号
	private String driverNum; // 驾驶证号
	private String education; // 文化程度
	private String tel; // 固话
	private String phone; // 手机
	private String address; // 住址
	private String hireTime; // 进公司时间
	private String startTime; // 合同起始日期

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getDriverNum() {
		return driverNum;
	}

	public String getEducation() {
		return education;
	}

	public String getHireTime() {
		return hireTime;
	}

	public int getId() {
		return id;
	}

	public String getIdCard() {
		return idCard;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getSex() {
		return sex;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getTel() {
		return tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setHireTime(String hireTime) {
		this.hireTime = hireTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
