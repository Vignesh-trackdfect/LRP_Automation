package LRP_Phase_1A_NFR_Scripts;


import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Agency_Master_SC006 extends Keywords{
	
	public void Agency_Master_SC006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

	
		String testcase_Name = "TC_Agency_Master_SC006";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Branch_Code = Excel_data.get("Branch_Code");
		String Port_Name_Inputs = Excel_data.get("Port_Name_Inputs");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		
		Step_Start(1, "Login & Open agency master screen.", test, test1);

		moduleNavigate(driver, Agency_Master_Module);
	
		Step_End(1, "Login & Open agency master screen.", test, test1);
		
		Step_Start(2, "Retrieve Office Agency from the scrreen.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,Search_Condition, Select_field, Branch_Code, "", "", "", "");
		
		Step_End(2, "Retrieve Office Agency from the scrreen.", test, test1);
		
		
        Step_Start(3, "Navigate to Controlling Ports tab.", test, test1);
		
        
		waitForElement(driver, AM_Controlling_Ports_Tab);
		click(driver, AM_Controlling_Ports_Tab);
		
		Step_End(3, "Navigate to Controlling Ports tab.", test, test1);
		
		Step_Start(4, "Find the icon that looks like it might do filtering but with a smug attitudeb.", test, test1);
		
		waitForElement(driver, AM_Click_For_More_Options);
		click(driver, AM_Click_For_More_Options);

		waitForElement(driver, AM_Multiple_Filter);
		click(driver, AM_Multiple_Filter);
				
	   Step_End(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);
	   
	   Step_Start(5, "Choose the 'Port name' column.", test, test1);
	   
		List<String> Act_Row = splitAndExpand(Port_Name_Inputs);

		Actions action = new Actions(driver);

		action.keyDown(Keys.CONTROL).build().perform();
		
		String PortNameSelect= "";

		for (int i = 0; i < Act_Row.size(); i++) {

			
			PortNameSelect = String.format(AM_Port_Name_Rows, Act_Row.get(i));
			click(driver, PortNameSelect);

		}
		action.keyUp(Keys.CONTROL).build().perform();
	      
		
	   Step_End(5, "Choose the 'Port name' column.", test, test1);
	   
	   Step_Start(6, "Without resetting the previous filter, choose another column,eg:Type.Set the filter to \"Export\" and apply it.", test, test1);
	   
	   RightClick(driver, PortNameSelect);
	   waitForElement(driver, AM_Copy_Option);
       click(driver, AM_Copy_Option);

		waitForElement(driver, AM_Login_Name_Filter_button);
		click(driver, AM_Login_Name_Filter_button);

		waitForElement(driver, AM_Filter_button);
		click(driver, AM_Filter_button);

		
		waitForElement(driver, AM_Paste_Input_Field);
		doubleClick(driver, AM_Paste_Input_Field);
		
		click(driver, AM_Paste_Input_Field);
		
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		enter(driver);
		       
	   
	   Step_End(6, "Without resetting the previous filter, choose another column,eg:Type.Set the filter to \"Export\" and apply it.", test, test1);
	   
	   
	   Step_Start(7, "Verify grid should now only display rows where Port name & Type.", test, test1);
	   
	   
	   waitForElement(driver, AM_Selected_Rows_Paste_Input_Field);
	   List<WebElement> listOfValues = listOfElements(driver, AM_Selected_Rows_Paste_Input_Field);

	   for (int j = 0; j < listOfValues.size(); j++) {

	       String pasteGroupCode = getText1(driver, listOfValues.get(j)).trim();

	       System.out.println("Pasted Value: " + pasteGroupCode);

	       if (Act_Row.get(j).equals(pasteGroupCode)) {

	           System.out.println("Expected || The copied value from the grid is: " + Act_Row.get(j) +
	                              "  Actual || The value pasted in the grid column is: " + pasteGroupCode);

	           Extent_pass(driver,
	                       "Expected || The copied value from the grid is: " + Act_Row.get(j) +
	                       " Actual || The value pasted in the grid column is: " + pasteGroupCode,
	                       test, test1);

	       } else {

	           System.out.println("Not Matched || Expected || The copied value from the grid is: " + Act_Row.get(j) +
	                              " Actual || The value pasted in the grid column is: " + pasteGroupCode);

	           Extent_fail(driver,
	                       "Not Matched || Expected || The copied value from the grid is: " + Act_Row.get(j) +
	                       " Actual || The value pasted in the grid column is: " + pasteGroupCode,
	                       test, test1);
	       }
	   }

	   
	   Step_End(7, "Verify grid should now only display rows where Port name & Type.", test, test1);
	   
	   Extent_completed(testcase_Name, test, test1);
	}

}
