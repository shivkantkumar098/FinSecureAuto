# 🏦 **BankTestPro - Banking Application Test Automation Project**

## 📌 **Overview**

**FinSecure** is a test automation project developed to ensure the functionality and reliability of a banking web application. The application includes core banking features ranging from account management to transaction history and customer services. This project verifies all major workflows using automated testing strategies.

---

## ✅ **Features Covered for Testing**

The following key features of the banking application are tested:

### 🔐 **Authentication**
- **Login**: Validate user login with valid and invalid credentials.
- **Logout**: Ensure secure logout and session clearance.

### 👤 **Customer Management**
- **Manager**: Verify access to manager-specific modules and actions.
- **New Customer**: Test creation of a new customer with all mandatory and optional fields.
- **Edit Customer**: Validate editing of customer details.
- **Delete Customer**: Ensure customer records can be safely and accurately deleted.

### 💳 **Account Management**
- **New Account**: Validate account creation linked to an existing customer.
- **Edit Account**: Test account updates such as account type or balance details.
- **Delete Account**: Ensure deletion of bank accounts and related data.

### 📄 **Statements and Reports**
- **Mini Statement**: Check recent transactions visibility for selected accounts.
- **Customized Statement**: Validate generation of statements with specific date ranges and filters.

---

## 🧪 **Tools and Technologies**

- **Java / Python / JavaScript** (specify based on your stack)
- **Selenium WebDriver** / **Playwright** / **Cypress**
- **TestNG / JUnit / PyTest**
- **Maven / Gradle / npm**
- **Allure / Extent Reports**
- **Jenkins / GitHub Actions** (for CI/CD)

---

## 📂 Project Structure (Sample)
```
Folder Structure:

📂 FinSecure/
├── 📂 src/
│   ├── 📂 main/
│   │   └── 📂 java/ (or python/javascript)
│   │       └── 📂 org.finSecure/
│   │           ├── 📂 constants/
│   │           ├── 📂 customException/
│   │           ├── 📂 Driver/
│   │           │   ├── 📂 factory/
│   │           │   └── 📂 manager/
│   │           ├── 📂 pages/
│   │           └── 📂 utils/
│   └── 📂 test/
│       └── 📂 java/ (or python/javascript)
│           └── 📂 org.finSecure.tests/
│               ├── 📂 hooks/
│               ├── 📂 runners/
│               └── 📂 stepDefinitions/
├── 📂 resources/
│   ├── 📂 config/
│   └── 📂 features/
├── 📄 pom.xml (or package.json / requirements.txt)
├── 📄 README.md
└── 📄 .gitignore


```

---

## 🚀 How to Run Tests

```bash
# For Maven (Java + TestNG)
mvn clean test

# For npm (Cypress)
npx cypress run
```

---

## 📝 Test Reporting

- HTML and Allure reports are generated under the `/reports` directory.
- Screenshots and logs captured for failed scenarios.

---

## 📧 Contact

For queries or issues, contact:

- **LinkedIn:** [Shiv Kant](https://www.linkedin.com/in/shivkantkumar/)

---

## 📄 License

This project is for educational and internal testing purposes only.

```

---
## 🛠️ Contribution
Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.
## 📜 Acknowledgements
This project is inspired by the need for robust banking application testing and aims to provide a solid foundation for test automation in financial applications.
## 📅 Last Updated
July 2025