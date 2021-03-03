package model;

public class TipoMateria {

	private int id_tipo;
	private String descripcion;
	
	
	public TipoMateria(int id_tipo, String descripcion) {
		super();
		this.id_tipo = id_tipo;
		this.descripcion = descripcion;
	}


	public TipoMateria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_tipo() {
		return id_tipo;
	}


	@Override
	public String toString() {
		return this.descripcion;
	}


	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
