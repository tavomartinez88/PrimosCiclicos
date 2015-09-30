/***
Clase : Main
@author : Gustavo Martinez
@version: 0.0.1

Esta clase se encarga de la ejecución del programa principal y sus componentes.
*/

import java.util.Arrays;
public class Main {

	public static void main(final String[] args) {
		
		//probando con 100.000 se ve mas claro los resultados 
		PrimsCircles p = new PrimsCircles(100000);

		//probando con 1.000.000
		//PrimsCircles p = new PrimsCircles(1000000);
		//System.out.println(Arrays.toString(p.getPrimsCircles()));
		System.out.println(p.getPrimsCircles().length);
		int count =0;
		int [] arr = p.getPrimsCircles();
		for (int i=0;i<arr.length;i++){
			if (arr[i]!=0) {
				count++;
			}
		}
		System.out.println(count);
		


	}

}
