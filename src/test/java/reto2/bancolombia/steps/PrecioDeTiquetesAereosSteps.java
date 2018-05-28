package reto2.bancolombia.steps;

import org.fluentlenium.core.annotation.Page;

import reto2.bancolombia.pageobject.PrecioDeTiquetesAereosPage;
import reto2.bancolombia.pageobject.ResultadosPreciosPage;

public class PrecioDeTiquetesAereosSteps {
	
		@Page
		PrecioDeTiquetesAereosPage precioDeTiquetesAereosPage;
		@Page
		ResultadosPreciosPage resultadosPreciosPage; 
//		Ingreso a la pagina: https://www.despegar.com.co/ e ingreso a la opción de vuelo
	    public void ingresarAlaPagina()
	    {
	    	precioDeTiquetesAereosPage.open();
	    }
	    
	    public void ingresarDatosVuelo(String ciudadOrigen, String ciudadDestino, String fechaSalida, String fechaRegreso, String numeroPersonas) /*1throws InterruptedException*/{
//			Ingreso la ciudad origen "Medellín"  Medellín, Antioquia, Colombia
//			Ingreso la ciudad destino "Cartagena"
//			Ingreso la fecha de partida "01/09/2018"
//			Ingresar la fecha regreso "29/09/2018"
//			Ingresar el numero de Viajeros "2"
	    	precioDeTiquetesAereosPage.ingresoDatos(ciudadOrigen, ciudadDestino, fechaSalida, fechaRegreso, numeroPersonas);
	    }
	    
	    public void obtenerResultadoBusqueda(String orientaCaso, String resultadoEsperado) {
  
	    	
	    	switch (orientaCaso) {
			case "Acierto":
//		    	Resultado de la búsqueda de los vuelos aereos
		    	resultadosPreciosPage.obtenerInfoValorVuelos();	 
		    	resultadosPreciosPage.vericarResultadoEsperado(orientaCaso, resultadoEsperado);
		    	
				break;

			default:
//				precioDeTiquetesAereosPage.vericarResultadoEsperado();
				break;
			}
	    	
	    }
	    
	    public void escribirExcel() throws Exception{
//	    	Generar resultado en el Excel
	    	resultadosPreciosPage.escribirResultadosExcel();	    	
	    }
	    
//		Dar click en el boton buscar
//		Buscar los 10 precios más baratos de tiquetes

}
