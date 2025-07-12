package atu.testng.reports;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.jsoup.Jsoup;

import com.aventstack.extentreports.ExtentTest;

import atu.testng.reports.excel.ExcelReports.ExcelChart1;
import atu.testng.reports.excel.ExcelStyler;

import java.io.FileOutputStream;
import java.util.*;
import com.aventstack.extentreports.model.Log;

public class ExcelReportGeneratorFull {

    static class TestStep {
        String S_No,description,status,time;
        public TestStep(String S_No,String description,String status,String time) {
        	this.S_No = S_No;this.description = description;this.status = status;this.time = time;
        }
    }

    static class TestCase {
        String S_No,name, status,Description,Duration ;
        List<TestStep> steps = new ArrayList<>();
        public TestCase(String S_No,String name,String status, String Description,String Duration) {
        	this.S_No = S_No;this.name = name;this.status = status; this.Description = Description; this.Duration=Duration;
        }
    }
    public static void generateExcelReportFull(List<ExtentTest> extentTests, String filePath,Map<String,String> testDataValues,Map<String,String> UrlValues) throws Exception {
    	
    	XSSFWorkbook workbook = new XSSFWorkbook();
        List<TestCase> testCases = getMockData(extentTests);

        // Test Summary Sheet
        XSSFSheet summarySheet = workbook.createSheet("Test Summary");
        createSummarySheet(summarySheet, testCases, workbook);

        // Test Case List Sheet
        XSSFSheet caseListSheet = workbook.createSheet("Test Case List");
        createTestCaseList(workbook,caseListSheet, testCases,testDataValues,UrlValues);

//        // Individual Test Case Sheets
//        int k=1;
//        for (TestCase tc : testCases) {
//            XSSFSheet sheet = workbook.createSheet("SheetName_"+k);
//            createStepDescriptionSheet(workbook,sheet, tc);
//            k++;
//        }

        // Write to file
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        out.close();
        workbook.close();
        System.out.println("Excel report generated successfully.");
    	
    }

    private static List<TestCase> getMockData(List<ExtentTest> extentTests) {
        List<TestCase> cases = new ArrayList<>();

        int TC=1;
        for (ExtentTest test : extentTests) {
            String name = test.getModel().getName();
            String status = test.getModel().getStatus().toString(); // status is an enum
            String rawDescription = Optional.ofNullable(test.getModel().getDescription()).orElse("");
            String description = Jsoup.parse(rawDescription).text(); 
            
            Date startTime = test.getModel().getStartTime();
            Date endTime = test.getModel().getEndTime();
            long duration = endTime.getTime() - startTime.getTime();
            String Timeduration=convertMillisToMinutesString(duration);
            String TC_No=String.valueOf(TC);
            
            TestCase tc = new TestCase(TC_No,name, status,description,Timeduration);

            // Steps
            List<Log> logs = test.getModel().getLogs();
            int Step=1;
            for (Log log : logs) {
            	String stepNo=String.valueOf(Step);
            	String stepDetails=log.getDetails();
            	String stepDescription = Jsoup.parse(stepDetails).text(); 
            	String stepStatus=log.getStatus().toString();
            	String stepTime=log.getTimestamp().toString();
            	tc.steps.add(new TestStep(stepNo, stepDescription, stepStatus,stepTime));
                Step++;
            }
            cases.add(tc);
            TC++;
        }

        return cases;
    }

    
    private static void createSummarySheet(XSSFSheet sheet, List<TestCase> cases, XSSFWorkbook workbook) {
        int total = cases.size();
        int passed = (int) cases.stream().filter(tc -> tc.status.equalsIgnoreCase("Pass")).count();
        int failed = total - passed;

        Row row = sheet.createRow(0);
        Cell cell=row.createCell(0);
        cell.setCellValue("Total Test Cases");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(0);
        cell=row.createCell(1);
        cell.setCellValue(total);
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        
        row = sheet.createRow(1);
        cell=row.createCell(0);
        cell.setCellValue("Test Cases Passed");
        ExcelStyler.setResultCellStyle(workbook, cell, 1);
        cell=row.createCell(1);
        cell.setCellValue(passed);
        ExcelStyler.setResultCellStyle(workbook, cell, 1);
        
        
        row = sheet.createRow(2);
        cell=row.createCell(0);
        cell.setCellValue("Test Cases Failed");
        ExcelStyler.setResultCellStyle(workbook, cell, 2);
        cell=row.createCell(1);
        cell.setCellValue(failed);
        ExcelStyler.setResultCellStyle(workbook, cell, 2);
        
        row = sheet.createRow(3);
        cell=row.createCell(0);
        cell.setCellValue("Test Cases Skipped");
        ExcelStyler.setResultCellStyle(workbook, cell, 3);
        cell=row.createCell(1);
        cell.setCellValue("0");
        ExcelStyler.setResultCellStyle(workbook, cell, 3);
                
        byte[] arrayOfByte = ExcelChart1.writeChartToExcel(passed, failed, 0);
		int i = workbook.addPicture(arrayOfByte, 6);
		CreationHelper localCreationHelper = workbook.getCreationHelper();
		Drawing localDrawing = sheet.createDrawingPatriarch();
		ClientAnchor localClientAnchor = localCreationHelper.createClientAnchor();
		localClientAnchor.setCol1(0);
		localClientAnchor.setRow1(6);
		Picture localPicture = localDrawing.createPicture(localClientAnchor, i);
		localPicture.resize();
        
    }

    private static void createTestCaseList(XSSFWorkbook workbook,XSSFSheet sheet, List<TestCase> cases,Map<String,String> testDataValues,Map<String,String> UrlValues) {
        Row header = sheet.createRow(0);
        Cell cell=header.createCell(0);
        cell.setCellValue("S_No");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(0);
        
        cell=header.createCell(1);
        cell.setCellValue("Test Case");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(1);
        
        cell=header.createCell(2);
        cell.setCellValue("Status");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(2);
        
        cell=header.createCell(3);
        cell.setCellValue("Description");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(3);
        
        cell=header.createCell(4);
        cell.setCellValue("Test Data Used");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(4);
        
        cell=header.createCell(5);
        cell.setCellValue("Environment");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(5);
        
        cell=header.createCell(6);
        cell.setCellValue("Time Taken");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(6);
        
        int rowIndex = 1;
        for (TestCase tc : cases) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(tc.S_No);
            row.createCell(1).setCellValue(tc.name);
            sheet.autoSizeColumn(1);
            Cell cel=row.createCell(2);
            cel.setCellValue(tc.status);
            int styleStatus=1;
            if(tc.status.contains("Fail")||tc.status.contains("fail")) {
            	styleStatus=2;
            }
            ExcelStyler.setResultCellStyle(workbook, cel, styleStatus);
            row.createCell(3).setCellValue(tc.Description);
            
            String testdata=testDataValues.get(tc.name);
            String Url=UrlValues.get(tc.name);
            row.createCell(4).setCellValue(testdata);
            row.createCell(5).setCellValue(Url);
            row.createCell(6).setCellValue(tc.Duration);
        }
    }

    private static void createStepDescriptionSheet(XSSFWorkbook workbook,XSSFSheet sheet, TestCase testCase) {
        Row header = sheet.createRow(0);
        Cell cell=header.createCell(0);
        cell.setCellValue("S_No");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(0);
        
        cell=header.createCell(1);
        cell.setCellValue("Step Description");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(1);
        
        cell=header.createCell(2);
        cell.setCellValue("Status");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(2);
        
        cell=header.createCell(3);
        cell.setCellValue("Time Taken");
        ExcelStyler.setHeaderCellStyle(workbook, cell);
        sheet.autoSizeColumn(3);
        
        int rowIndex = 1;
        for (TestStep step : testCase.steps) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(step.S_No);
            row.createCell(1).setCellValue(step.description);
            row.createCell(2).setCellValue(step.status);
            row.createCell(3).setCellValue(step.time);
        }
    }
    public static String convertMillisToMinutesString(long millis) {
        double minutes = millis / 60000.0; // Convert to minutes with fraction
        return String.format("%.1f min", minutes); // One decimal place
    }
    public static String convertMillisToSecondsString(long millis) {
        double seconds = millis / 1000.0; // Convert to seconds
        return String.format("%.1f sec", seconds); // One decimal place
    }
    
}