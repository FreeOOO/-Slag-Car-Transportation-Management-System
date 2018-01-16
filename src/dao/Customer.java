package dao;

public class Customer {
	private int customerNum;  //�ͻ����
	private String name;  //�ͻ�����
	private String company;  //������˾
	private String phone;  //��ϵ��ʽ
	private String ordersContent;  //��������
	private String industry;  //������ҵ
	private String credit;  //����״��
	private String email;  //�����ʼ�
	private String unitWebsite;  //��λ��ַ
	private int transactions;  //���״���
	private int transactionAmount;  //���׽��
	private String firstTransaction;  //�״ν���
	private String recentTransactions;  //�������
	public String getCompany() {
		return company;
	}
	public String getCredit() {
		return credit;
	}
	public int getCustomerNum() {
		return customerNum;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstTransaction() {
		return firstTransaction;
	}
	public String getIndustry() {
		return industry;
	}
	public String getName() {
		return name;
	}
	public String getOrdersContent() {
		return ordersContent;
	}
	public String getPhone() {
		return phone;
	}
	public String getRecentTransactions() {
		return recentTransactions;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public int getTransactions() {
		return transactions;
	}
	public String getUnitWebsite() {
		return unitWebsite;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstTransaction(String firstTransaction) {
		this.firstTransaction = firstTransaction;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrdersContent(String ordersContent) {
		this.ordersContent = ordersContent;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRecentTransactions(String recentTransactions) {
		this.recentTransactions = recentTransactions;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public void setTransactions(int transactions) {
		this.transactions = transactions;
	}
	public void setUnitWebsite(String unitWebsite) {
		this.unitWebsite = unitWebsite;
	}
}
