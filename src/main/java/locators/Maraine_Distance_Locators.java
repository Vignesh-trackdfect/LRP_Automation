package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Maraine_Distance_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Maraine_Distance", "Reference_Name",
			Testcases.environmentName);
	public static String Getmarinedistance = ExcelData.get("Getmarinedistance");
	public static String Distance_GRidcell_MD=ExcelData.get("Distance_GRidcell_MD");
	public static String Distancevalue=ExcelData.get("Distancevalue");

	
}
