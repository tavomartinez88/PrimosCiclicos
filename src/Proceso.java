/***
Clase : Proceso
@author : Gustavo Martinez
@version: 0.0.1

Esta clase es una extension de la clase Thread, la cual modela un hilo de ejecucion, donde la finalidad es
poder detectar aquellos numeros primos que son ciclicos y aquellos que no lo son.

Donde aquellos numeros primos que no son ciclicos son marcados con 0 para identificarlos de aquellos que si lo son.
*/

public class Proceso extends Thread{


	//atributos
	private int [] arreglo;
	private int desde;
	private int hasta;
	private int countDigit;
	


	//constructor
	public Proceso(String name, int from, int to, int [] a, int count_digit){
		// TODO Auto-generated constructor stub
		super(name);
		desde=from;
		hasta=to;
		arreglo=a;
		countDigit=count_digit;
	}


	//metodo que calcula el factorial de un numero.
	private int getFactorial (int n){
		int result;
		if(n==1||n==0)
			return 1; 
		result = getFactorial(n-1)*n;
		return result;
	}
	
	//metodo que genera una permutacion de una secuencia
	private String[] permutacion(String cadena){
		int n = cadena.length();
		String temporal="";
		String[] vector = new String[n];
		vector[0]=cadena;
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(j==n-1)
						temporal = cadena.charAt(j)+temporal;
				else temporal += cadena.charAt(j);
			}
			cadena=temporal;
			vector[i]=temporal;
			temporal="";
		}
		return vector;
	}


	//metodo que genera las permutaciones de una secuencia.
	private  String[]  permutar(String cadena,int p){
		String[] per=new String[p];
		int l = cadena.length();
		String[] aux = permutacion(cadena);
		int pos =0;
 
		if(p==1||l==1)
		{
			per[0] = cadena;
			return per;
		}
 
		for(int i=0;i<aux.length;i++)
		{
			String[] auxiliar = permutar(aux[i].substring(1),getFactorial(l-1)); 
			for(int j=0;j<auxiliar.length;j++)
			{
				per[pos]=aux[i].charAt(0)+auxiliar[j];
				pos++;
			}			
		}
		return per;
	}	

	//metodo que devuelve todas las permutaciones de un numero a traves de un arreglo de enteros
	private int [] getPermutations(int n){
		String numero_cadena = Integer.toString(n);
		int pr = getFactorial(numero_cadena.length());
		String [] ne= permutar(numero_cadena, pr);
		int [] numeros = new int [ne.length];
		for (int i = 0; i < ne.length; i++){
			numeros[i]=Integer.parseInt(ne[i]);
		}
		return numeros;
	}


	//metodo que verifica si un numero es primo utilizando la definicion de numero primo
	private boolean isPrime(int n){
		for (int i = 2; i < n; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	//metodo que dispara el Thread
	public void run(){
		int [] arr_aux = new int [hasta-desde];
		for (int i = desde; i <= hasta; i++) {
			arr_aux = getPermutations(arreglo[i]);
			for (int k = 1; k < arr_aux.length; k++) {
				if (!isPrime(arr_aux[k])){
					arreglo[i]=0;
				}
			}
			
		}
	}
}
