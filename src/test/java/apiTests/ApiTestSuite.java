package apiTests;

import api.ApiClient;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import dataprovider.TestDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class ApiTestSuite {
    private static ApiClient apiClient;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUpClass() {
        extent = ExtentManager.createInstance("ExtentReportApi.html");
        apiClient = new ApiClient();
    }

    @BeforeMethod
    public void setUp(Method method, Object[] testData) {
        String name = (String) testData[0];
        String testName = method.getName() + " for name: " + name;
        System.out.println("Creating test for " + testName);
        test = extent.createTest(testName);
    }

    @Test(dataProvider = "genderData", dataProviderClass = TestDataProvider.class)
    public void testGenderByName(String name, String expectedGender) {
        test.log(Status.INFO, "Starting test for name: " + name);
        Response response = apiClient.getGenderByName(name);
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        test.log(Status.INFO, "Status Code: " + statusCode);

        try {
            Assert.assertEquals(statusCode, 200, "Unexpected status code for " + name);
            test.log(Status.PASS, "Status code is 200 for name: " + name);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected status code for name: " + name + ". " + e.getMessage());
            throw e;
        }
        String actualGender = response.jsonPath().getString("gender");
        System.out.println("Actual Gender: "+actualGender);
        System.out.println("Expected Gender: "+expectedGender);

        try {
            Assert.assertEquals(actualGender, expectedGender, "Gender mismatch for " + name);
            test.log(Status.PASS, "Test passed for name: " + name);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Test failed for name: " + name + ". " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDownClass() {
        if (extent != null) {
            extent.flush();
        }
    }
}
