# 🧪 E-commerce API Automation Testing (Rest Assured)

This project contains a robust, organized, and fully automated API test suite for the E-commerce service provided by `automationexercise.com/api_list`. The suite is developed using **Java, Rest Assured, and TestNG**.

It demonstrates proficiency in building a scalable API automation framework, covering request construction, comprehensive validation, and reporting.

---

## ⚙️ Technologies and Tools

| Category | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | Java | Core language for the framework. |
| **API Automation** | **Rest Assured** | Library for building and validating API requests. |
| **Test Framework** | **TestNG** | Test execution, annotations (`@BeforeSuite`, `@Test`), and reporting. |
| **Build Tool** | **Maven** | Dependency management and project build lifecycle. |
| **Reporting** | **ExtentReports** | Generating detailed, visual test execution reports. |
| **Version Control** | Git / GitHub | Code management and collaboration. |

---

## 📂 Framework Architecture

The project follows a standard, modular structure for scalability:

* **`src/main/java/API`**: Contains classes representing the API resources (`Auth`, `Brands`, `Products`, `User`) for centralized endpoint definitions.
* **`src/test/java`**: Contains the actual test classes (`Auth`, `Brands`, `Products`, `User`) where test methods are defined using **TestNG** annotations.
* **`utilities`**: Houses supporting classes like **`Base`** (for setup/teardown) and **`Listener`** (for integrating ExtentReports).
* **`testng.xml`**: The primary configuration file defining the entire test suite and enabling parallel execution.

### Key Features:
* Utilizes **TestNG Listeners** to automatically integrate **ExtentReports** for comprehensive reporting.
* Employs a **Page Object Model (POM)-like structure** for APIs, separating API resources from test execution logic.

---

## 📊 Viewing the Report
After test execution, the detailed report is generated in the target directory:

1. Navigate to the target folder  
2. Open **ExtentReport.html** in any web browser  

---

## 📞 Contact
For any questions or feedback regarding this automation framework:

- **Name**: Prethumnan  
- **GitHub**: [https://github.com/Prethumnan](https://github.com/Prethumnan)  
- **Email**: prethumnan77@gmail.com  

