/***
Clase : PrimsCircles
@author : Gustavo Martinez
@version: 0.0.1



Esta clase se encarga de generar los numeros primos ciclicos y mostrarlos como asi tambien 
la cantidad de numeros primos ciclicos que se generan
*/

public class PrimsCircles {
	
		//atributos
		// limit es la cota superior a buscar numeros primos ciclicos
		private int limit;

		//constructor 
		PrimsCircles(int n){
			this.limit=n;
		}

		/*metodo que obtiene los numeros primos menores a n
		 (el metodo está basado en el algoritmo de la criba de eratostenes)
		*/
	    private int[] CalcSieve(int n){
	        n++;
	        int i, j, m=0;
	        int srn=(int)Math.sqrt(n);
	        int[] array= new int[n];
	        int[] primeList;
	        for (i=2;i<n;i++){
	            array[i]=i;
	        }
	        for (i=2;i<=srn;i++){
	            if (array[i]!=0){
	                j=i*i;
	                while (j<n){
	                    if (array[j]!=0){
	                        array[j]=0;
	                        j+=i;
	                        m++;
	                    }else{
	                        j+=i;
	                    }
	                }
	            }
	        }
	        j=0;
	        primeList= new int[n-m-2];
	        for (i=2;i<n;i++){
	            if (array[i]!=0){
	                primeList[j]=array[i];
	                j++;
	            }
	        }
	        return primeList;
	    }

	    //metodo que realiza la inicialización
	    private int [] init (){return CalcSieve(this.limit);}


	    /*metodo se encarga de obtener los primos ciclicos.
	    Se parte (creando limites) el arreglo donde se genera dicha particion a partir de la cantidad de digitos 
	    de cada numero.Luego se crea un thread por cada seccion , es decir un thread que buscara los primos ciclicos
		de dos digitos, otro thread para la seccion que contiene los numeros ciclicos de 3 digitos y asi sucesivamente
		luego retorna el arreglo de los primos ciclicos.
		Aclaración 1: considere a los numeros primos de 1 digito como numeros ciclicos
		Aclaración 2: con start() arranca el thread y con stop() finaliza.
	    */
	    private int [] getPrimsCircles(){
	    	int [] primos = init();
	    	int dos_cifrasD = 0,dos_cifrasH = 0;
	    	int tres_cifrasD = 0,tres_cifrasH = 0;
	    	int cuatro_cifrasD = 0,cuatro_cifrasH = 0;
	    	int cinco_cifrasD = 0,cinco_cifrasH = 0;
	    	int seis_cifrasD = 0,seis_cifrasH = 0;
	    	for (int i = 4; i < primos.length; i++) {
	    		if (primos[i]>10 && dos_cifrasD==0){dos_cifrasD=i;}
	    		if (primos[i]<100){dos_cifrasH=i;}
	    		
	    		if (primos[i]>100 && tres_cifrasD==0){tres_cifrasD=i;}
	    		if (primos[i]<1000){tres_cifrasH=i;}
	    		
	    		if (primos[i]>1000 && cuatro_cifrasD==0){cuatro_cifrasD=i;}
	    		if (primos[i]<10000){cuatro_cifrasH=i;}
	    		
	    		if (primos[i]>10000 && cinco_cifrasD==0){cinco_cifrasD=i;}
	    		if (primos[i]<100000){cinco_cifrasH=i;}
	    		
	    		if (primos[i]>100000 && seis_cifrasD==0){seis_cifrasD=i;}
	    		if (primos[i]<1000000){seis_cifrasH=i;}
			}
	    	Proceso hilo1 = new Proceso("Hilo2", dos_cifrasD, dos_cifrasH, primos, 2);
	    	Proceso hilo2 = new Proceso("Hilo3", tres_cifrasD, tres_cifrasH, primos, 3);
	    	Proceso hilo3 = new Proceso("Hilo4", cuatro_cifrasD, cuatro_cifrasH, primos, 4);
	    	Proceso hilo4 = new Proceso("Hilo5", cinco_cifrasD, cinco_cifrasH, primos, 5);
	    	Proceso hilo5 = new Proceso("Hilo6", seis_cifrasD, seis_cifrasH, primos, 6);
	    	hilo1.start();
	    	hilo2.start();
	    	hilo3.start();
	    	hilo4.start();
	    	hilo5.start();
	    	hilo1.stop();
	    	hilo2.stop();
	    	hilo3.stop();
	    	hilo4.stop();
	    	hilo5.stop();	    	

	    	//mostrar(primos);
	    	return primos;
	    }


	    /*
	    metodo que obtiene los primos ciclicos ciclicos y muestra la lista de los numeros ciclicos y 
	    la cantidad de numeros ciclicos.
	    */
	    public void obtenerPrimosCiclicos(){
	    	int [] c = getPrimsCircles();
	    	for (int i = 0; i < c.length; i++) {
	    		if (c[i]!=0) {
	    			System.out.println(c[i]);	
	    		}
				
			}
	    	System.out.println("La cantidad de num ciclicos : "+c.length);
	    }
	    
		
		
	
		
		
		
}
