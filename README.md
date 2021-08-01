# Logitech - QA Automation Task

## Getting Started

#### Platform / Environment

Build Tool - Maven

Platform - Java 1.8

Automation Tools - Selenium, Rest Assured, Cucumber

Reporting - Report Portal

## Maven Command to run the scripts - Supports only local execution

clean verify -Dbrowser=chrome -Dcucumber.filter.tags="@API"

#### Browsers Supported (Local Execution)

Chrome

Firefox

Edge

IE

Safari (Only for Mac)

Browser Drivers to be kept in - /browserdrivers folder

* In Case of Windows, provide driver file name with extension in bootstrap.properties
* In Case of Mac, provide driver file name without extension in bootstrap.properties


