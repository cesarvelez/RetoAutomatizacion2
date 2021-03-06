package reto2.bancolombia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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
	// String origen = "Medellín";
	// String destino = "Cartagena";
	// String fechaSalida = "01/09/2018";
	// String fechaRegreso = "29/09/2018";
	WebElement btnPopup;
	WebElement txtPasajeros;
	WebElement tbnBuscar;
	// String numeroViajeros = "2";

	public void ingresoDatos(String ciudadOrigen, String ciudadDestino, String fechaSalida, String fechaRegreso,
			String numeroPersonas) {
		try {

			// Popup aprovecha los beneficios
			btnPopup = getDriver().findElement(By.xpath("//span[@class='as-login-close as-login-icon-close-circled']"));
			btnPopup.click();
			// Origen
			txtOrigen = getDriver().findElement(By.xpath("//input[@placeholder='Ingresa desde dónde viajas']"));
			txtOrigen.clear();
			txtOrigen.sendKeys(ciudadOrigen);
			Thread.sleep(1500);
			txtOrigen.sendKeys(Keys.ENTER);
			System.out.println("Debug paso por el primer control Ciudad Origen");
			// Destino
			txtDestino = getDriver().findElement(By.xpath("//input[@placeholder='Ingresa hacia dónde viajas']"));
			txtDestino.clear();
			txtDestino.sendKeys(ciudadDestino);
			Thread.sleep(1500);
			txtDestino.sendKeys(Keys.ENTER);
			System.out.println("Debug paso por el segundo control Ciudad Destino");

			// Inicio Fecha partida
			txtPartida = getDriver().findElement(By.xpath("//input[@placeholder='Partida']"));
			txtPartida.click();
			Thread.sleep(1500);
			java.util.List<WebElement> listTodosMeses = getDriver()
					.findElements(By.xpath("//div[@class='_dpmg2--months']/div")); // seguimiento
																					// de
																					// este
																					// control**

			// seguimiento salirPartida**
			salirPartida: for (WebElement elementMes : listTodosMeses) {
				String strAnio = fechaSalida.substring(6, 10).trim();
				String strMes = fechaSalida.substring(3, 5).trim();
				int intDia = Integer.parseInt(fechaSalida.substring(0, 2).trim());
				if (!elementMes.getAttribute("data-month").equals(strAnio + "-" + strMes)) {
					System.out.println(elementMes.getAttribute("data-month"));
					// Seguimiento atriibuto data-month**
					// WebElement linkNext =
					// getDriver().findElement(By.xpath("//div[@class='_dpmg2--controls-next']"));
					// linkNext.click();
					getDriver().findElement(By.xpath("//div[@class='_dpmg2--controls-next']")).click();

				} else {
					System.out.println(elementMes.getAttribute("data-month"));
					java.util.List<WebElement> listaTodosDias = getDriver()
							.findElements(By.xpath("//div[@data-month='" + strAnio + "-" + strMes + "']/div[4]/span")); // Seguimiento
																														// de
																														// este
																														// control**
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
			Thread.sleep(1500);
			txtRegreso = getDriver().findElement(By.xpath("//input[@placeholder='Regreso']"));
			// txtRegreso.click();

			// List<WebElement> listTodosMeses = getDriver()
			// .findElements(By.xpath("//div[@class='_dpmg2--months']/div"));
			salirRegreso: 
				for (WebElement elementMes : listTodosMeses) {
				String strAnio = fechaRegreso.substring(6, 10).trim();
				String strMes = fechaRegreso.substring(3, 5).trim();
				int intDia = Integer.parseInt(fechaRegreso.substring(0, 2).trim());
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
			txtPasajeros = getDriver().findElement(By.xpath("//div[@class='sbox-distri-container']/div[6]/div[2]")); // Seguimiento
																														// a
																														// este
																														// control
																														// encontrado**
			txtPasajeros.click();
			Thread.sleep(1500);
			for (int i = 0; i < Integer.parseInt(numeroPersonas) - 1; i++) {
				getDriver()
						.findElement(
								By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]"))
						.click(); // Seguimiento a este control**
			}

			// Boton buscar
			tbnBuscar = getDriver().findElement(
					By.xpath("//*[@id='searchbox-sbox-all-boxes']/div/div/div/div[3]/div[2]/div[4]/div/a")); // Seguimiento
																												// a
																												// este
																												// control**
			tbnBuscar.click();
			Thread.sleep(3500);
			System.out.println("Termiando de diligenciar el formulario de vuelos");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}