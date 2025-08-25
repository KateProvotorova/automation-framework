# Automation Testing Framework

This project is an automation testing framework for UI and API testing, built using Java, TestNG, Selenium, Rest-Assured, and Gradle.

## 🔧 Technologies Used

- Java 21
- Selenium 4
- Rest-Assured 5
- TestNG 7
- Gradle
- GitHub

## 🚀 Getting Started

### Prerequisites

- Java 21
- Gradle
- Chrome browser

### Clone the Repository

```bash
git clone https://github.com/KateProvotorova/automation-framework.git
cd automation-framework
```

### Run Tests

**Run All Tests:**
```bash
./gradlew test
```

**Run UI Tests Only:**
```bash
./gradlew uiTests
```

**Run API Tests Only:**
```bash
./gradlew apiTests
```

## ✅ Test Groups

TestNG groups are used to organize tests:
- `@Test(groups = "ui")`
- `@Test(groups = "api")`

## 🧪 Credentials

You can change the login credentials in:
```
src/test/resources/config.properties
src/test/resources/api_config.properties
```

## 📄 Future Improvements

- Allure integration
- GitHub Actions CI
