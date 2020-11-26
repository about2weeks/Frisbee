package login;

public class AccountVo {
	
	private String empno;
	private String storeNo;
	private String storeName;
	private String name;
	private String rank;
	private String email;
	private String phone;
	private String sal;
	private String start;
	private String end;
	private String superC;
	private String superN;
	
	private String rowNum;
	
	//private Image
	
	public AccountVo(String empno, String storeNo,String storeName, String name, String rank) {
		this.empno = empno;
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.name = name;
		this.rank = rank;
	}
	
	public AccountVo(String name, String rank, String phone, String email, String superC, String sal, String start, String end, String superN) {
		this.name = name;
		this.rank = rank;
		this.phone = phone;
		this.email = email;
		this.superC = superC;
		this.sal = sal;
		this.start = start;
		this.end = end;
		this.superN = superN;
	}
	
	public AccountVo(String empNo, String empName, String rank, String StartDate, String phone, String rowNum) {
		this.empno = empNo;
		this.name = empName;
		this.rank = rank;
		this.start = StartDate;
		this.phone = phone;
		this.rowNum = rowNum;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getSal() {
		return sal;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getSuperC() {
		return superC;
	}

	public String getSuperN() {
		return superN;
	}

	public AccountVo() {
		
	}
	
	public String getEmpno() {
		return empno;
	}
	
	public String getStoreNo() {
		return storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getName() {
		return name;
	}
	public String getRank() {
		return rank;
	}

	public String getRowNum() {
		return rowNum;
	}

	
	

	
	
	
}
