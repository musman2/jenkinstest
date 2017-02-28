package ExternalLinktng;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import ExternalLinktng.ReportRow;
import ExternalLinktng.ReportSheet;

public class CustomReporter implements IReporter {
	private PrintWriter mOut;
	int passed;
	int skipped;
	int failed;
	String cssColorStart;
	String cssColorEnd;
	
	List<String> rowsHTML = new ArrayList<>();
	List<String> summaryHTML = new ArrayList<>();

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		new File(outputDirectory).mkdirs();
		try {
			mOut = new PrintWriter(new BufferedWriter(new FileWriter(new File(
					outputDirectory, "/Users/admin/Desktop/Test-output/Qlue-custom-report.html"))));
		} catch (IOException e) {
			System.out.println("Error in creating writer: " + e);
		}
		
		passed = 0;
		skipped = 0;
		failed = 0;
		
		List<ReportSheet> listSheets = new ArrayList<ReportSheet>();		

		for (ISuite suite : suites) {			
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			
			
			for(String caseKey : suiteResults.keySet()){	
				ReportSheet reportSheet = new ReportSheet();

				reportSheet.setModuleName(suite.getName());
				reportSheet.setDate(new Date().toGMTString());
				
				ISuiteResult testCase = suiteResults.get(caseKey);
				
				IResultMap failedResult = testCase.getTestContext().getFailedTests();
				Set<ITestResult> testsFailed = failedResult.getAllResults();
				for (ITestResult testResult : testsFailed) {
					ReportRow report = new ReportRow();

					report.setCaseName(testResult.getName());
					report.setEndTime(testResult.getEndMillis()+"");
					report.setStartTime(testResult.getStartMillis()+"");
					String exception=testResult.getThrowable().toString();
					String exception1[]=exception.split("/n");
					exception=exception1[0];
					report.setException(exception+" ");
					report.setStatus("FAIL");
					failed++;
					cssColorStart="<font color='red'>";
					cssColorEnd="</font>";
					reportSheet.rows.add(report);
					
				}
				
				IResultMap passResult = testCase.getTestContext().getPassedTests();
				Set<ITestResult> testsPassed = passResult.getAllResults();
				for (ITestResult testResult : testsPassed) {
					ReportRow report = new ReportRow();

					report.setCaseName(testResult.getName());
					report.setEndTime(testResult.getEndMillis()+"");
					report.setStartTime(testResult.getStartMillis()+"");
					report.setException("No Exception");
					report.setStatus("PASS");
					passed++;
					cssColorStart="<font color='green'>";
					cssColorEnd="</font>";
					reportSheet.rows.add(report);
 
				}
				
				IResultMap skippedResult = testCase.getTestContext().getSkippedTests();
				Set<ITestResult> testsSkipped = skippedResult.getAllResults();
				for (ITestResult testResult : testsSkipped) {
					ReportRow report = new ReportRow();

					report.setCaseName(testResult.getName());
					report.setEndTime(testResult.getEndMillis()+"");
					report.setStartTime(testResult.getStartMillis()+"");
					String exception=testResult.getThrowable().toString();
					String exception1[]=exception.split("/n");
					exception=exception1[0];
					report.setException(exception+" ");
					report.setStatus("SKIPPED");
					skipped ++;
					cssColorStart="<font color='yellow'>";
					cssColorEnd="</font>";
					reportSheet.rows.add(report);
				}		
				
				listSheets.add(reportSheet);
			}
			
		}	
		
		String reportHTML =
				printHTML(listSheets);
		mOut.print(reportHTML);
	    mOut.flush();
	    mOut.close();
	}
	
	//#dbdbdb  for color
	String printHTML(List<ReportSheet> suits){
		
		String tableHTML=""

	  		  +	"<tr>"
			  + 	"<td width=\"150px\" style=\"background-color: #6859DD;\"style=\"border-collapse: collapse\"> "
			 /* + 		"<table>"*/
						  +"Module Name"
			 /* + 		"</table>"*/
			  + 	"</td>"
			  + 	"<td>"
			  + 		"<table border=1 cellspacing=0 style=\"width:100%;table-layout: fixed;word-wrap:break-word\" style=\"border-collapse: collapse\">"
			  				+ "<tr style=\"background-color: #6699FF;\">"
							  + "<td width='40%' style=\"border-style: solid' 'border-width: 1px;\" >TestCase Description</td>"
							  + "<td width='60px'style=\"border-style: solid' 'border-width: 1px;\" >Result</td>"
							  + "<td width='150px'style=\"border-style: solid' 'border-width: 1px;\" >Start Time</td>"
							  + "<td width='150px'style=\"border-style: solid' 'border-width: 1px;\" >End Time</td>"
							  + "<td style=\"border-style: solid' 'border-width: 1px;\" >Exception</td>"
							+ "</tr>"
			  + 		"</table>"
			  + 	"</td>"
			  + "</tr>";
		for(ReportSheet sheet : suits){
			String rowsHTML="<table cellspacing=0 border=1 style=\"width:100%;table-layout: fixed;word-wrap:break-word\" style=\"border-collapse: collapse\">";
			for(ReportRow row : sheet.rows){
				
				rowsHTML += 
					    "<tr class='test'>"
					    + "<td width='40%'style=\"border-style: solid' 'border-width: 1px;\">"+row.getCaseName()+ "</td> "
					    + "<td width='60px'style=\"border-style: solid' 'border-width: 1px;\">"/*+cssColorStart*/ +row.getStatus()+  /*cssColorEnd+*/"</td>	"
					    + "<td width='150px'style=\"border-style: solid' 'border-width: 1px;\">" +row.getStartTime()+ "</td>	"
					    + "<td width='150px'style=\"border-style: solid' 'border-width: 1px;\">" +row.getEndTime()+ "</td>		"
					    + "<td style=\"border-style: solid' 'border-width: 1px;\">" +row.getException()+ "</td>  "
					  + "</tr>";				
			}
			rowsHTML+="</table>";
			
			tableHTML +=
							   "<tr>"
								  + "<td style=\"border-style: solid' 'border-width: 1px;\">"+sheet.getModuleName()+"</td>"
								  + "<td style=\"border-style: solid' 'border-width: 1px;\">"+rowsHTML+"</td>"
							  + "</tr>";
		}
		String html1 =
				
				  "<html>"
				  + "<head>"
				  + "<title>Custom-Emailable-Report</title>"
				/*  +"<script type='text/javascript'> </script>"
				  +"<script type='text/javascript' src='../src/com/qlue/login/test.js'></script>"*/
				  +"<script type='text/javascript'>"
				  +"function myColors(){"
				  +"var td = document.getElementsByTagName('td');"
				  +"var i = 0, tds = td.length;"
				  +"for (i; i < tds; i++) {"
				  +"if (td[i].innerHTML == 'SKIPPED') {"
					        +"td[i].setAttribute('style', 'background:yellow;');}"
					    +"if (td[i].innerHTML == 'FAIL') {"
					        +"td[i].setAttribute('style', 'background:red;');}"
					    +"if (td[i].innerHTML == 'PASS') {"
					        +"td[i].setAttribute('style', 'background:green;');}"
					+"}}" + "</script>"
				  + "</head>"
				  
				  + "<body bgcolor=#F2F2F4 onload='myColors();'>"
				  + "<center> <h2>Qlue Scripts Execution Summary<h2></center>"
				  + "<h3><u>Summary</u></h3>"
				  + "<h5>Date : "+new Date()+"</h5>"
				  + "<h5>Total cases : "+(passed+failed+skipped)+"</h5>"
				  + "<h5>Passed cases : <font color='green'>"+passed+"</font></h5>"
				  + "<h5>Failed cases : <font color='red'>"+failed+"</font></h5>"
				  + "<h5>Skipped cases: <font color='violet'>"+skipped+"</font></h5>"
				  + "</br>" 
				  + "</br>" 
				  + "<table border=1 cellspacing=0 style=\"width:100%;table-layout: fixed;word-wrap:break-word\" style=\"border-collapse: collapse\">" 
				  		+tableHTML
				  + "</table>"
				  +"<script type='text/javascript'>"
				  + "</script>"
				  + "</body>"
				+ "</html>";
		
		return html1;
		
	}


}