package reto2.bancolombia.pageobject;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import groovyjarjarantlr.collections.List;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl("https://www.despegar.com.co/vuelos/")

public class PrecioDeTiquetesAereosPage extends PageObject {
	

	
	WebElement txtOrigen;
	WebElement txtDestino;
	WebElement txtFechaDePartida;
	WebElement txtFechaDeRegreso;
	WebElement txtNumeroDeViajeros;
	WebElement btnClick;
	WebElement txtPartida;
	WebElement txtRegreso;
	//String origen = "Medellín";
	//String destino = "Cartagena";
	String fechaSalida = "3 Septiembre 2018";
	String fechaRegreso = "29 Septiembre 2018";
	WebElement btnPopup;
	WebElement txtPasajeros;
	WebElement tbnBuscar;
	String numeroViajeros = "2";
		
	public void ingresoDatos() {
		try {
			
			// Popup aprovecha los beneficios
			btnPopup = getDriver().findElement(By.xpath("//span[@class='as-login-close as-login-icon-close-circled']"));
			btnPopup.click();
			// Origen
			txtOrigen = getDriver().findElement(By.xpath("//input[@placeholder='Ingresa desde dónde viajas']"));
			txtOrigen.clear();
			txtOrigen.sendKeys("Medellin");
			Thread.sleep(1000);
			txtOrigen.sendKeys(Keys.ENTER);
			System.out.println("Debug paso por el primer control Ciudad Origen");
			// Destino
			txtDestino = getDriver().findElement(By.xpath("//input[@placeholder='Ingresa hacia dónde viajas']"));
			txtDestino.clear();
			txtDestino.sendKeys("Cartagena");
			Thread.sleep(1000);
			txtDestino.sendKeys(Keys.ENTER);
			System.out.println("Debug paso por el segundo control Ciudad Destino");

			// Inicio Fecha partida
			txtPartida = getDriver().findElement(By.xpath("//input[@placeholder='Partida']"));
			txtPartida.click();
			Thread.sleep(1000);
			java.util.List<WebElement> listTodosMeses = getDriver().findElements(By.xpath("//div[@class='_dpmg2--months']/div"));
			
			salirPartida: for (WebElement elementMes : listTodosMeses) {
				String strAnio = fechaSalida.substring(0, 4).trim();
				String strMes = fechaSalida.substring(5, 7).trim();
				int intDia = Integer.parseInt(fechaSalida.substring(8, 10).trim());
				if (!elementMes.getAttribute("data-month").equals(strAnio + "-" + strMes)) {
					System.out.println(elementMes.getAttribute("data-month"));
					// WebElement linkNext =
					// getDriver().findElement(By.xpath("//div[@class='_dpmg2--controls-next']"));
					// linkNext.click();
					getDriver().findElement(By.xpath("//div[@class='_dpmg2--controls-next']")).click();

				} else {
					System.out.println(elementMes.getAttribute("data-month"));
					java.util.List<WebElement> listaTodosDias = getDriver()
							.findElements(By.xpath("//div[@data-month='" + strAnio + "-" + strMes + "']/div[4]/span"));
					for (WebElement elementDia : listaTodosDias) {
						if (Integer.parseInt(elementDia.getText()) == (intDia)) {
							elementDia.click();
							break salirPartida;
						}
					}
				}
			}
			
			
			// Fin Fecha partida

			// Inicio Fecha regreso
			txtRegreso = getDriver().findElement(By.xpath("//input[@placeholder='Regreso']"));
			// txtRegreso.click();

			// List<WebElement> listTodosMeses = getDriver()
			// .findElements(By.xpath("//div[@class='_dpmg2--months']/div"));
			salirRegreso: for (WebElement elementMes : listTodosMeses) {
				String strAnio = fechaRegreso.substring(0, 4).trim();
				String strMes = fechaRegreso.substring(5, 7).trim();
				int intDia = Integer.parseInt(fechaRegreso.substring(8, 10).trim());
				if (!elementMes.getAttribute("data-month").equals(strAnio + "-" + strMes)) {
					System.out.println(elementMes.getAttribute("data-month"));
					// WebElement linkNext =
					// getDriver().findElement(By.xpath("//div[@class='_dpmg2--controls-next']"));
					// linkNext.click();
					// getDriver().findElement(By.xpath("//div[@class='_dpmg2--controls-next']")).click();

				} else {
					System.out.println(elementMes.getAttribute("data-month"));
					java.util.List<WebElement> listaTodosDias = getDriver()
							.findElements(By.xpath("//div[@data-month='" + strAnio + "-" + strMes + "']/div[4]/span"));
					for (WebElement elementDia : listaTodosDias) {
						if (Integer.parseInt(elementDia.getText()) == (intDia)) {
							elementDia.click();
							break salirRegreso;
						}
					}
				}
			}
			// Fin Fecha regreso

			// Numero y clase
			txtPasajeros = getDriver().findElement(By.xpath("//div[@class='sbox-distri-container']/div[6]/div[2]"));
			txtPasajeros.click();
			Thread.sleep(1000);
			for (int i = 0; i < Integer.parseInt(numeroViajeros) - 1; i++) {
				getDriver().findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click();
			}

			// Boton buscar
			tbnBuscar = getDriver().findElement(By.xpath("//*[@id='searchbox-sbox-all-boxes']/div/div/div/div[3]/div[2]/div[4]/div/a"));
			tbnBuscar.click();
			System.out.println("Termiando de diligenciar el formulario de vuelos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}