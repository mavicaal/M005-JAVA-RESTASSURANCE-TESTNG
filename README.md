# M005-JAVA-RESTASSURANCE-TESTNG

## Project Description

This project is a Test Automation framework built using **Java**, **RestAssured**, and **JUnit 5**. It is designed to test the RESTful APIs provided by [PokeAPI](https://pokeapi.co/). The framework includes clients for interacting with the API, models for mapping API responses, and test classes to validate the functionality of various endpoints.

### Key Features:
- **API Clients**: Encapsulate API interactions for specific endpoints.
- **Models**: Map API responses to Java objects using Jackson.
- **JUnit 5 Tests**: Validate API responses and ensure the endpoints behave as expected.
- **Maven**: Used for dependency management and build automation.

### Directory Structure:
```bash
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       ├── api/
│   │       │   ├── BaseConfig.java
│   │       │   ├── clients/
│   │       │   │   ├── ApiClient.java
│   │       │   │   ├── BerryClient.java
│   │       │   │   └── BerryFirmnessClient.java
│   │       │   ├── models/
│   │       │   │   ├── Berry.java
│   │       │   │   └── BerryFirmness.java
├── test/
│   ├── java/
│   │   └── com/
│   │       ├── tests/
│   │       │   ├── BerryTest.java
│   │       │   └── BerryFirmnessTest.java
```

## Prerequisites

- **Java**: Ensure Java 11 or higher is installed.
- **Maven**: Install Maven for dependency management.
- **Internet Connection**: Required to interact with the PokeAPI.

## How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/mavicaal/M005-JAVA-RESTASSURANCE-TESTNG.git
   cd M005-JAVA-RESTASSURANCE-TESTNG
2. Build the project and run tests using Maven:
   ```bash
    mvn clean install
    mvn test

## Test Reports
After running the tests, a detailed report will be generated in the target/surefire-reports directory.
## License
This project is licensed under the MIT License.
    
   
   

