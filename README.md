# JiraCreateIssueTest

This is Selenium project for testing of "Create new issue" functionality in Jira software.

Project uses Selenium-Grid server.

To run on local environment:

* Download selenium-server-standalone.jar
https://www.seleniumhq.org/download/
* Download binraies for browser and put them in the same folder with selenium-server-standalone.jar
1) https://github.com/mozilla/geckodriver/releases
2) http://chromedriver.chromium.org/
* Start GRID server
```
java -jar selenium-server-standalone-3.13.0.jar -role hub
java -jar selenium-server-standalone-3.13.0.jar -role node
```

Make sure you have credentials.properties file in root folder of your project with content
```
   jiraLogin=...
   jiraPassword=...
```

* Run test
```mvn clean test site```
* Look at Allure results
``` mvn io.qameta.allure:allure-maven:serve ```