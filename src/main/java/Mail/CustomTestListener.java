package Mail;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import atu.testng.reports.ATUReports;
import commonMethods.Keywords;
import commonMethods.Testcases;
import commonMethods.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomTestListener extends Keywords implements ITestListener{

	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

	String mailID = Utils.getDataFromTestConfig("Receiver");
	String reportname = Utils.getDataFromTestConfig("Name");
	String Mail_Header = Utils.getDataFromTestConfig("Team_Header");
	private int totalTests = 0;
	private int passedTests = 0;
	private int failedTests = 0;
	private List<String> passedTestNames = new ArrayList<>();
	private List<String> failedTestNames = new ArrayList<>();
	private List<String> failedreason = new ArrayList<>();

	@Override
	public void onTestStart(ITestResult result) {
//		totalTests++;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		passedTests++;
		passedTestNames.add(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		failedTests++;
		failedTestNames.add(result.getName());
		failedreason=Keywords.global;
		System.out.println( Keywords.serverStatus);
		if( Keywords.serverStatus == false) {
			StringBuilder emailContent = new StringBuilder();
			emailContent.append("<div style=\"font-family: Arial, sans-serif; text-align: center;\">"); // Center align content and set font-family
			emailContent.append("<h2 style=\"color: #34568B;\">"+ reportname +" "+Mail_Header+" - ").append(timeStamp).append("</h2>");
			emailContent.append("</div>");
			emailContent.append("<br>");
			emailContent.append("<table style=\"border-collapse: collapse; width: 80%; margin: auto;\">"); // Table with 80% width and centered
			emailContent.append("<tr>");
			emailContent.append("<th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Testcases</th>");
			emailContent.append("<th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Count</th>");
			emailContent.append("</tr>");

			emailContent.append("<tr>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>Total No of Executed</b></td>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+totalTests+"</b>").append("</td>");
			emailContent.append("</tr>");

			emailContent.append("<tr>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>No of Passed Cases</b></td>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+passedTests+"</b>").append("</td>");
			emailContent.append("</tr>");

			emailContent.append("<tr>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>No of Failed Cases</b></td>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+failedTests+"</b>").append("</td>");
			emailContent.append("</tr>");
			emailContent.append("</table>");

			emailContent.append("<br>");
			emailContent.append("<table style=\"border-collapse: collapse; width: 80%; margin: auto;\">"); // Table with 80% width and centered

			if (!passedTestNames.isEmpty() || !failedTestNames.isEmpty() || !Testcases.passedDatasets.isEmpty() || !Testcases.failedDatasets.isEmpty()) {
				emailContent.append("<tr>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Testcases Names</b></td>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Status (OR) Reason for Failure</b></td>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Description</b></td>");
				emailContent.append("</tr>");

				for (int i = 0; i < Testcases.passedDatasets.size(); i++) {
					emailContent.append("<tr>");
					emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: left; padding: 8px;\">").append(Testcases.passedDatasets.get(i)).append("</td>");
					emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: left; padding: 8px;\">").append("Passed").append("</td>");
					emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: center; padding: 8px;\">").append(Testcases.Passed_Mail_Description.get(i)).append("</td>");
					emailContent.append("</tr>");

				}

				// Append failed datasets
				for (int i = 0; i < Testcases.failedDatasets.size(); i++) {
					emailContent.append("<tr>");
					emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: left; padding: 8px;\">").append(Testcases.failedDatasets.get(i)).append("</td>");
					emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: left; padding: 8px;\">").append(failedreason.get(i)).append("</td>");
					emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: center; padding: 8px;\">").append(Testcases.failed_Mail_Description.get(i)).append("</td>");
					emailContent.append("</tr>");
				}

			}
			emailContent.append("</table>");
			emailContent.append("</div>");

			// Send email with the content
			try {
				if(Testcases.Doc_Option.equalsIgnoreCase("Yes")) {
					EmailSender.sendTestSummaryEmail(mailID, "❌❌❌ "+Mail_Header+" - " + timeStamp, emailContent.toString(),ATUReports.path,Testcases.logpath);
				}else {
					EmailSender.sendTestSummaryEmail(mailID, "❌❌❌ "+Mail_Header+" - " + timeStamp, emailContent.toString(),ATUReports.path);	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.exit(1);
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext context) {
		// You can access the totalTests, passedTests, failedTests, and failedTestNames here
		StringBuilder emailContent = new StringBuilder();
		emailContent.append("<div style=\"font-family: Arial, sans-serif; text-align: center;\">"); // Center align content and set font-family
		emailContent.append("<h2 style=\"color: #34568B;\">"+ reportname +" "+Mail_Header+" - ").append(timeStamp).append("</h2>");
		emailContent.append("</div>");
		emailContent.append("<br>");
		emailContent.append("<table style=\"border-collapse: collapse; width: 80%; margin: auto;\">"); // Table with 80% width and centered
		emailContent.append("<tr>");
		emailContent.append("<th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Testcases</th>");
		emailContent.append("<th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Count</th>");
		emailContent.append("</tr>");

		emailContent.append("<tr>");
		emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>Total No of Executed</b></td>");
		emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+Testcases.totalCount+"</b>").append("</td>");
		emailContent.append("</tr>");

		emailContent.append("<tr>");
		emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>No of Passed Cases</b></td>");
		emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+Testcases.passCount+"</b>").append("</td>");
		emailContent.append("</tr>");

		emailContent.append("<tr>");
		emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>No of Failed Cases</b></td>");
		emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+Testcases.failCount+"</b>").append("</td>");
		emailContent.append("</tr>");
		emailContent.append("</table>");

		emailContent.append("<br>");
		emailContent.append("<table style=\"border-collapse: collapse; width: 80%; margin: auto;\">"); // Table with 80% width and centered

		if (!passedTestNames.isEmpty() || !failedTestNames.isEmpty() || !Testcases.passedDatasets.isEmpty() || !Testcases.failedDatasets.isEmpty()) {
			emailContent.append("<tr>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Testcases Names</b></td>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Status (OR) Reason for Failure</b></td>");
			emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Description</b></td>");
			emailContent.append("</tr>");
			for (int i = 0; i < Testcases.passedDatasets.size(); i++) {
				emailContent.append("<tr>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: left; padding: 8px;\">").append(Testcases.passedDatasets.get(i)).append("</td>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: left; padding: 8px;\">").append("Passed").append("</td>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: center; padding: 8px;\">").append(Testcases.Passed_Mail_Description.get(i)).append("</td>");
				emailContent.append("</tr>");
			}
			// Append failed datasets
			for (int i = 0; i < Testcases.failedDatasets.size(); i++) {
				emailContent.append("<tr>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: left; padding: 8px;\">").append(Testcases.failedDatasets.get(i)).append("</td>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: left; padding: 8px;\">").append(failedreason.get(i)).append("</td>");
				emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: center; padding: 8px;\">").append(Testcases.failed_Mail_Description.get(i)).append("</td>");
				emailContent.append("</tr>");
			}
		}
		emailContent.append("</table>");
		emailContent.append("</div>");

		// Send email with the content
		try {
			wait(driver, "5");
			
			if(Testcases.failedDatasets.size()==0) {
				if(Testcases.Doc_Option.equalsIgnoreCase("Yes")) {
					EmailSender.sendTestSummaryEmail(mailID, "✅✅✅"+Mail_Header+" - " + timeStamp, emailContent.toString(),ATUReports.path,Testcases.logpath);
				}else {
					EmailSender.sendTestSummaryEmail(mailID, "✅✅✅"+Mail_Header+" - " + timeStamp, emailContent.toString(),ATUReports.path);	
				}
			}else {
				if(Testcases.Doc_Option.equalsIgnoreCase("Yes")) {
					EmailSender.sendTestSummaryEmail(mailID, "❌❌❌ "+Mail_Header+" - " + timeStamp, emailContent.toString(),ATUReports.path,Testcases.logpath);
				}else {
					EmailSender.sendTestSummaryEmail(mailID, "❌❌❌ "+Mail_Header+" - " + timeStamp, emailContent.toString(),ATUReports.path);	
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	@Override
	public void onStart(ITestContext context) {
	}
}

