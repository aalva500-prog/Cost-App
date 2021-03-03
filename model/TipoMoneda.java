package model;

public class TipoMoneda {

	@Override
	public String toString() {
		return this.descripcion;
	}


	private int id_tipomoneda;
	private String descripcion;
	
	
	public TipoMoneda(int id_tipomoneda, String descripcion) {
		super();
		this.id_tipomoneda = id_tipomoneda;
		this.descripcion = descripcion;
	}


	public TipoMoneda() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_tipomoneda() {
		return id_tipomoneda;
	}


	public void setId_tipomoneda(int id_tipomoneda) {
		this.id_tipomoneda = id_tipomoneda;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
