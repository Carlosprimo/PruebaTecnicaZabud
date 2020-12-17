package zabud.pruebaTecnica.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alcancia")
public class moneda {
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name="nombre", nullable = false,length = 50)
		private String nombre;
		
		@Column(name="cantidad")
		private int cantidad;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		@Override
		public String toString() {
			return "moneda [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + "]";
		}
}
