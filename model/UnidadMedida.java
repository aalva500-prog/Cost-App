package model;

public class UnidadMedida {
private int id_unidad;
private String tipo;


public UnidadMedida(int id_unidad, String tipo) {
	super();
	this.id_unidad = id_unidad;
	this.tipo = tipo;
}


public UnidadMedida() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return this.tipo;
}


public int getId_unidad() {
	return id_unidad;
}


public void setId_unidad(int id_unidad) {
	this.id_unidad = id_unidad;
}


public String getTipo() {
	return tipo;
}


public void setTipo(String tipo) {
	this.tipo = tipo;
}



}
