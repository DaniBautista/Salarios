import java.util.Vector;

public class Ordenamiento 
{	
	////(1)intercambia dos posiciones en un vector double
	public static void intercambio(Salario vector[], int posicion1, int posicion2)
	{
		//si mayores que vector length -1
		if(posicion1 > vector.length - 1)
		{
			return;
		}
		if(posicion2 > vector.length - 1)
		{
			return;
		}
		//si son menores que 0
		if (posicion1 < 0)
		{
			return;
		}
		if (posicion2 < 0)
		{
			return;
		}
								
		Salario pos = null;
		pos = vector[posicion1];
		vector[posicion1] = vector[posicion2];
		vector[posicion2] = pos;
	}

	public static int posmenorVector1(Salario vector[], int li,int ls, String comparador)
	{
		if(vector.length <= 0 )
		{
			return 0;
		}
		Salario minimo = vector[li];
		int pos = li; //teniamos el -1 pero causa error en otas pruebas, se,lo cambiamos a 0(ï¿½ï¿½ï¿½ï¿½aguanten hay que analizar este pedo!!!)
		for(int i=li; i<= ls; i++)
		{
			if (minimo.compareTo(vector[i], comparador) > 0)
			{///nos esta dicicendo que se va acomodar de mayor a menor 
				minimo = vector[i];
				pos= i;
			}
			///if(pos==-1){
				//return 0;
			//}
		}
		return pos;
	}

	///Ordena el vector comparando las cadenas string de las propiedades que se asignan en el método compareTo.
	public static void ordenarSeleccionMenor(Salario vector[], String comparador)
	{
		int ls=vector.length-1;
		int rojo =0;//indice vector ordenado
		int azul =-1; //posicion menor
		//for (rojo =0; rojo < ls; rojo++)
		for (rojo=0; rojo <vector.length-1; rojo++)
		{
			//le quitamos una posicion para no hacer la comparacion 
			//azul =rojo;
			//localizar menor 
			azul = Ordenamiento.posmenorVector1(vector,rojo,ls, comparador);
			//if(!(azul == rojo)){
			if(azul != rojo)
			{
				//intercambio
				Ordenamiento.intercambio(vector,rojo,azul);
			}
		}
		Ordenamiento.imprimirVector(vector);
		/*
		if (comparador == "Ciudad") 
		{
			for (int i = 0; i < vector.length; i++) 
			{
				System.out.println(vector[i].ObtenerCiudad());
			}
		}
		else 
		{
			for (int i = 0; i < vector.length; i++) 
			{
				System.out.println(vector[i].ObtenerGenero());
			}
		}
		//*/
	}

	///Obtiene el valor mínimo del vector / arreglo.
	public static int menorVector1(int vector[])
	{
		if(vector.length <= 0 )
		{
			return 0;
		}
		int minimo = vector[0];

		for(int i = 0; i < vector.length; i++)
		{
			if (minimo > vector[i])
			{
				minimo = vector[i];
			}
		}
		return minimo;
	}

	public static void imprimirVector(Salario vector[])
	{
		for (int  i= 0; i < vector.length; i++)
		{
			System.out.print("#" + (i + 1));
			System.out.print(" $"+ vector[i].ObtenerSalario());
			System.out.print(" edad: "+ vector[i].ObtenerEdad());
			System.out.print(" exp: "+ vector[i].ObtenerExperiencia());
			System.out.print(" ciudad: "+ vector[i].ObtenerCiudad());
			System.out.println(" genero: "+ vector[i].ObtenerGenero());
		}
	}
	
	//Ordenamiento shell para enteros
	public static void shell(int vectorEnteros[])
	{
		int salto, aux, i;
		boolean cambios;
		for(salto=vectorEnteros.length/2; salto!=0; salto/=2)
		{
			cambios=true;
			while(cambios)
			{ // Mientras se intercambie algún elemento
   		        cambios=false;
				for(i=salto; i< vectorEnteros.length; i++)
				{ // se da una pasada
					if(vectorEnteros[i-salto]>vectorEnteros[i])
					{ // y si están desordenados
   		                aux=vectorEnteros[i]; // se reordenan
   		                vectorEnteros[i]=vectorEnteros[i-salto];
   		                vectorEnteros[i-salto]=aux;
   		                cambios=true; // y se marca como cambio.
					}
				}
			}
		}   
		for (int j = 0; j < vectorEnteros.length; j++)
		{
			System.out.println(vectorEnteros[j]);
		}
	}

	public static void shell(Salario salariosVector[], String criterio)
	{
		int salto, i;
		Salario aux;
		boolean cambios;
		for (salto = salariosVector.length/2; salto != 0; salto/=2) 
		{
			cambios = true;
			while (cambios) 
			{
				cambios = false;
				for ( i = salto; i < salariosVector.length; i++) 
				{
					switch (criterio) 
					{
						case "Salario":
							if (salariosVector[i - salto].ObtenerSalario() > salariosVector[i].ObtenerSalario()) 
							{
								aux = salariosVector[i];
								salariosVector[i] = salariosVector[i - salto];
								salariosVector[i - salto] = aux;
								cambios = true;
							}
							break;
						case "Edad":
							if (salariosVector[i - salto].ObtenerEdad() > salariosVector[i].ObtenerEdad()) 
							{
								aux = salariosVector[i];
								salariosVector[i] = salariosVector[i - salto];
								salariosVector[i - salto] = aux;
								cambios = true;
							}
							break;
						default://Default = "Experiencia."
							if (salariosVector[i - salto].ObtenerExperiencia() > salariosVector[i].ObtenerExperiencia()) 
							{
								aux = salariosVector[i];
								salariosVector[i] = salariosVector[i - salto];
								salariosVector[i - salto] = aux;
								cambios = true;
							}
							break;
					}
				}	
			}
		}
		Ordenamiento.imprimirVector(salariosVector);
	}
	
	///Ordenamiento de string por el metodo de Seleccion.
	public static void ordenarSeleccionSalarios(Salario vector[], String comparador)
	{
		int posicionMenor = Ordenamiento.posmenorVector1(vector, 0, vector.length - 1, comparador);//se manda a llamar metodo posmenorVector1
		for (int i = 0; i < vector.length; i++) //recorre nuestro arreglo vector
		{
			if (vector[posicionMenor].ObtenerSalario() < vector[i].ObtenerSalario()) //comparacion del valor menor 
			{
				Ordenamiento.intercambio(vector, posicionMenor, i);
			}
		}
		Ordenamiento.imprimirVector(vector);
	}

	///Ordena un arreglo enteros por el metodo seleccion.
	public static void ordenar(int arreglo[], int inicio){
		if(inicio < arreglo.length){
			int posicionNumeroMenor = buscarPosicionNumeroMenor(arreglo, inicio);

			// se intercambian las posiciones
			int auxiliar = arreglo[inicio];
			arreglo[inicio] = arreglo[posicionNumeroMenor];
			arreglo[posicionNumeroMenor] = auxiliar;

			// invocacion recursiva
			// continua comparando los numeros del arreglo
			ordenar(arreglo, inicio + 1);
			// pero descartando la posicion de inicio 0,1,2...
		} else {
			// muestra el arreglo ordenado con seleccion

			for (int i = 0; i < arreglo.length; i++) {
				System.out.println(arreglo[i]);
			}
		}
	}

	/// Busca la posicion del numero menor de un arreglo de enteros.
	public static int buscarPosicionNumeroMenor(int arreglo[], int inicio) {
		//por ahora el menor es el primero
		int posicionNumeroMenor = inicio;
		int menor = arreglo[inicio];
		
		//la primera vez compara el segundo numero con el primero del arreglo
		for(int i = inicio+1;i < arreglo.length; i++){
			if(arreglo[i] < menor){
				menor = arreglo[i];
				posicionNumeroMenor = i;
			}
		}
		return posicionNumeroMenor;
	}

	//llena un vector de tipo entero, para ordenarlo usando Shell
	public static void ordenarUsandoShell(Salario[] salariosVector, String criterio) 
	{
		int vector[] = new int[salariosVector.length];
		
		for (int i = 0; i < vector.length; i++) 
		{
			switch (criterio) 
			{
				case "Salario":
				vector[i] = salariosVector[i].ObtenerSalario();
					break;
				case "Edad":
				vector[i] = salariosVector[i].ObtenerEdad();
					break;
				default: //Default: Experiencia.
				vector[i] = salariosVector[i].ObtenerExperiencia();
					break;
			}
		}
		//Se manda a llamar el metodo Shell
		Ordenamiento.shell(vector);
	}
}