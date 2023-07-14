package clase;

import java.util.Objects;

public class Autocar {

	private String matricula;
	private String marca;
	private String modelo;
	private int kilometros;
	private int num_plazas;
	
	public Autocar() {
		this.matricula="";
		this.marca="";
		this.modelo="";
		this.kilometros=0;
		this.num_plazas=0;
	
	}
		
	public Autocar(String matricula, String marca, String modelo, int kilometros, int num_plazas) {
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
		this.kilometros=kilometros;
		this.num_plazas=num_plazas;
		
	}
		
		//getters y setters
		
		public String getmatricula() {
			return matricula;
			
		}

		public void setmatricula(String matricula) {
			this.matricula = matricula;
		}
		
		public String getmarca() {
			return marca;
			
		}
		
		public void setmarca(String marca) {
			this.marca = marca;
		}
		
		public String getmodelo() {
			return modelo;
			
		}
		
		public void setmodelo(String modelo) {
			this.marca = modelo;
		}
		
		public int getkilometros() {
			return kilometros;
			
		}
		
		public void setkilometros(int kilometros) {
			this.kilometros = kilometros;
			
		}
		
		public int getnumplazas() {
			return num_plazas;
			
		}
		
		public void setnum_plazas(int num_plazas) {
			this.num_plazas = num_plazas;
			
		}

		@Override
		public String toString() {
			return "Autocar [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometros="
					+ kilometros + ", num_plazas=" + num_plazas + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(matricula);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Autocar other = (Autocar) obj;
			return Objects.equals(matricula, other.matricula);
		}
		
}