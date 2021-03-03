package model;

import java.util.Date;

public class Aduana {
private int id_aduana;
private float imprteDOP;
private Date fecha;
private float tasacambio;
private float importeconvertido;
private float costounitario;
private float cantidadtransportada;
public int getId_aduana() {
	return id_aduana;
}
public void setId_aduana(int id_aduana) {
	this.id_aduana = id_aduana;
}
public float getImprteDOP() {
	return imprteDOP;
}
public void setImprteDOP(float imprteDOP) {
	this.imprteDOP = imprteDOP;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public float getTasacambio() {
	return tasacambio;
}
public void setTasacambio(float tasacambio) {
	this.tasacambio = tasacambio;
}
public float getImporteconvertido() {
	return importeconvertido;
}
public void setImporteconvertido(float importeconvertido) {
	this.importeconvertido = importeconvertido;
}
public float getCostounitario() {
	return costounitario;
}
public void setCostounitario(float costounitario) {
	this.costounitario = costounitario;
}
public float getCantidadtransportada() {
	return cantidadtransportada;
}
public void setCantidadtransportada(float cantidadtransportada) {
	this.cantidadtransportada = cantidadtransportada;
}
public Aduana(int id_aduana, float imprteDOP, Date fecha, float tasacambio,
		float importeconvertido, float costounitario, float cantidadtransportada) {
	super();
	this.id_aduana = id_aduana;
	this.imprteDOP = imprteDOP;
	this.fecha = fecha;
	this.tasacambio = tasacambio;
	this.importeconvertido = importeconvertido;
	this.costounitario = costounitario;
	this.cantidadtransportada = cantidadtransportada;
}
public Aduana() {
	super();
	// TODO Auto-generated constructor stub
}


}
