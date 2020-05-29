import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) 
    {
        //Leer un archivo con formatos.
        ///Scanner es una herramienta para leer datos en espera de la consola.
        Scanner lectorEnConsola = new Scanner(System.in);
        
        ///archivos es una clase externa que utiliza java.io.* para leer un archivo de entrada.
        archivos archivo = new archivos();
        System.out.println("Elige un archivo CSV de tu equipo y copialo aqui.");//Consola imprime el texto.
        String direccion1 = lectorEnConsola.nextLine();//direccion es la ubicacion del archivo de entrada.
        String direccion = direccion1.replaceAll("\"", "");

        ///texto es la variable que extrae el contenido del archivo.
        //*String texto = archivo.leerTxt("C:\\Users\\Dani\\Downloads\\ENE-FEB_2020\\EST. Y ORG. DE DATOS\\prueba\\answers.csv");
        String texto = archivo.leerTxt(direccion);//Busca el archivo.
        
        String[] datos = texto.split(",");//Convierte a arreglo de cadena de caracteres utilizando el separador , o "
        
        
        int cantidadDatos = Integer.parseInt(datos[1]);//Obtiene de la fila 2 del archivo el n�mero de datos que contiene.
        int indiceDatos = 7;//Indice para obtener los datos correspondientes.
		
        Salario salariosVector[] = new Salario[cantidadDatos]; //Crear nueva instancia Salario como vector.
		
		//new Salario(salario,edad,experiencia,ciudad,genero),
		for (int i = 0; i < cantidadDatos; i++)
		{
			 salariosVector[i] = new Salario(
			 	Integer.parseInt(datos[indiceDatos]), //Salario: monto.
			 	Integer.parseInt(datos[indiceDatos + 1]),//Edad.
			 	Integer.parseInt(datos[indiceDatos + 2]), //Experiencia.
			 	datos[indiceDatos + 3], //Ciudad.
			 	datos[indiceDatos + 4]); //Género.
			 
			 indiceDatos = indiceDatos + 5; //índice de datos del documento.
        }
        System.out.println("\t\t\tBIENVENIDO A PROGRAMA SALARIOS VECTOR."
        +"\n\t1.- Imprimir datos del vector original."
        +"\n\t2.- Imprimir vector ordenado por salarios."
        +"\n\t3.- Imprimir vector ordenado por edades."
        +"\n\t4.- Imprimir vector ordenado por experiencias."
        +"\n\t5.- Imprimir vector ordenado por ciudades."
        +"\n\t6.- Imprimir vector ordenado por géneros."
        +"\n\t0.- Salir.");
        int opcion = Integer.parseInt(lectorEnConsola.nextLine());
        while (opcion != 0) 
        {
            switch (opcion) 
            {
                case 1:
                    System.out.println("\n\t\t***VECTOR SALARIOS ORIGINAL.***");
                    Ordenamiento.imprimirVector(salariosVector);

                    break;
                case 2:
                    System.out.println("\n\t\t***ORDENANDO SALARIOS.***");
                    Ordenamiento.shell(salariosVector, "Salario");
                    break;
                case 3:
                    System.out.println("\n\t\t***ORDENANDO EDADES.***");
                    Ordenamiento.shell(salariosVector, "Edad");
                    break;
                case 4:
                    System.out.println("\n\t\t***ORDENANDO EXPERIENCIAS.***");
                    Ordenamiento.shell(salariosVector, "Experiencia");
                    break;
                case 5:
                    System.out.println("\n\t\t***ORDENANDO CIUDADES.***");
                    Ordenamiento.ordenarSeleccionMenor(salariosVector, "Ciudad");
                    break;
                case 6:
                    System.out.println("\n\t\t***ORDENANDO GENEROS.***");
                    Ordenamiento.ordenarSeleccionMenor(salariosVector, "Genero");
                    break;
                default:
                    System.out.println("Opción no existente, elija una opción válida del menú.");
                    break;
            }
            System.out.println("\t\t\tBIENVENIDO A PROGRAMA SALARIOS VECTOR." + "\n\t1.- Imprimir datos del vector original."
                    + "\n\t2.- Imprimir vector ordenado por salarios." + "\n\t3.- Imprimir vector ordenado por edades."
                    + "\n\t4.- Imprimir vector ordenado por experiencias."
                    + "\n\t5.- Imprimir vector ordenado por ciudades." + "\n\t6.- Imprimir vector ordenado por géneros."
                    + "\n\t0.- Salir.");
            opcion = Integer.parseInt(lectorEnConsola.nextLine());
            //Procedimiento para borrar la consola en Java obtenido de: https://www.lawebdelprogramador.com/foros/Java/1309023-limpiar-consola-java.html
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Proceso para borrar la consola.
            } catch (Exception e) {
                /* No hacer nada */
            }
        }
        //Ordenamiento.imprimirVector(salariosVectorOrdenado);
		//*/

   }
}
