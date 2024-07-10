# API and Mobile Testing Project

This project aims to automate API and mobile application testing using Selenium, Appium, and RestAssured. The project uses ExtentReports to create test reports.

## Project Structure

````
flip-test/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- api/
|   |   |   |   |-- ApiClient.java
|   |   |   |-- app/
|   |   |   |   |-- pageObjects/
|   |   |   |       |-- actions/
|   |   |   |       |-- locators/
|   |   |   |-- config/
|   |   |   |-- dataprovider/
|   |   |   |   |-- TestDataProvider.java
|   |   |   |-- utils/
|   |   |-- resources/
|   |       |-- config.properties
|   |-- test/
|       |-- java/
|       |   |-- apiTests/
|       |   |   |-- ApiTestSuite.java
|       |   |-- mobileTests/
|       |   |   |-- MobileTestSuite.java
|       |   |-- runner/
|       |   |   |-- DynamicTestNGSuiteRunner.java
|       |-- resources/
|           |-- Android.SauceLabs.Mobile.app.2.7.1.apk
|           |-- testdataapi.csv
|           |-- testdatamobile.csv
|-- target/
|   |-- reports
|-- pom.xml
|-- README.md
````


## Prerequisites

- [Java JDK 11](https://www.oracle.com/id/java/technologies/javase/jdk11-archive-downloads.htmll)
- [Maven](https://maven.apache.org/download.cgi)
- [Android SDK](https://developer.android.com/studio)
- [Appium](https://appium.io/docs/en/2.3/quickstart/install/)
- Android Emulator or a connected physical device

## Installation

1. Install Maven dependencies:
````
mvn clean install
````

## How to Run
### Running API Tests
1. Configure the testdataapi.csv file in the `src/test/resources/` directory with the appropriate data.
2. Run the API tests with the following command:
````
mvn test -Dtest=apiTests.ApiTestSuite
````
&nbsp;&nbsp; or
````
mvn exec:java -Dexec.mainClass="runner.DynamicTestNGSuiteRunner" -DsuiteType=api
````

### Running Mobile Tests
1. Configure the testdatamobile.csv file in the `src/test/resources/` directory to change device name and platform version
2. Run appium server with same port in testdatamobile.csv file
3. Run the Mobile tests with the following command:
````
mvn test -Dtest=mobileTests.MobileTestSuite 
````
&nbsp;&nbsp; or
````
mvn exec:java -Dexec.mainClass="runner.DynamicTestNGSuiteRunner" -DsuiteType=mobile
````