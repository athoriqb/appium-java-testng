package mobileTests;

import app.pageObjects.actions.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.TestDataMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;
import utils.CsvUtils;
import utils.CustomAsserts;
import utils.DriverManager;
import utils.ExtentManager;

import java.lang.reflect.Method;
import java.util.List;

public class MobileTestSuite {
    private ExtentReports extent;
    private ExtentTest test;
    private AppiumDriver<MobileElement> driver;
    private LoginActions loginActions;
    private HomeActions homeActions;
    private CustomAsserts customAsserts;
    private CartActions cartActions;
    private CheckoutInfoActions checkoutInfoActions;
    private CheckoutOverviewActions checkoutOverviewActions;
    private CheckoutCompleteActions checkoutCompleteActions;
    private TestDataMobile testData;

    @BeforeClass
    public void setUpClass() throws Exception {
        System.out.println("Setting up ExtentReports in @BeforeClass");
        extent = ExtentManager.createInstance("ExtentReportMobile.html");
        List<TestDataMobile> testDataList = CsvUtils.readTestData("src/test/resources/testdatamobile.csv");
        testData = testDataList.get(0);
        DriverManager.initializeDriver(testData.getDeviceName(), testData.getPlatformVersion(), testData.getPort());
        driver = DriverManager.getDriver();
        loginActions = new LoginActions(driver);
        homeActions = new HomeActions(driver);
        cartActions = new CartActions(driver);
        checkoutInfoActions = new CheckoutInfoActions(driver);
        checkoutOverviewActions = new CheckoutOverviewActions(driver);
        checkoutCompleteActions = new CheckoutCompleteActions(driver);
    }

    @BeforeMethod
    public void setUp(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        String testName = testAnnotation.description();
        test = extent.createTest(testName);
        customAsserts = new CustomAsserts(test, driver);
    }

    @Test(description = "Verify able to Login To Sauce Lab")
    public void verifyAbleLoginToSauceLab() throws Exception {
        loginActions.inputCredentialsSwagLabs(testData.getUsername(), testData.getPassword());
        loginActions.clickLoginBtn();
        boolean isHomeVisible = homeActions.isHomeProductsIsVisible();
        CustomAsserts.assertTrue(isHomeVisible,"Login success","Login Failed");
    }

    @Test(description = "verify able to filter from high to low",dependsOnMethods = {"verifyAbleLoginToSauceLab"})
    public void verifyAbleFilterProductHighToLow() {
        homeActions.switchViewProductToList();
        homeActions.chooseFilterHighToLow();
        CustomAsserts.assertTrue(homeActions.isPriceSortedFromHighToLow(),"Price Sorted from high to low","Price not sorted from high to low");
    }

    @Test(description = "verify able to filter from low to high",dependsOnMethods = {"verifyAbleFilterProductHighToLow"})
    public void verifyAbleFilterProductLowToHigh() {
        homeActions.chooseFilterLowToHigh();
        CustomAsserts.assertTrue(homeActions.isPriceSortedFromLowToHigh(),"Price Sorted from to to high","Price not sorted from low to high");
    }

    @Test(description = "verify able to checkout product",dependsOnMethods = {"verifyAbleFilterProductLowToHigh"},priority = 4)
    public void verifyAbleToCheckout() throws Exception {
        homeActions.clickAddToCartBtn();
        String productName = homeActions.getProductName();
        String productDesc = homeActions.getProductDescription();
        String productPrice = homeActions.getProductPrice();
        homeActions.clickCartIconBtn();
        cartActions.waitUntilCartScreenVisible();
        CustomAsserts.assertTrue(cartActions.isTotalAmountCorrect("1"),"Total amount as expected","Total Amount not as epcred");
        CustomAsserts.assertTrue(cartActions.isProductNameCorrect(productName),"Product name "+productName+" is same","Product name "+productName+" is not same");
        CustomAsserts.assertTrue(cartActions.isProductDescCorrect(productDesc),"Product description "+productDesc+" is same","Product description "+productDesc+" is not same");
        CustomAsserts.assertTrue(cartActions.isProductPriceCorrect(productPrice),"Product price "+productPrice+" is same","Product price "+productPrice+" is not same");
        cartActions.clickCheckoutBtn();
        checkoutInfoActions.waitUntilCheckoutInfoScreenVisible();
        checkoutInfoActions.inputInformation(testData.getFirstName(), testData.getLastName(), testData.getZipCode());
        checkoutInfoActions.clickContinueBtn();
        checkoutOverviewActions.waitUntilCheckoutOverviewScreenVisible();
        checkoutOverviewActions.clickFinishBtn();
        CustomAsserts.assertTrue(checkoutCompleteActions.isThankYouScreenVisible(),"Checkout Success","Checkout failed");
    }

    @AfterClass
    public void tearDownClass() {
        DriverManager.quitDriver();
        System.out.println("Flushing ExtentReports in @AfterClass");
        if (extent != null) {
            extent.flush();
        }
    }
}
