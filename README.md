# Selenium Cucumber Framework

---

## Tools and Libraries
This project using 2 main tools, Selenium and Cucumber.
On the other hand, I am using some of the tools that support this framework.
The complete list of tools, you can see in the `pom.xml` file.

## Requirements
* Java Development Kit
* Maven
* WebDriver, using ChromeDriver

## Running Tests
* Clone the repository from your fork to this directory
* Open the project using any Java IDE
```shell
$ mvn clean install
```
* Run the tests with the script below
```shell
$ mvn clean test
```
* If you want to run the specific test, use the cucumber tags like this
```shell
$ mvn clean test -Dcucumber.filter.tags="@REPLACE_WITH_ANY_TAGS_THAT_YOU_WANT"
```

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `src/test/resources/cucumber.properties` then change the value to be `true`
```properties
cucumber.publish.enabled=true
```
