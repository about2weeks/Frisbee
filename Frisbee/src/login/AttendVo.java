package login;

public class AttendVo {
	
	
	private String AttendTime;
	private String empNo;
	private String empName;
	private String StartTime;
	private String EndTime;
	private String WholeTime;
	private String StoreNo;
	
	private String rowNum;
	
	public AttendVo(String empName, String AttendTime, String StartTime, String EndTime, String WholeTime, String rowNum) {
		this.empName = empName;
		this.AttendTime = AttendTime;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.WholeTime = WholeTime;
		this.rowNum = rowNum;
	}
	
	public AttendVo(String AttendTime, String StartTime, String EndTime, String WholeTime, String rowNum) {
		this.AttendTime = AttendTime;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.WholeTime = WholeTime;
		this.rowNum = rowNum;
	}
	
	
	
	
	
	public String getAttendTime() {
		return AttendTime;
	}
	public String getEmpno() {
		return empNo;
	}
	public String getStartTime() {
		return StartTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public String getWholeTime() {
		return WholeTime;
	}
	public String getStoreNo() {
		return StoreNo;
	}

	public String getRowNum() {
		return rowNum;
	}

	public String getEmpName() {
		return empName;
	}
	
	
	
}
