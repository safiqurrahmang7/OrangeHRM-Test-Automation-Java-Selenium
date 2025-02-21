# OrangeHRM Test Automation Framework (Java + Selenium)

## 📌 Overview
This repository contains an automated test framework for **OrangeHRM**, built using **Java, Selenium WebDriver, TestNG, and Cucumber**. The framework follows a **hybrid automation approach** combining the **Page Object Model (POM)** and **Behavior-Driven Development (BDD)** principles.

## 🚀 Features
- **TestNG & Cucumber Integration** – Supports both traditional TestNG tests and BDD-style Cucumber scenarios.
- **Page Object Model (POM)** – Ensures modular, reusable, and maintainable test scripts.
- **Data-Driven Testing** – Uses JSON files for flexible test data management.
- **Retry Mechanism** – Implements a `RetryAnalyzer` for handling test failures.
- **Extensive Reporting** – Generates **Allure & Extent Reports** for detailed test execution insights.
- **CI/CD Integration** – Compatible with **Jenkins** for automated execution.

## 📂 Project Structure
```
safiqurrahmang7-orangehrm-test-automation-java-selenium/
│── pom.xml                    # Maven project dependencies
│── Reports/                    # HTML test execution reports
│── TestSuites/testng.xml       # TestNG suite configuration
│── src/
│   ├── main/java/OrangeHRM/    # Page Object Model (POM) implementation
│   │   ├── AbstractComponents/ # Common reusable components
│   │   └── PageObjects/        # Specific page classes (Login, Admin, PIM, Dashboard)
│   ├── test/java/OrangeHRM/    # Test scripts and supporting components
│   │   ├── Cucumber/           # BDD scenarios and runner
│   │   ├── Data/               # Test data (JSON format)
│   │   ├── StepDefinitions/    # Step definitions for Cucumber tests
│   │   ├── TestComponents/     # Base test setup, retry logic, and listeners
│   │   ├── Tests/              # TestNG-based test cases
│   │   └── resources/          # Configuration files (ExtentReports, Global properties)
│── test-output/                # Test execution reports
└── .mvn/                        # Maven configurations
```

## 🛠️ Setup & Installation
### **1. Prerequisites**
Ensure the following dependencies are installed:
- **Java 11+**
- **Maven 3+**
- **Selenium WebDriver**
- **TestNG & Cucumber**

### **2. Clone the Repository**
```bash
git clone https://github.com/safiqurrahmang7/orangehrm-test-automation-java-selenium.git
cd orangehrm-test-automation-java-selenium
```

### **3. Install Dependencies**
```bash
mvn clean install
```


## 📊 Reporting
- **TestNG Reports:** `test-output/index.html`
- **Extent Reports:** `src/test/resources/ExtentreportNG.java`
- **Allure Reports:**
```bash
allure serve allure-results/
```

## 🤝 Contributing
1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes and push to GitHub.
4. Submit a Pull Request.

## 📜 License
This project is licensed under the MIT License.

## 👤 Author
**Safiqur Rahman**  
📧 [safiqurrahmang7@gmail.com](mailto:safiqurrahmang7@gmail.com)  
🌐 [LinkedIn](www.linkedin.com/in/safiqurrahmansoftwareengineer)  
📌 GitHub: [safiqurrahmang7](https://github.com/safiqurrahmang7)

---
✨ *Feel free to raise issues or contribute to improving this framework!*
