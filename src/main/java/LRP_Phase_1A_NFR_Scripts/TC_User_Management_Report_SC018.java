package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC018 extends Keywords {

	public void User_Management_Report_SC018(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC018";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String Grid_Headers_Input = Excel_data.get("Grid_Headers_Input");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open user management report screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Report_Module);

		Step_End(1, "Login & open user management report screen.", test, test1);

		Step_Start(2, "Retrieve data by using User Option (By all)", test, test1);

		waitForElement(driver, UMR_User_Option_drop_down);
		click(driver, UMR_User_Option_drop_down);
		formatLocatorClick(driver, DropDown_Select, User_Option);

		waitForElement(driver, UMR_User_Name_Button);
		click(driver, UMR_User_Name_Button);

		twoColumnSearchWindow(driver, User_Name_Header, Dropdown_Condition, User_Name_Input);

		Step_End(2, "Retrieve data by using User Option (By all)", test, test1);

		Step_Start(3, "Click on show button to display the data", test, test1);

		waitForElement(driver, UMR_Show_Button);
		click(driver, UMR_Show_Button);

		
		waitForElement(driver, UMR_Login_Name_Filter_button);
		click(driver, UMR_Login_Name_Filter_button);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		waitForElement(driver, UMR_Grid_Select_All_Check_Box);
		click(driver, UMR_Grid_Select_All_Check_Box);

		waitForElement(driver, UMR_Grid_Header_Input_Field);
		sendKeys(driver, UMR_Grid_Header_Input_Field, Grid_Headers_Input);//

		formatLocatorClick(driver, UMR_Grid_Select_Text_Value, Grid_Headers_Input);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		Step_End(3, "Click on show button to display the data", test, test1);

		Step_Start(4, "Filter or sort the grid to simulate a user exporting a specific view.", test, test1);

		Step_Start(5, "Click the “Excel” Export Icon", test, test1);
		
		
		String Total_count = getText(driver, UMR_Total_Records);
		String[] Record = Total_count.split("of");
		
		int Total_record_count = Integer.parseInt(Record[0].trim());
		System.out.println("Total record count after filtered by expiry : "+ Total_record_count);
		
		List<String> expiryStatuses = new ArrayList<>();
		
		for(int i=0; i<Total_record_count; i++) {
			
			String expiry_col = String.format(UMR_Status, i);
			mouseOverToElement(driver, expiry_col);
			scrollToElement(driver, expiry_col);
			String ExpirestatusSelect = getText(driver, expiry_col);
			expiryStatuses.add(ExpirestatusSelect);
			
		}
		String expireStatusSelect = String.join(", ", expiryStatuses);
		System.out.println("All expiry statuses: " + expireStatusSelect);
		
		scrollTop(driver);
		
		waitForElement(driver, UMR_Main_Filter_Option);
		click(driver, UMR_Main_Filter_Option);

		
		
        String filePath = downloadFile(driver, UMR_Excel_Button);
	    
		Step_End(5, "Click the “Excel” Export Icon", test, test1);
		
		Step_Start(6, "Make sure the file fully downloads.", test, test1);
		
		if (!filePath.equals("")) {
			System.out.println("After Clicking the file Name,The File should be downloaded : "
					+ filePath );
			Extent_pass(driver, "After Clicking the file Name,The File should be downloaded :" + filePath,
					test, test1);
 
		} else {
 
			System.out.println("After Clicking the file Name,The File is not downloaded " );
			Extent_fail(driver, "After Clicking the file Name,The File is not downloaded ",test, test1);
			
		}
		
		Step_End(6, "Make sure the file fully downloads.", test, test1);
		
//
		Step_Start(7, "Data in Excel file matches the grid view exactly: same rows, same columns, same values..", test,
				test1);
		 List<Map<String, String>> DownloadExcelrowcount = getAllExcelDatas1(filePath);
	       System.out.println("DownloadExcelrowcount : "+DownloadExcelrowcount);
	       List<String> actualExcelvalue = getValuesByHeader(DownloadExcelrowcount, "Status");
	       
	       System.out.println("actualExcelvalue : "+actualExcelvalue);
	    
			if (actualExcelvalue.equals(expiryStatuses)) {

				System.out.println("The Total Record of portpair grid Count And Download Excel row count || Expected The Total Record of portpair grid Count is : "
						+ expiryStatuses + " Actual After Downloading the Excel sheet Expire Status row count is : " + actualExcelvalue);
				Extent_pass(driver, "The Total Record of portpair grid Count And Download Excel row count || Expected The Total Record of portpair grid Count is : "
						+ expiryStatuses + " Actual After Downloading the Excel sheet Expire Status count is : " + actualExcelvalue, test, test1);
			} else {

				System.out.println("Some the Total Record of  portpair grid Count And Download Excel row count || Expected The Total Record of portpair grid Count is : "
						+ expiryStatuses + " Actual After Downloading the Excel sheet Expire Status row count is : " + actualExcelvalue);
				Extent_fail(driver, "Some the Total Record of  portpair grid Count And Download Excel row count || Expected The Total Record of portpair grid Count is : "
						+ expiryStatuses + " Actual After Downloading the Excel sheet Expire Statusrow count is : " + actualExcelvalue, test, test1);
			}
		
			Step_End(7, "Data in Excel file matches the grid view exactly: same rows, same columns, same values..", test,
					test1);
		
		Extent_completed(testcase_Name, test, test1);

	}
}