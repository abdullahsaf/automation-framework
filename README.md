# Project Overview

This project aims to create a selenium test using Cucumber and Spring Boot
---
## **Prerequisites**  
Ensure you have the following installed:
- Java
- Maven
- Docker [optional]

## **Steps to run the test**
**Clone the Repository**
   ```bash
   git clone https://github.com/abdullahsaf/automation-framework.git
   ```
**Navigate to the Project Directory**
   ```bash
   cd automation-framework
   ```
**Run the cucumber project locally**
   ```bash
   mvn -Dtest="com.automation.framework.cucumber.RunCucumberTest" test
   ```

### **To run using Selenium Grid, remote browser execution**

selenium driver images from [Docker Hub](https://hub.docker.com/u/selenium)

**Run the cucumber project using "grid" profile**
   ```bash
   mvn -Dtest="com.automation.framework.cucumber.RunCucumberTest" -Dspring.profiles.active=grid test
   ```

