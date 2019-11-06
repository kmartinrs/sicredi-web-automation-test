# PLATAFORMA DIGITAL SICREDI
### Web application automated test using Cucumber
This repository contains the source code of a challenge of Web application test automation. 

This project is developed taking advantage of BDD (Behavior Driven Development).

### Requirements

* Eclipse IDE - [eclipse.org](http://www.eclipse.org/)
* Maven - [maven.apache.org](https://maven.apache.org/)
* JDK 8 - [oracle.com](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

### How to execute?
1. Clone this repository
2. Open a terminal and go to the project directory
3. Execute the command: 
	> mvn clean install
4. Execute the command: 
	> mvn test -Dsicredi.automation.webdriver=CHROME
	
	Please note that you can change CHROME to the following values:
	* FIREFOX
	* EDGE
	* IE

### External dependencies

These dependencies were download by Maven dependency manager.

* Selenium WebDriver - [seleniumhq.org](https://www.seleniumhq.org/)
* WebDriver Manager - [github.com/bonigarcia/webdrivermanager](https://github.com/bonigarcia/webdrivermanager)
* JUnit - [junit.org](https://junit.org/junit5/)
* Cucumnber - [cucumber.io/docs](https://cucumber.io/docs)