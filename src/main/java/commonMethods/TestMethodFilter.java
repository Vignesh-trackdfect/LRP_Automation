package commonMethods;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class TestMethodFilter implements IAnnotationTransformer {

	 static Map<String, String> testExecutionMap;
	    static Map<String, Integer> priorityMap; // For priority

	    static {
	        try {
	            testExecutionMap = TestNgXml.getFlagValue_FromExecution(); // Fetch method flags from Excel
	            priorityMap = TestNgXml.getPriority_FromExecution(); // Fetch method priorities from Excel
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        String methodName = testMethod.getName();

	        if (testExecutionMap != null && testExecutionMap.containsKey(methodName)) {
	            String flag = testExecutionMap.get(methodName);
	            if ("No".equalsIgnoreCase(flag)) {
	                annotation.setEnabled(false); // Disable the method
	            } else {
	                annotation.setEnabled(true);  // Enable if Yes
	            }
	        }

	        // Setting the priority
	        if (priorityMap != null && priorityMap.containsKey(methodName)) {
	            int priority = priorityMap.get(methodName);
	            annotation.setPriority(priority);
	        }
	    }
}
