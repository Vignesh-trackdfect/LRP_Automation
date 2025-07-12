package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Agency_Master_SC004  extends Keywords{
public void Agency_Master_SC004(WebDriver driver, ExtentTest test, ExtentTest test1,
		String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

	String testcase_Name = "TC_Agency_Master_SC004";
	
	String username = Excel_data.get("Username");
	String password = Excel_data.get("Password");
	String Agency_Master_Module  = Excel_data.get("Agency_Master_Module");
	String Agency_Details_Header  = Excel_data.get("Agency_Details_Header");
	String Condition  = Excel_data.get("Condition");
	String Agency_Details_Value  = Excel_data.get("Agency_Details_Value");
	String Port_Code_Header  = Excel_data.get("Port_Code_Header");
	String CheckBox_Input  = Excel_data.get("CheckBox_Input");
	
	
	Extent_Start(testcase_Name, test, test1);

	Step_Start(1, "Login & Open agency master screen", test, test1);

	navigateUrl(driver, url);
	LRP_Login(driver, username, password);
	verifyMainMenu(driver);
	moduleNavigate(driver, Agency_Master_Module );
	Step_End(1, "Login & Open agency master screen", test, test1);

	Step_Start(2, "Retrieve Office Agency from the scrreen", test, test1);

	waitForElement(driver, SearchButton_Toolbar);
	click(driver,SearchButton_Toolbar );
	globalValueSearchWindow(driver,Condition , Agency_Details_Header, Agency_Details_Value, "", "", "", "");
	Step_End(2, "Retrieve Office Agency from the scrreen", test, test1);

	Step_Start(3, "Navigate to Controlling Ports tab", test, test1);

	waitForElement(driver, Controlling_Ports_Tab);
	click(driver,Controlling_Ports_Tab );
	Step_End(3, "Navigate to Controlling Ports tab", test, test1);

	Step_Start(4, "Click on the Grid Settings Icon ,Click the Distinct Filter" , test, test1);
	waitForElement(driver, AM_ToolPanel);
	click(driver, AM_ToolPanel);
	waitForElement(driver, AM_Distinct_Filter_Template);
	click(driver, AM_Distinct_Filter_Template);
	Step_End(4, "Click on the Grid Settings Icon ,Click the Distinct Filter" , test, test1);
	
	Step_Start(5, "A dropdown or selection list will appear. Choose a column like PortCode", test, test1);
    formatLocatorClick(driver, Menu_Button, Port_Code_Header);
	
	waitForElement(driver, AM_Menu_Filter);
	click(driver, AM_Menu_Filter);
	
	waitForElement(driver, AM_Grid_Select_All_Check_Box);
	click(driver, AM_Grid_Select_All_Check_Box);	
	Step_End(5, "A dropdown or selection list will appear. Choose a column like PortCode", test, test1);

	Step_Start(6, "Apply the Filter", test, test1);
	waitForElement(driver, AM_Checkbox_Search);
	sendKeys(driver, AM_Checkbox_Search, CheckBox_Input);
	Step_End(6, "Apply the Filter", test, test1);

	
	Step_Start(7, "Check that the grid now only displays one row per unique value in the selected column", test, test1);

	
	String Head = String.format(AM_Grid_Col_Id, Port_Code_Header);
	String Column_Id =getAttribute(driver,Head , "col-id");
	
	formatLocatorClick(driver, AM_Grid_Select_Text_Value,CheckBox_Input);	
	
	waitForElement(driver, AM_Menu_Filter);
	click(driver, AM_Menu_Filter);
	
	String Record = getText(driver, AM_Total_Record_Count);

	
	String[] count = Record.split("of");
	
	int Record_Count = Integer.parseInt(count[0].trim());
	System.out.println("Record_Count: "+Record_Count);
	for (int i = 0; i < Record_Count; i++) {

		String GridHeader = String.format(AM_Select_Header, i, Column_Id);
		mouseOverToElement(driver, GridHeader);
		
		
        
		String Col_Text = getText(driver, GridHeader);

		if (Col_Text.equalsIgnoreCase(CheckBox_Input)) {
			System.out.println("Row No : "+i+" - Matched || Expected result is : The Grid displays the Unique value should be : "
					+ Col_Text + " || Actual result is : The Grid displays the Unique value is :" + CheckBox_Input);
			Extent_pass_New(driver,
					"Row No : "+i+" - Matched || Expected result is : The Grid displays the Unique value should be : " + Col_Text
							+ " || Actual result is : The Grid displays the Unique value is :" + CheckBox_Input,
					test, test1);
		} else {

			System.out.println("Row No : "+i+" - Not Matched || Expected result is : The Grid displays the Unique value should be : "
					+ Col_Text + " || Actual result is : The Grid displays the Unique value is not :" + CheckBox_Input);
			Extent_fail(driver,
					"Row No : "+i+" - Not Matched || Expected result is : The Grid displays the Unique value should be : " + Col_Text
							+ " || Actual result is : The Grid displays the Unique value is not :" + CheckBox_Input,
					test, test1);
		}
	}
	
	
	
	Step_End(7, "Check that the grid now only displays one row per unique value in the selected column", test, test1);
	
	Extent_completed(testcase_Name, test, test1);

}
}