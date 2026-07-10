# Capstone-Project-Group-E

## 📑 Table of Contents

- [Description](#description)
- [Screenshots](#screenshots)
- [Tech Stack](#tech-stack)
- [Quick Start](#quick-start)
- [Key Dependencies](#key-dependencies)
- [Project Structure](#project-structure)
- [Contributors](#contributors)

This project automates the BrowserStack Demo Website using Selenium WebDriver and Java. The framework is built using industry-standard practices such as Page Object Model (POM), BDD Cucumber, TestNG, reusable utilities, reporting (Extent & Allure report) , and version control integration. The goal is to validate key e-commerce functionalities, improve test coverage, reduce manual effort, and ensure application quality through automated testing.

## 📸 Screenshots

![Verify search fails for any keyword 1783595108060](https://raw.githubusercontent.com/aryamanpandeywipro/Capstone-Project-Group-E/develop/screenshot/Verify_search_fails_for_any_keyword_1783595108060.png)

## 🛠️ Tech Stack

### Development & Automation
- ☕ Java
- 🌐 Selenium WebDriver

### Testing Frameworks
- ✅ TestNG
- 🥒 BDD Cucumber

### Reporting & Logging
- 📊 Extent Reports
- 📈 Allure Reports
- 📝 Log4j

### Project Management & Collaboration
- 🐙 GitHub
- 🎯 Jira

### CI/CD & Execution
- 🚀 Jenkins

## ⚡ Quick Start


### 1️⃣ Clone the Repository

```bash
git clone https://github.com/aryamanpandeywipro/Capstone-Project-Group-E.git
cd Capstone-Project-Group-E
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

### 3️⃣ Configure Test Data

Update the required configuration values in:

```text
src/test/resources/config.properties
```

### 4️⃣ Execute BDD Cucumber Tests

```bash
mvn test
```

Or run the Cucumber Runner class directly from the IDE.

### 5️⃣ Execute TestNG Tests

Run the TestNG suite:

```bash
mvn clean test
```

Or execute:

```text
testng.xml
```

from your IDE.

### 6️⃣ Generate Reports

#### Extent Report

After execution, view the report from:

```text
ExtentReports/ExtentReport.html
```

#### Allure Report

```bash
allure serve allure-results
```

### 7️⃣ View Screenshots

Captured screenshots can be found in:

```text
screenShots/
```

### 8️⃣ CI/CD Execution

Run the framework through Jenkins for automated build and test execution.

```text
Jenkins → Build Now → View Reports
```

## 📁 Project Structure

```
.
├── .settings
│   ├── org.eclipse.core.resources.prefs
│   ├── org.eclipse.jdt.core.prefs
│   └── org.eclipse.m2e.core.prefs
├── Reports
│   └── ExtentReport.html
├── allure-results
├── pom.xml
├── screenshot
│   └── Verify_search_fails_for_any_keyword_1783595108060.png
├── src
│   ├── main
│   └── test
│       ├── java
│       │   ├── BStackDemoTCs
│       │   │   └── BSDTestNG.java
│       │   ├── Hooks
│       │   │   └── BStackDemoHooks.java
│       │   ├── PageObjectsModels
│       │   │   ├── Cart.java
│       │   │   ├── Checkout.java
│       │   │   ├── ConfirmationPage.java
│       │   │   ├── Favouritespage.java
│       │   │   ├── HomePage.java
│       │   │   ├── NavBar.java
│       │   │   ├── Product.java
│       │   │   ├── ProductSort.java
│       │   │   ├── SignInPage.java
│       │   │   └── Vendor.java
│       │   ├── Runner
│       │   │   └── Runner.java
│       │   ├── features
│       │   │   ├── A_signIn.feature
│       │   │   └── B_HomePage.feature
│       │   ├── stepDef
│       │   │   ├── CheckoutSteps.java
│       │   │   ├── FavouritesSteps.java
│       │   │   ├── NavbarSteps.java
│       │   │   ├── SignInSteps.java
│       │   │   ├── SortingSteps.java
│       │   │   ├── VendorSteps.java
│       │   │   └── addToCartSteps.java
│       │   └── utils
│       │       ├── ExtentManager.java
│       │       ├── ScreenShot.java
|       |       ├── ExcelUtils.java
│       │       ├── baseClass.java
│       │       └── dataProperties.java
│       └── resources
│           ├── data.properties
|           ├── CheckoutData.xlxs
│           └── log4j2.xml
├── target
│   ├── CapstoneReport.html
│   ├── classes
│   │   ├── META-INF
│   │   │   ├── MANIFEST.MF
│   │   │   └── maven
│   │   │       └── automation
│   │   │           └── ...
│   │   └── Project
│   │       └── Capstone
│   │           └── App.class
│   └── test-classes
│       ├── Hooks
│       │   └── BStackDemoHooks.class
│       ├── PageObjectsModels
│       │   ├── Cart.class
│       │   ├── HomePage.class
│       │   ├── NavBar.class
│       │   ├── Product.class
│       │   ├── SignInPage.class
│       │   └── Vendor.class
│       ├── Runner
│       │   └── Runner.class
│       ├── features
│       │   └── A_signIn.feature
│       ├── log4j2.xml
│       ├── stepDef
│       │   ├── NavbarSteps.class
│       │   ├── SignInSteps.class
│       │   └── VendorSteps.class
│       └── utils
│           ├── ExtentManager.class
│           └── ScreenShot.class
├── test-output
│   ├── Default suite
│   │   ├── Default test.html
│   │   ├── Default test.xml
│   │   └── testng-failed.xml
│   ├── Suite
│   │   ├── Capstone Test.html
│   │   ├── Capstone Test.xml
│   │   └── testng-failed.xml
│   ├── bullet_point.png
│   ├── collapseall.gif
│   ├── emailable-report.html
│   ├── failed.png
│   ├── index.html
│   ├── junitreports
│   │   └── TEST-Runner.Runner.xml
│   ├── navigator-bullet.png
│   ├── old
│   │   ├── Default suite
│   │   │   ├── Default test.properties
│   │   │   ├── classes.html
│   │   │   ├── groups.html
│   │   │   ├── index.html
│   │   │   ├── main.html
│   │   │   ├── methods-alphabetical.html
│   │   │   ├── methods-not-run.html
│   │   │   ├── methods.html
│   │   │   ├── reporter-output.html
│   │   │   ├── testng.xml.html
│   │   │   └── toc.html
│   │   ├── Suite
│   │   │   ├── Capstone Test.properties
│   │   │   ├── classes.html
│   │   │   ├── groups.html
│   │   │   ├── index.html
│   │   │   ├── main.html
│   │   │   ├── methods-alphabetical.html
│   │   │   ├── methods-not-run.html
│   │   │   ├── methods.html
│   │   │   ├── reporter-output.html
│   │   │   ├── testng.xml.html
│   │   │   └── toc.html
│   │   └── index.html
│   ├── passed.png
│   ├── skipped.png
│   ├── testng-failed.xml
│   ├── testng-reports.css
│   ├── testng-reports.js
│   ├── testng-results.xml
│   └── testng.css
└── testng.xml
```

## 👥 Contributors

This project was successfully developed and maintained by the following team members:

- **Aryaman Pandey** –BDD Cucumber Implementation,BDD Cucumber Scenarios, TestNG Development, Jenkins Integration & Team Coordination
- **Ankur Nigam** – TestNG Automation, BDD StepDefinition , Framework Development, Documentation  
- **Chanchal** – BDD Cucumber Automation, TestNG Implementation, Checkout Management, Test Scenario Development
- **Shiva** – TestNG Automation, BDD Cucumber Page Object Model (POM), Reporting Integration, Logging & Framework Enhancements
