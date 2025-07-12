package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC016 extends Keywords {

	public void User_Management_Report_SC016(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC016";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String Login_Name_Inputs = Excel_data.get("Login_Name_Inputs");

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

		Step_End(3, "Click on show button to display the data", test, test1);

		Step_Start(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);

		waitForElement(driver, UMR_Main_Filter_Option);
		click(driver, UMR_Main_Filter_Option);

		waitForElement(driver, UMR_Multiple_Filter);
		click(driver, UMR_Multiple_Filter);

		Step_End(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);
		Step_Start(5, "Choose the \"Loginname\" column.Select the data from the grid, Click Apply or Enter to confirm",
				test, test1);

		List<String> Act_Row = splitAndExpand(Login_Name_Inputs);

		Actions action = new Actions(driver);

		action.keyDown(Keys.CONTROL).build().perform();
		String name="";

		for (int i = 0; i < Act_Row.size(); i++) {
			name=String.format(UMR_Login_Name_Rows, Act_Row.get(i));
			click(driver,name);

		}
		action.keyUp(Keys.CONTROL).build().perform();

		 Step_End(5, "Choose the \"Loginname\" column.Select the data from the grid, Click Apply or Enter to confirm",
					test, test1);
	        
	    	Step_Start(6, "Without resetting the previous filter, choose another column,eg:Usercode.Set the filter to \"AEESCD\" and apply i",
					test, test1);
		
        RightClick(driver, name);
		waitForElement(driver, UMR_Copy_Option);
		click(driver, UMR_Copy_Option);

		waitForElement(driver, UMR_Login_Name_Filter_button);
		click(driver, UMR_Login_Name_Filter_button);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		
		waitForElement(driver, UMR_Paste_Input_Field);
		doubleClick(driver, UMR_Paste_Input_Field);
		
		click(driver, UMR_Paste_Input_Field_Option);
		
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		enter(driver);
		
		
		 waitForElement(driver, UMR_Paste_Values_Row);
	 	 List<WebElement> listOfValues = listOfElements(driver, UMR_Paste_Values_Row);
          List<String> paste_Val=new ArrayList<String>();
	 	 
	 	 
	 	 for (int j = 0; j < listOfValues.size(); j++) {

	 	       String pasteGroupCode = getText1(driver, listOfValues.get(j)).trim();
	 	      paste_Val.add(pasteGroupCode);
	 	 }
		
		
		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);
		
		List<String> ActualValues=new ArrayList<String>();
		
		waitForElement(driver, UMR_Selected_Rows);
        List<WebElement> actRows=listOfElements(driver,UMR_Selected_Rows );
        
        for(WebElement Ele:actRows) {
        	
        	String val=Ele.getText();
        	ActualValues.add(val);
        }
        
        
    	Step_End(6, "Without resetting the previous filter, choose another column,eg:Usercode.Set the filter to \"AEESCD\" and apply i",
				test, test1); 
    	
    	Step_Start(7, "Verify grid should now only display rows where LoginName & User code",
				test, test1);
    	
   
      
 	   for (int j = 0; j < paste_Val.size(); j++) {


 	       if (Act_Row.get(j).equals(paste_Val.get(j))) {

 	           System.out.println("Expected || The copied value from the grid is: " + Act_Row.get(j) +
 	                              "  Actual || The value pasted in the grid column is: " + paste_Val.get(j));

 	           Extent_pass(driver,
 	                       "Expected || The copied value from the grid is: " + Act_Row.get(j) +
 	                       " Actual || The value pasted in the grid column is: " + paste_Val.get(j),
 	                       test, test1);

 	       } else {

 	           System.out.println("Not Expected || The copied value from the grid is: " + Act_Row.get(j) +
 	                              " Actual || The value pasted in the grid column is: " + paste_Val.get(j));

 	           Extent_fail(driver,
 	                       "Not Expected || The copied value from the grid is: " + Act_Row.get(j) +
 	                       " Actual || The value pasted in the grid column is: " + paste_Val.get(j),
 	                       test, test1);
 	       }
 	   }
   
   Step_End(7, "Verify grid should now only display rows where LoginName & User code",test, test1);	 
		 
   Extent_completed(testcase_Name, test, test1);
   

	}
}