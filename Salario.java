public class Salario{
	
	//Propiedades, parámetros o valores.
	private int _salario;
	private int _edad; 
	private int _experiencia; 
	private String _ciudad;
	private String _genero;

	//Contructor set original para generar un new y guardar sus parámetros o valores.
	//Estructura de tipo Entidad: llamada Salario, con atributos|propiedades: salario, edad, experiencia, ciudad...
	public Salario (int salario, int edad, int experiencia, String ciudad, String genero)
	{
		this._salario = salario;
		this._edad = edad;
		this._experiencia = experiencia;
		this._ciudad = ciudad;
		this._genero = genero;
	}

	//constructor get copia con una sobrecarga de tipo Salario como parametro./
	//Para buscar un objeto que me devuelva sus parámetros o valores.
	public Salario(Salario sal)
	{
		this(
			sal.ObtenerSalario(),
			sal.ObtenerEdad(),
			sal.ObtenerExperiencia(),
			sal.ObtenerCiudad(),
			sal.ObtenerGenero()
			);
	}

	public int ObtenerSalario()
	{
		return this._salario;
	}

	public int ObtenerEdad()
	{
		return this._edad;
	}

	public int ObtenerExperiencia()
	{
		return this._experiencia;
	}

	public String ObtenerCiudad()
	{
		return this._ciudad;
	}

	public String ObtenerGenero()
	{
		return this._genero;
	}

	//ToString Convierte todos tús parámetros a una única cadena de carácteres.
	public String ToString()
	{
		String temporal = "";
		temporal = "$ " + _salario + " ";
		temporal += "Edad" + _edad + " ";
		temporal += "Experiencia" + _experiencia + " ";
		temporal += "Ciudad" + _ciudad + " ";
		temporal += "Genero" + _genero + " ";

		return temporal;
	}

	
	public int compareTo(Salario obj, String comparador)
	{
		int comp;
		if (comparador == "Ciudad") {
			comp = _ciudad.compareTo(obj.ObtenerCiudad());
		}
		else
		{
			comp = _genero.compareTo(obj.ObtenerGenero());
		}
		if (comp == 0)
		{
			return 0;
		}
		else if(comp < 0)
		{
			//1er nombre es menor
			return -1;
		}
		else
		{
			//1er nombre es mayor 
			return 1;
		}
	}
	//*/
}