**Overview**

This is a testing project on LocalFinds website, an e-commerce application. Functionalities validated contains valid and invalid login scenarios, viewing and validating product details, name and price. It follows Page Object Model(POM) separate page classes for locators and actions from the test logic

**Project Structure**

/LocalFinds  
/test/java  
Base  
/TestBase.java \- driver setup  
Pages  
/HomePage.java  
  	/LoginPage.java  
Testcases  
/LoginTest.java  
Utility  
/ExcelUtility.java  
/test/resources  
/config.properties  
	/LoginData.xlsx  
/pom.xml  
/testng.xml

**Tools:**

* Maven  
* TestNG  
* Java 21  
* Eclipse \-IDE

**Setup:**

* **Setup pom.xml and testng.xml files**  
* **Uses external excel file to read login data**  
* **Run using mvn test command**  
* **Testng reports generated in test-output folder**


**Maven dependencies:**

* **Selenium**   
* **TestNG**   
* **Apache POI**


  


  
