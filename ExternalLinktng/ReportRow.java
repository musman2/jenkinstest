package ExternalLinktng;

public class ReportRow {
	private String caseName;
	private String status;
	private String startTime;
	private String endTime;
	private String exception;

	public ReportRow(){}
	public ReportRow(String caseName, String status, String startTime,
			String endTime, String exception, String moduleName) {
		super();
		this.caseName = caseName;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.exception = exception;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	
}
