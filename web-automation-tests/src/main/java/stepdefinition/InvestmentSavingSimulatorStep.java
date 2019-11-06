package stepdefinition;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.TestContext;
import framework.Configuration;
import framework.Report;
import framework.ScreenShot;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import models.TestConfiguration;
import pageobjects.InvestmentSavingSimulatorPageObjects;

public class InvestmentSavingSimulatorStep {
	private InvestmentSavingSimulatorPageObjects investSimulationPageObject;
	TestConfiguration testConfiguration = Configuration.getTestConfiguration();

	public InvestmentSavingSimulatorStep(TestContext context) {
		if (investSimulationPageObject == null)
			investSimulationPageObject = context.getInvestSimulationPageObject();
	}

	@Dado("que realizei a seleção de uma das opções do perfil")
	public void selectProfileType() throws Throwable {
		try {
			this.investSimulationPageObject.forYouRadioBox().click();
		} catch (Throwable error) {
			Report.logFail("Não foi possível selecionar a opção de perfil: para você! >>> Erro encontrado: " + error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}

	@Dado("realizei o preenchimento dos campos obrigatórios")
	public void addValueToRequiredFields() throws Throwable {
		try {
			this.investSimulationPageObject.valueApplyTextField().sendKeys("3000");
			this.investSimulationPageObject.valueInvestTextField().sendKeys("3000");
			this.investSimulationPageObject.timeFrameTextField().sendKeys("60");
		} catch (Throwable error) {
			Report.logFail("Erro ao preencher campos obrigatórios! >>> Erro encontrado: " + error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}

	}

	@Quando("executo o clique no botão simular")
	public void clickOnSimulateButton() throws Throwable {
		try {
			this.investSimulationPageObject.simulateButton().click();
		} catch (Throwable error) {
			Report.logFail("Erro ao executar clique no botão Simular! >>> Erro encontrado: " + error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}

	@Dado("não realizei o preenchimento dos campos obrigatórios")
	public void dontAddValueToRequiredFields() throws Throwable {
		try {
			this.investSimulationPageObject.valueApplyTextField().clear();
			this.investSimulationPageObject.valueInvestTextField().clear();
			this.investSimulationPageObject.timeFrameTextField().clear();
		} catch (Throwable error) {
			Report.logFail(
					"Erro ao realizar a tentativa do não preenchimento dos campos obrigatórios! >>> Erro encontrado: "
							+ error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}

	@Então("é possivel visualizar o formulário de simulação")
	public void validFormsSimulation() throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(this.investSimulationPageObject.getDriver(), 3);

			WebElement button = wait.until(
					ExpectedConditions.elementToBeClickable(this.investSimulationPageObject.repeatSimulationButton()));

			Assert.assertTrue(button.isDisplayed());
		} catch (Throwable error) {
			Report.logFail("Não foi possível visualizar o formulário da simulação! >>> Erro encontrado: " + error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}

	@Então("uma mensagem de aviso sobre a obrigatoriedade de preenchimento dos campos deve ser apresentada")
	public void validateRequiredFieldsMessage() {
		try {
			Assert.assertEquals("Obrigatório", investSimulationPageObject.errorTimeFrameMessageLabel().getText());
		} catch (Throwable error) {
			Report.logFail(
					"Não foi possível validade mensagem sobre a obrigatoriedade dos campos! >>> Erro encontrado: "
							+ error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}

	@Quando("realizo a tentativa de inserir caracteres não permitidos nos campos de tipo {string}")
	public void insertInvalidTypeCaracter(String fieldType) throws Throwable {
		try {
			if (fieldType.toUpperCase().equals("VALOR")) {
				this.investSimulationPageObject.valueApplyTextField().sendKeys("ç");
				this.investSimulationPageObject.valueInvestTextField().sendKeys("ç");
			} else if (fieldType.toUpperCase().equals("TEMPO")) {
				this.investSimulationPageObject.timeFrameTextField().sendKeys("-");
				this.investSimulationPageObject.timeFrameTextField().sendKeys(Keys.TAB);
			} else {
				throw new java.lang.Error(
						"Não foi possível identificar a variável do tipo: string >>> Valor atribuito a variável: "
								+ fieldType);
			}
		} catch (Throwable error) {
			Report.logFail(
					"Erro ao inserir caracteres não permitidos nos campos obrigatórios! >>> Erro encontrado: " + error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}

	@Então("não deve ser permitido inserir estes tipos de caracteres nos campos de tipo {string}")
	public void valideInvalidTypeCaracter(String fieldType) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(this.investSimulationPageObject.getDriver(), 3);
			if (fieldType.toUpperCase().equals("VALOR")) {
				wait.until(ExpectedConditions.visibilityOf(investSimulationPageObject.errorValueMessageLabel()));

				Assert.assertEquals("Valor mínimo de 20.00",
						investSimulationPageObject.errorValueMessageLabel().getText());
			} else if (fieldType.toUpperCase().equals("TEMPO")) {
				wait.until(ExpectedConditions.visibilityOf(investSimulationPageObject.errorTimeFrameMessageLabel()));

				Assert.assertEquals("Valor esperado não confere",
						investSimulationPageObject.errorTimeFrameMessageLabel().getText());
			} else {
				throw new java.lang.Error(
						"Não foi possível identificar a variável do tipo: string >>> Valor atribuito a variável: "
								+ fieldType);
			}
		} catch (Throwable error) {
			Report.logFail(
					"Erro ao validar se os caracteres não permitidos foram inseridos nos campos obrigatórios! >>> Erro encontrado: "
							+ error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}

	}

	@Quando("inserir o dado de entrada da coluna {string} com o valor {int}")
	public void insertEspecificValues(String column, int fieldValue) throws Throwable {
		try {
			if (column.toUpperCase().equals("APLICAR")) {
				this.investSimulationPageObject.valueApplyTextField().sendKeys(String.valueOf(fieldValue));

			} else if (column.contentEquals("POUPAR")) {
				this.investSimulationPageObject.valueInvestTextField().sendKeys(String.valueOf(fieldValue));
			} else {
				throw new java.lang.Error(
						"Não foi possível identificar a variável do tipo: string >>> Valor atribuito a variável: "
								+ column);
			}

			this.investSimulationPageObject.timeFrameTextField().clear();
			this.investSimulationPageObject.timeFrameTextField().sendKeys("30");
		} catch (Throwable error) {
			Report.logFail(
					"Erro ao validar se os caracteres não permitidos foram inseridos nos campos obrigatórios! >>> Erro encontrado: "
							+ error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}

	}

	@Então("não é possivel visualizar o formulário de simulação")
	public void não_é_possivel_visualizar_o_formulário_de_simulação() throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(this.investSimulationPageObject.getDriver(), 3);

			try {
				wait.until(ExpectedConditions
						.elementToBeClickable(this.investSimulationPageObject.repeatSimulationButton()));
			} catch (Exception e) {
			   //Expected exception, do nothing
			}

			Assert.assertFalse(this.investSimulationPageObject.repeatSimulationButton().isDisplayed());
		} catch (Throwable error) {
			Report.logFail(
					"Erro ao validar se é possível vizualisar o formulário de simulação! >>> Erro encontrado: " + error,
					ScreenShot.capture(this.investSimulationPageObject.getDriver()));
			error.printStackTrace();
		}
	}
}
