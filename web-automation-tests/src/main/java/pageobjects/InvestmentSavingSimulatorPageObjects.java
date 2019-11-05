package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestmentSavingSimulatorPageObjects {
	private WebDriver driver;

	public InvestmentSavingSimulatorPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement forYouRadioBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]//input[@value=\"paraVoce\"]"));
	}

	public WebElement valueApplyTextField() {
		return this.driver.findElement(By.id("valorAplicar"));
	}

	public WebElement valueInvestTextField() {
		return this.driver.findElement(By.id("valorInvestir"));
	}

	public WebElement timeFrameTextField() {
		return this.driver.findElement(By.id("tempo"));
	}

	public WebElement simulateButton() {
		return this.driver
				.findElement(By.xpath("//*[@id=\"formInvestimento\"]//button[contains(@class,\"btnSimular\")]"));
	}

}
