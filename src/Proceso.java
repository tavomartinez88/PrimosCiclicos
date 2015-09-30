/***
Clase : Proceso
@author : Gustavo Martinez
@version: 0.0.1

Esta clase es una extension de la clase Thread, la cual modela un hilo de ejecucion, donde la finalidad es
poder detectar aquellos numeros primos que son ciclicos y aquellos que no lo son.

Donde aquellos numeros primos que no son ciclicos son marcados con 0 para identificarlos de aquellos que si lo son.
*/
import java.util.Arrays;
public class Proceso extends Thread{


	//atributos
	private int [] arreglo;
	private int desde;
	private int hasta;
	private int countDigit;
	


	//constructor
	public Proceso(String name, int from, int to, int [] a){
		// TODO Auto-generated constructor stub
		super(name);
		desde=from;
		hasta=to;
		arreglo=a;
		
	}

	public static int[] getCircular(int n){
        char[] nString = Integer.toString(n).toCharArray();
        int[] array = new int[nString.length - 1];
        for (int i = 0; i < nString.length - 1; i++){
            char aux = nString[0];
            for (int j = 0; j < nString.length - 1; j++){
                nString[j] = nString[j+1];
            }
            nString[nString.length - 1] = aux;
            array[i] = Integer.parseInt(String.valueOf(nString));
        }
        return array;
    }	


	//metodo que verifica si un numero es primo utilizando la definicion de numero primo
	private static boolean isPrime(int n){
		int i;
		for (i = 2; i < n; i++) {
			if (n%i==0) {
				break;
			}
		}
		if (i==n) {
			return true;	
		}
		else {
			return false;
		}
		
	}
	
	//metodo que dispara el Thread
	public void run(){
		//int [] arr_aux = new int [hasta-desde];
		for (int i = desde; i <= hasta; i++) {
			int [] c = getCircular(arreglo[i]);
			for (int k=0;k<c.length;k++) {
				if (!isPrime(c[k])) {
					arreglo[i]=0;
					
				}
			}			
		}
	}
}
