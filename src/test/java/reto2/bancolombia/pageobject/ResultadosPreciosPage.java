package reto2.bancolombia.pageobject;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class ResultadosPreciosPage extends PageObject {

	private static ArrayList<Integer> preciosDeVuelos = new ArrayList<>();

	public void obtenerInfoValorVuelos() {
		for (int j = 1; j < 8; j++) {
			WebElement controlHtml = getDriver().findElement(By.xpath("//*[@id='clusters']/span[" + j
					+ "]/span/cluster/div/div/span/fare/span/span/div[1]/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]"));
			String precio = controlHtml.getText();
			preciosDeVuelos.add(Integer.parseInt(controlHtml.getText().replace(".", "")));
		}
		// Coleccion ordenada de los precios de vuelos
		Collections.sort(preciosDeVuelos);
	}

	public void escribirResultadosExcel() throws Exception {
		String excelFileName = "C:/Users/cesvelez/workspace/reto2.bancolombia/ArchivoPrecios.xls";
		String sheetName = "PreciosVuelos";
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(sheetName);

		for (int i = 0; i <= preciosDeVuelos.size() - 1; i++) {
			HSSFRow row = sheet.createRow(i);
			int precios = preciosDeVuelos.get(i);
			HSSFCell cell = row.createCell(0);

			if (i == 0) {
				HSSFCellStyle style = workBook.createCellStyle();
				HSSFFont fuente = workBook.createFont();
				fuente.setColor(HSSFColor.GREEN.index);
				style.setFont(fuente);
				cell.setCellStyle(style);
			}
			cell.setCellValue(String.valueOf(precios));
		}
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		workBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public boolean vericarResultadoEsperado(String orientacion, String resultadoEsperado) {
		boolean resultado = false;
		String mensajeOptenido = null;
		switch (orientacion) {
		case "Acierto":
			WebElement lblMensaje = getDriver().findElement(By.xpath(
					"//*[@class='fare-couchmark-tooltip fare-box-container product-NONE']/span/span/div[1]/item-fare/p/em[1]"));
			mensajeOptenido = lblMensaje.getText().trim();
			if (mensajeOptenido.equals(resultadoEsperado)) {
				System.out.println(lblMensaje.getText());
				resultado = true;
			}
			break;

		case "Error":
			break;
		}

		return resultado;
	}
	
}
