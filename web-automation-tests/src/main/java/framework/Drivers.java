package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {

	public static WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	public static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

	public static WebDriver getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}

	public static WebDriver getIEDriver() {
		WebDriverManager.iedriver().setup();
		return new InternetExplorerDriver();
	}

}