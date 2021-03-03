package model;

public class Tipo {
private int id_tipo;
private String tipo;


public Tipo(int id_tipo, String tipo) {
	super();
	this.id_tipo = id_tipo;
	this.tipo = tipo;
}



@Override
public String toString() {
	return this.tipo;
}



public Tipo() {
	super();
	// TODO Auto-generated constructor stub
}



public int getId_tipo() {
	return id_tipo;
}
public void setId_tipo(int id_tipo) {
	this.id_tipo = id_tipo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}


}
