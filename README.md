# BookingDotComCucumberFramework
Framework to test the Star Rating and Spa and wellness centre filters

-----
Tools
-----
- Maven
- Cucumber

-------------
Configuration
-------------
This project can handle configuration for the following environments: 
- DEV
- INT
- PREPROD
- PROD

-------
Reports
-------
Reports are generated automatically and can be located in the following folder
/target/cucumber-reports/index.html

----------------
Folder Structure
----------------
- /src/main/java/core contains the DriverFactory and TestConfig classes
- /src/main/resources contains the .properties files with environment configuration details
- /src/test/java/features contains the feature file SearchHotels.feature
- /src/test/java/pages contains the Page Object Model classes
- /src/test/java/runner contains the TestRunner class from where the tests are run
- /src/test/java/step_definitions contains the step defintion files
