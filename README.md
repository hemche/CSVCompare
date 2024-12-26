# CSVCompare

CSVCompare is a simple Java-based tool designed to compare two CSV files and highlight differences between them. The project is intended for use cases where you need to verify that two CSV files are identical or contain discrepancies, whether in terms of content, formatting, or structure.

## Features

- **Compare two CSV files**: Compare the contents, rows, columns, and formatting of two CSV files.
- **Detailed differences reporting**: Outputs the differences in a human-readable format, making it easy to spot discrepancies.
- **No external libraries**: The tool does not rely on any external libraries for CSV processing, making it lightweight and easy to integrate into your projects.
- **Supports handling of common CSV formatting issues**: It accounts for extra spaces, case sensitivity, and row/column differences.
- **JUnit 5 integration for automated testing**: The project includes a testing framework with surefire html reporting for visualizing test results.

## Requirements

- **Java 8+**: The project is compatible with Java 8 and later versions.
- **Maven**: For building and managing the project.
- **JUnit 5**: For running unit tests.

## Getting Started

To get started with the CSVCompare project, follow the instructions below to set up the project on your local machine.

### 1. Clone the Repository

``` bash
git clone https://github.com/hemche/CSVCompare.git
cd CSVCompare
```

### 2. Build the Project
To build the project and install the required dependencies, run the following Maven command:

```bash
mvn clean install
```
This will Download the necessary dependencies, Compile the project and Run any included unit tests.
### 3. Run Tests and Generate SureFire html report
To run the tests and generate html report, use the following Maven commands:
``` bash
mvn clean test
mvn surefire-report:report
```
