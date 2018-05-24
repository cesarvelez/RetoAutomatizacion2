package reto2.bancolombia.steps;

import org.fluentlenium.core.annotation.Page;

import reto2.bancolombia.pageobject.PrecioDeTiquetesAereosPage;

public class PrecioDeTiquetesAereosSteps {
	
		@Page
		PrecioDeTiquetesAereosPage objPage;
//		Ingreso a la pagina: https://www.despegar.com.co/ e ingreso a la opción de vuelo
	    public void ingresarAlaPagina()
	    {
	    	objPage.open();
	    }
//		Ingreso la ciudad origen "Medellín"  Medellín, Antioquia, Colombia
//		Ingreso la ciudad destino "Cartagena"
//		Ingreso la fecha de partida "01/09/2018"
//		Ingresar la fecha regreso "29/09/2018"
//		Ingresar el numero de Viajeros "2"

	    public void ingresarDatosVuelo() /*1throws InterruptedException*/{
	    	objPage.ingresoDatos();
	    }
	    
//		Dar click en el boton buscar
//		Buscar los 10 precios más baratos de tiquetes

}
