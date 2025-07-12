package LRP_Manifest_Correction_Notes_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.*;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
public class TC_Manifest_Correction_Notes_SC08 extends Keywords {
	public void Manifest_Correction_Notes_SC08(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{
		String testcase_Name="TC_Manifest_Correction_Notes_SC08";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Print_Option_Select = Excel_data.get("Print_Option_Select");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String DropdownCondition = Excel_data.get("DropdownCondition");
		String BL_Number = Excel_data.get("BL_Number");
		String bl_Status = Excel_data.get("bl_Status");
		String FileName = Excel_data.get("FileName");
		String jnlp_Handling_Time = Excel_data.get("jnlp_Handling_Time");
		String BL_Original_Print_Colour = Excel_data.get("BL_Original_Print_Colour");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);
		Step_Start(2, "Open the Manifest Correction Notes module", test, test1);
		moduleNavigate(driver, Manifest_Module);
		Step_End(2, "Open the Manifest Correction Notes module", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,DropdownCondition,Select_Search_Type_MCN,BL_Number,"","","","");
		waitForElement(driver, BL_status);
		sendKeys(driver, BL_status, bl_Status);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		String Select_Print_Option = String.format(Print_Option_MCN,Print_Option_Select);
		waitForElement(driver, Select_Print_Option);
		checkBox(driver, Select_Print_Option, "Yes");
		String filePath = downloadJNLPFilePath(driver, MCN_Print);

		String javawsPath = Excel_data.get("javaws_Path");

		  try {
		        // Validate javaws.exe
		        File javawsFile = new File(javawsPath);
		        if (!javawsFile.exists()) {
		            System.out.println("javaws.exe not found: " + javawsPath);
		            return;
		        }

		        // Validate JNLP file
		        File file = new File(filePath);
		        if (!file.exists()) {
		            System.out.println("JNLP file does not exist: " + filePath);
		            return;
		        }

		        System.out.println("Launching JNLP file...");
		        ProcessBuilder processBuilder = new ProcessBuilder(javawsPath, filePath);
		        Process process = processBuilder.start();
		        Robot robo = new Robot();
		        System.out.println(".jnlp file launched successfully.");

		        
		        wait(driver,jnlp_Handling_Time);
		        Screen screen = new Screen();
		        Pattern runButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/run_Button.png").similar(0.8);
		        screen.wait(runButton, Integer.parseInt(jnlp_Handling_Time));
		        screen.click(runButton);
		        
		        Pattern startButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/fsv.png").similar(0.8);
		        screen.wait(startButton, Integer.parseInt(jnlp_Handling_Time));
		        screen.click(startButton);
		        Pattern printButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/Print_button.PNG").similar(0.8);
		        screen.wait(printButton, Integer.parseInt(jnlp_Handling_Time));
		        screen.click(printButton);
		        
//		        Pattern fileTextField = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/File_TextField.PNG").similar(0.8);
		        wait(driver,jnlp_Handling_Time);

//		        screen.wait(fileTextField, 10);
//		        screen.click(fileTextField);
		        screen.type(FileName);

		        Pattern saveButton = new Pattern(System.getProperty("user.dir")+"/uploads/JNLP/save_Button.png").similar(0.8);
		        screen.wait(saveButton, Integer.parseInt(jnlp_Handling_Time));
		        screen.click(saveButton);
		        
		        wait(driver,jnlp_Handling_Time);
		        robo.keyPress(KeyEvent.VK_ENTER);
		        robo.keyRelease(KeyEvent.VK_ENTER);
		        
		        wait(driver, jnlp_Handling_Time);

		        // Close the JNLP process
		        System.out.println("Closing the JNLP file...");
		        process.destroy(); // Gracefully terminate the process
		        if (process.isAlive()) {
		            process.destroyForcibly(); // Force terminate if still running
		        }
		        System.out.println("JNLP process closed.");
		        
		    	waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				globalValueSearchWindow1(driver,DropdownCondition,Select_Search_Type_MCN,BL_Number,"","","","");
				waitForElement(driver, BL_status);
				sendKeys(driver, BL_status, bl_Status);
				waitForElement(driver, retrivedGlobalValue);
				click(driver, retrivedGlobalValue);
				waitForElement(driver, SelectButton);
				click(driver, SelectButton);
				waitForElement(driver, MCN_Number_Textfield_MCN_Module);
				String actual_MCN_Textfield_Color1=getTextBackgroundColor(driver, MCN_Number_Textfield_MCN_Module);
				String actual_MCN_Textfield_Color = getColorName(actual_MCN_Textfield_Color1);
				System.out.println(actual_MCN_Textfield_Color);
				if(actual_MCN_Textfield_Color.equalsIgnoreCase(BL_Original_Print_Colour)) {
					System.out.println("Matched || The background color of MCN Textfield is Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
					Extent_pass_New(driver, "Matched || The background color of MCN Textfield is Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
				}else {
					System.out.println("Not Matched || The background color of MCN Textfield is not Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
					Extent_fail(driver, "Not Matched || The background color of MCN Textfield is not Blue || Expected MCN Textfield Color is : "+BL_Original_Print_Colour+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
				}
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		        Extent_fail(driver, "File not found  "+ e.getLocalizedMessage(), test, test1);
		    }
		    
		    
		}
	}