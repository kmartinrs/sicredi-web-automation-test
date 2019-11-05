package cucumber;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Configuration;
import framework.Drivers;
import framework.Report;
import framework.ScreenShot;
import models.TestConfiguration;
import pageobjects.InvestmentSavingSimulatorPageObjects;

public class TestContext {
	private static WebDriver driver;
	private InvestmentSavingSimulatorPageObjects investSimulationPageObject;

	public static WebDriver getDriver() {
		return driver;
	}

	public InvestmentSavingSimulatorPageObjects getInvestSimulationPageObject() {
		return investSimulationPageObject;
	}

	public void setInvestSimulationPageObject(InvestmentSavingSimulatorPageObjects investSimulationPageObject) {
		this.investSimulationPageObject = investSimulationPageObject;
	}

	public TestContext() {
		TestConfiguration testConfiguration = Configuration.getTestConfiguration();

		if (TestContext.driver == null) {
			Report.create("PLATAFORMA DIGITAL SICREDI", "Teste de funcionalidade");
			Report.startTest("Chegou a hora de poupar! Mas quanto? Em quanto tempo? Como posso saber?");

			String webDriverParam = System.getProperty("sicredi.automation.webdriver");

			System.out.println("Selected WebDriver: " + webDriverParam);

			switch (webDriverParam.toUpperCase()) {
			case "CHROME":
				TestContext.driver = Drivers.getChromeDriver();
				break;
			default:
				break;
			}
		}

		TestContext.driver.get(testConfiguration.getAppURL());
		TestContext.driver.manage().window().maximize();
		Report.log(Status.INFO, "Acesso a página realizado.", ScreenShot.capture(TestContext.driver));
		this.investSimulationPageObject = new InvestmentSavingSimulatorPageObjects(TestContext.driver);
	}
}
