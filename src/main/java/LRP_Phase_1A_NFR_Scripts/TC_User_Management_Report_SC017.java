package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC017 extends Keywords {

	public void User_Management_Report_SC017(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_User_Management_Report_SC017";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");

		 Extent_Start(testCaseName, test, test1);
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

		Step_End(3, "Click on show button to display the data", test, test1);

		Step_Start(4, "Sort LoginName column alphabetically, or UserType in descending order", test, test1);

		waitForElement(driver, UMR_Main_Filter_Option);
		click(driver, UMR_Main_Filter_Option);
		
		String UserType_Value = getText(driver, UMS_UserType_First_Row);
		System.out.println("Before Arranging the order, UserType_Value in first row is :"+UserType_Value);

     	waitForElement(driver, UMS_UserType_Header);
		doubleClick(driver, UMS_UserType_Header);
		
		String UserType_Value1 = getText(driver, UMS_UserType_First_Row);
		System.out.println("After Arranged to Descending order, UserType_Value in first row is :"+UserType_Value1);
		
		
		if (!UserType_Value.equals(UserType_Value1)) {
			
			System.out.println("Matched || Excepted :The Default order of UserType column, the value is :"+UserType_Value+ "|| Actual : UserType column is changed to descending order, the value is :" +UserType_Value1);
			 Extent_pass_New(driver,"Matched || Excepted : The Default order of UserType column, the value is :"+UserType_Value+"|| Actual : UserType column is changed to descending order, the value is :" +UserType_Value1, test, test1);
			
		} else {
			System.out.println("NotMatched || Excepted :The Default order of UserType column, the value is :"+UserType_Value+ "|| Actual : UserType column is changed to descending order, the value is :" +UserType_Value1);
			 Extent_fail(driver,"NotMatched || Excepted : The Default order of UserType column, the value is :"+UserType_Value+"|| Actual : UserType column is changed to descending order, the value is :" +UserType_Value1, test, test1);
			
		}
		
		Step_End(4, "Sort LoginName column alphabetically, or UserType in descending order", test, test1);

		Step_Start(5, "Open the settings menu and click the “Reset” icon.", test, test1);

		
		waitForElement(driver, UMS_Grid_ToolBar);
		click(driver, UMS_Grid_ToolBar);
		
    	waitForElement(driver, UMS_Grid_Reset_Btn);
		click(driver, UMS_Grid_Reset_Btn);
		
		Step_End(5, "Open the settings menu and click the “Reset” icon.", test, test1);

		Step_Start(6, "All filters should be cleared.Column order should return to default", test, test1);

		String UserType_Value2 = getText(driver, UMS_UserType_First_Row);
		System.out.println("UserType_Value in first row is :"+UserType_Value2);
		
		if (UserType_Value.equals(UserType_Value2)) {
			
			System.out.println("Matched || Excepted : Before Filtering ,the column in default order And  UserType value In First row is :" +UserType_Value+ " Actual || After clicking Reset Button,the column changes to default order ,and the UserType value in First row is : " +UserType_Value2);
			Extent_pass_New(driver, "Matched || Excepted : Before Filtering ,the column in default order And  UserType value In First row is :" +UserType_Value+ " Actual || After clicking Reset Button,the column changes to default order ,and the UserType value in First row is : " +UserType_Value2, test, test1);
			
		} else {

			System.out.println("NotMatched || Excepted : Before Filtering ,the column in default order And  UserType value In First row is :" +UserType_Value+ " Actual || After clicking Reset Button,the column changes to default order ,and the UserType value in First row is : " +UserType_Value2);
			Extent_fail(driver, "NotMatched || Excepted : Before Filtering ,the column in default order And  UserType value In First row is :" +UserType_Value+ " Actual || After clicking Reset Button,the column changes to default order ,and the UserType value in First row is : " +UserType_Value2, test, test1);
			
		}
		
		
		Step_End(6, "All filters should be cleared.Column order should return to default", test, test1);
       
		Extent_completed(testCaseName, test, test1);
	}
}