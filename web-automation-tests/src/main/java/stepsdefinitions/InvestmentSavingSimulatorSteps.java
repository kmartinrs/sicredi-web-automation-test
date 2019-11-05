package stepsdefinitions;

import org.openqa.selenium.WebDriver;

import framework.Report;
import framework.ScreenShot;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pageobjects.InvestmentSavingSimulatorPageObjects;

public class InvestmentSavingSimulatorSteps {
	private WebDriver driver;
	private InvestmentSavingSimulatorPageObjects investSimulationPageObject;

	public InvestmentSavingSimulatorSteps(WebDriver driver) {
		this.driver = driver;
		this.investSimulationPageObject = new InvestmentSavingSimulatorPageObjects(driver);
	}

	@Dado("que realizei a seleção de uma das opções do perfil")
	public void selectProfileType() throws Throwable {
		try {
			this.investSimulationPageObject.forYouRadioBox().click();
		} catch (Throwable error) {
			Report.logFail("Não foi possível selecionar a opção de perfil: para você! >>> Erro encontrado: " + error,
					ScreenShot.capture(driver));
			error.printStackTrace();
		}
	}

	@Dado("realizei o preenchimento dos campos obrigatórios")
	public void addValueToRequiredFields(String valueApply, String valueInvest, String timeFrame) {
		try {
			this.investSimulationPageObject.valueApplyTextField().sendKeys(valueApply);
			this.investSimulationPageObject.valueInvestTextField().sendKeys(valueInvest);
			this.investSimulationPageObject.timeFrameTextField().sendKeys(timeFrame);
		} catch (Throwable error) {
			Report.logFail("Erro ao preencher campos obrigatórios! >>> Erro encontrado: " + error,
					ScreenShot.capture(driver));
			error.printStackTrace();
		}

	}

	@Quando("executo o clique no botão simular")
	public void clickOnSimulateButton() {
		try {
			this.investSimulationPageObject.simulateButton().click();
		} catch (Throwable error) {
			Report.logFail("Erro ao executar clique no botão Simular! >>> Erro encontrado: " + error,
					ScreenShot.capture(driver));
			error.printStackTrace();
		}
	}

	@Dado("não realizei o preenchimento dos campos obrigatórios")
	public void dontAddValueToRequiredFields() {
		try {
			this.investSimulationPageObject.valueApplyTextField().clear();
			this.investSimulationPageObject.valueInvestTextField().clear();
			this.investSimulationPageObject.timeFrameTextField().clear();
		} catch (Throwable error) {
			Report.logFail(
					"Erro ao realizar a tentativa do não preenchimento dos campos obrigatórios! >>> Erro encontrado: "
							+ error,
					ScreenShot.capture(driver));
			error.printStackTrace();
		}
	}


	@Então("é possivel visualizar o formulário de simulação")
	public void é_possivel_visualizar_o_formulário_de_simulação() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


	@Então("uma mensagem de aviso sobre a obrigatoriedade de preenchimento dos campos deve ser apresentada")
	public void uma_mensagem_de_aviso_sobre_a_obrigatoriedade_de_preenchimento_dos_campos_deve_ser_apresentada() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Quando("realizo a tentativa de inserir caracteres não permitidos nos campos de tipo {string}")
	public void realizo_a_tentativa_de_inserir_caracteres_não_permitidos_nos_campos_de_tipo(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Então("não deve ser permitido inserir estes tipos de caracteres")
	public void não_deve_ser_permitido_inserir_estes_tipos_de_caracteres() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Quando("inserir o dado de entrada da coluna <aplicar>")
	public void inserir_o_dado_de_entrada_da_coluna_aplicar() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Quando("inserir o dado de entrada da coluna <poupar>")
	public void inserir_o_dado_de_entrada_da_coluna_poupar() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Então("a coluna <resultado> deve retornar com o estado esperado")
	public void a_coluna_resultado_deve_retornar_com_o_estado_esperado() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Então("é possível realizar clique no botão refazer a simulação")
	public void é_possível_realizar_clique_no_botão_refazer_a_simulação() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}