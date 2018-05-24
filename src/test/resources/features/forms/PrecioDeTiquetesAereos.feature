@Regresion
Feature: Buscar los 10 precios más baratos de tiquetes en el siguiente enlace 
 				 https://www.despegar.com.co/
 				 Origen: Medellín Destino: 
 				 Cartagena Viajeros: dos personas 
 				 Fecha Inicio: 01/09/2018 
 				 Fecha Regreso: 29/09/2018 
 				 Guardar en Excel los 7 precios más baratos de la primera página del sitio. 
 				 Marcar en verde el precio más económico.
  
  @TestCase1
  Scenario Outline: Buscar los 10 precios más baratos de tiquetes aereos.
    Given que ingreso a la pagina web despegar.com
   	When  ingreso a la informacion de vuelos
   				|<origen>|<destino>|<fecha de partida>|<fecha regreso>|<numero de Viajeros>| 
    Then  verifico los precios de los vuelos 
    
    	Examples:
			|origen  |destino  |fecha de partida|fecha regreso    |numero de Viajeros|
		  |Medellin|Cartagena|Sáb, 1 sep 2018 |Sáb, 29 sep 2018 | 2								 |
        

		 