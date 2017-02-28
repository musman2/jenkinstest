package ExternalLinktng;

import java.util.ArrayList;
import java.util.List;

public class ReportSheet {
	private String date;
	private int totalCases;
	private int passedCases;
	private int failedCases;
	private int skipCases;
	private String moduleName;
	
	
	public ReportSheet(){}
	
	public List<ReportRow> rows = new ArrayList<ReportRow>();
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalCases() {
		return totalCases;
	}
	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}
	public int getPassedCases() {
		return passedCases;
	}
	public void setPassedCases(int passedCases) {
		this.passedCases = passedCases;
	}
	public int getFailedCases() {
		return failedCases;
	}
	public void setFailedCases(int failedCases) {
		this.failedCases = failedCases;
	}
	public int getSkipCases() {
		return skipCases;
	}
	public void setSkipCases(int skipCases) {
		this.skipCases = skipCases;
	}
	public List<ReportRow> getRows() {
		return rows;
	}
	public void setRows(List<ReportRow> rows) {
		this.rows = rows;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
}
