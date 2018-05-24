package reto2.bancolombia.definition;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import reto2.bancolombia.pageobject.PrecioDeTiquetesAereosPage;
import reto2.bancolombia.steps.PrecioDeTiquetesAereosSteps;

public class PrecioDeTiquetesAereosDefiniton {

	@Steps
	PrecioDeTiquetesAereosSteps objSteps;

	@Given("^que ingreso a la pagina web despegar\\.com$")
	public void que_ingreso_a_la_pagina_web_despegar_com() throws Throwable {
		objSteps.ingresarAlaPagina();
	}

	@When("^ingreso a la informacion de vuelos$")
	public void ingreso_a_la_informacion_de_vuelos(List<String> data) throws Throwable {
		objSteps.ingresarDatosVuelo();
		//data.get(ind)
	}

	@Then("^verifico los precios de los vuelos$")
	public void verifico_los_precios_de_los_vuelos() throws Throwable {
	}
	
	/* Version 1 de Lenguaje Gherkin
	 * @Given("^que ingreso a la pagina web despegar\\.com  \"([^\"]*)\"$")
	 * public void que_ingreso_a_la_pagina_web_despegar_com(String arg1) throws
	 * Throwable { }
	 * 
	 * @When("^ingreso a la informacón de vuelos  origen \"([^\"]*)\",  destino \"([^\"]*)\",  fecha de partida \"([^\"]*)\", fecha regreso \"([^\"]*)\", numero de Viajeros \"([^\"]*)\", y hacer click en el bton buscar$"
	 * ) public void
	 * ingreso_a_la_informacón_de_vuelos_origen_destino_fecha_de_partida_fecha_regreso_numero_de_Viajeros_y_hacer_click_en_el_bton_buscar
	 * (String arg1, String arg2, String arg3, String arg4, String arg5) throws
	 * Throwable { }
	 * 
	 * @Then("^verifico los precios de los vuelos$") public void
	 * verifico_los_precios_de_los_vuelos() throws Throwable { }
	 */

}
