package runner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Collections;

public class DynamicTestNGSuiteRunner {
    public static void main(String[] args) {
        String suiteType = System.getProperty("suiteType", "mobile"); // Default to mobile if not specified
        System.out.println("Running suite type: " + suiteType);

        String suiteName;
        if (suiteType.equalsIgnoreCase("api")) {
            suiteName = "API Test Suite";
        } else if (suiteType.equalsIgnoreCase("mobile")) {
            suiteName = "Mobile Test Suite";
        } else {
            System.err.println("Unknown suite type: " + suiteType);
            return;
        }

        TestNG testng = new TestNG();

        XmlSuite suite = new XmlSuite();
        suite.setName(suiteName);

        XmlTest test = new XmlTest(suite);
        test.setName(suiteName);
        test.setThreadCount(1); // Set thread-count to 1

        if (suiteType.equalsIgnoreCase("api")) {
            System.out.println("Adding API Test Suite classes");
            test.setXmlClasses(Collections.singletonList(new XmlClass("apiTests.ApiTestSuite")));
        } else if (suiteType.equalsIgnoreCase("mobile")) {
            System.out.println("Adding Mobile Test Suite classes");
            test.setXmlClasses(Collections.singletonList(new XmlClass("mobileTests.MobileTestSuite")));
        }

        testng.setXmlSuites(Collections.singletonList(suite));
        testng.setUseDefaultListeners(false);

        // Print the generated XML suite
        System.out.println("Generated XML Suite: " + suite.toXml());

        TestListenerAdapter tla = new TestListenerAdapter();
        testng.addListener(tla);

        testng.run();

        if (tla.getFailedTests().size() > 0) {
            System.exit(1);
        } else {
            System.exit(0);
        }
    }
}
