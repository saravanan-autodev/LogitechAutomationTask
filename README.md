# Logitech - QA Automation Task

## Getting Started

#### Platform / Environment

Build Tool - Maven

Platform - Java 1.8

Automation Tools - Selenium, Rest Assured, Cucumber

Reporting - Report Portal

## Maven Command to run the scripts - Supports only local execution

clean verify -Dbrowser=chrome -Dcucumber.filter.tags="@API"

Tags for execution
1. API Scenarios - @API
2. UI Scenarios - @UI
3. Both - "@API or @UI"
4. Refer the feature files for inddividual scenarios tags.

#### Browsers Supported (Local Execution)

Chrome

Firefox

Edge

IE

Safari (Only for Mac)

Browser Drivers to be kept in - /browserdrivers folder

* In Case of Windows, provide driver file name with extension in bootstrap.properties
* In Case of Mac, provide driver file name without extension in bootstrap.properties


