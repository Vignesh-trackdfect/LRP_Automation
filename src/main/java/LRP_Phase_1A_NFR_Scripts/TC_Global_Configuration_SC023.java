package LRP_Phase_1A_NFR_Scripts;



import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;


import commonMethods.Keywords;

public class TC_Global_Configuration_SC023 extends Keywords {

	public void Global_Configuration_SC023(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Global_Configuration_SC023";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
		String Attribute_Name_Inputs= Excel_data.get("Attribute_Name_Inputs");
		
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open global configuration screen.", test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Global_Configuration_Module);

		Step_End(1, "Login & open global configuration screen.", test, test1);

		Step_Start(2, " Click the “Multiple Filter” Icon on tool bar header.", test, test1);

		waitForElement(driver, Global_Configuration_Multi_Filter_Btn);
		click(driver, Global_Configuration_Multi_Filter_Btn);
		
		

		Step_End(2, " Click the “Multiple Filter” Icon on tool bar header.", test, test1);

		Step_Start(3, "Find the icon that looks like it might do filtering but with a smug attitude", test, test1);

		Step_Start(4, ".Choose the Attribute column",test, test1);
		
		waitForElement(driver, Attribute_Filter_Option_Click);
		click(driver, Attribute_Filter_Option_Click);


		Step_End(3, "Find the icon that looks like it might do filtering but with a smug attitude", test, test1);

		 Step_End(4, ".Choose the Attribute column",test, test1);
		 
		 
		Step_Start(5,"Select the data from the grid,Click Apply or Enter to confirm.",test, test1);

		List<String> Act_Row = splitAndExpand(Attribute_Name_Inputs);

		Actions action = new Actions(driver);

		action.keyDown(Keys.CONTROL).build().perform();
		
		String Attribute_Name_Select="";

		for (int i = 0; i < Act_Row.size(); i++) {

			Attribute_Name_Select = String.format(Attribute_Column_Row, Act_Row.get(i));
			click(driver, Attribute_Name_Select);

		}
		action.keyUp(Keys.CONTROL).build().perform();

       
		
		Step_End(5,"Select the data from the grid,Click Apply or Enter to confirm.",test, test1);
		
		Step_Start(6, "Without resetting the previous filter, choose another column,eg:Type.Set the filter to CHAR and apply",
				test, test1);
	
	
	RightClick(driver, Attribute_Name_Select);
	waitForElement(driver, Attribute_Copy);
	click(driver, Attribute_Copy);
	

	waitForElement(driver, Attribute_Filter_Option_Click);
	click(driver, Attribute_Filter_Option_Click);
	
	waitForElement(driver, Attribute_Filter_Btn);
	click(driver, Attribute_Filter_Btn);

	
	waitForElement(driver, Attribute_Paste_Field);
	doubleClick(driver, Attribute_Paste_Field);
	
    click(driver, Attribute_Paste_Field);
	
	action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
	enter(driver);
	
	waitForElement(driver, Attribute_Filter_Btn);
	click(driver, Attribute_Filter_Btn);
	Step_End(5,"Select the data from the grid,Click Apply or Enter to confirm.",test, test1);
	
	Step_Start(6, "Without resetting the previous filter, choose another column,eg:Type.Set the filter to CHAR and apply",
			test, test1);
    
    RightClick(driver, Type_Row_Select);
    waitForElement(driver, Attribute_Copy);
	click(driver, Attribute_Copy);
	
	waitForElement(driver, Type_Filter_Option_Click);
	click(driver, Type_Filter_Option_Click);
	
	mouseOverToElement(driver, Attribute_Paste_Field);
	waitForElement(driver, Attribute_Paste_Field);
	doubleClick(driver, Attribute_Paste_Field);
	
    click(driver, Attribute_Paste_Field);
	
    action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
	enter(driver);
	
	waitForElement(driver, Attribute_Filter_Btn);
	click(driver, Attribute_Filter_Btn);
	
	waitForElement(driver, Type_Filter_Option_Click);
	click(driver, Type_Filter_Option_Click);
	
	waitForElement(driver, Filter_Clear);
	click(driver, Filter_Clear);
	
	waitForElement(driver, Type_Filter_Option_Click);
	doubleClick(driver, Type_Filter_Option_Click);
	
    
	Step_End(6, "Without resetting the previous filter, choose another column,eg:Type.Set the filter to CHAR and apply",
			test, test1);
	
	Step_Start(7, "Verify grid should now only display rows where Attribute & Type.", test, test1);
	
	java.util.List<WebElement> Pasted_elements = listOfElements(driver, Attribute_Paste_value);
	
	   for (int j = 0; j < Pasted_elements.size(); j++) {



	       String pastAttributeCode = getText1(driver, Pasted_elements.get(j));



	       System.out.println("Pasted Value: " +pastAttributeCode);



	       if (Act_Row.get(j).equals(pastAttributeCode)) {



	           System.out.println("Expected || The copied value from the grid is: " + Act_Row.get(j) +

	                              "  Actual || The value pasted in the grid column is: " + pastAttributeCode);



	           Extent_pass_New(driver,

	                       "Expected || The copied value from the grid is: " + Act_Row.get(j) +

	                       " Actual || The value pasted in the grid column is: " + pastAttributeCode,

	                       test, test1);



	       } else {



	           System.out.println("Not Expected || The copied value from the grid is: " + Act_Row.get(j) +

	                              " Actual || The value pasted in the grid column is: " + pastAttributeCode);



	           Extent_fail(driver,

	                       "Not Expected || The copied value from the grid is: " + Act_Row.get(j) +

	                       " Actual || The value pasted in the grid column is: " + pastAttributeCode,

	                       test, test1);
		
	}
	       
	   }
	   Step_End(7, "Verify grid should now only display rows where Attribute & Type.", test, test1);
	   
	   Extent_completed(testCaseName, test, test1);
}
}