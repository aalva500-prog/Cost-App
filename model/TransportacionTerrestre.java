package model;

import java.util.Date;

public class TransportacionTerrestre {
	private int id_transportacion;
	private String nombreproveedor;
	private String numerofactura;
	private String moneda;
	private float imprtefactura;
	private Date fechafactura;
	private Date fechatasaCAmbio;
	private float tasaCAmbio;
	private float importeconvertido;
	private float costounitario;
	private float cantidadtrans;
	
	public float getCantidadtrans() {
		return cantidadtrans;
	}
	public void setCantidadtrans(float cantidadtrans) {
		this.cantidadtrans = cantidadtrans;
	}
	public int getId_transportacion() {
		return id_transportacion;
	}
	public void setId_transportacion(int id_transportacion) {
		this.id_transportacion = id_transportacion;
	}
	public String getNombreproveedor() {
		return nombreproveedor;
	}
	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}
	public String getNumerofactura() {
		return numerofactura;
	}
	public void setNumerofactura(String numerofactura) {
		this.numerofactura = numerofactura;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public float getImprtefactura() {
		return imprtefactura;
	}
	public void setImprtefactura(float imprtefactura) {
		this.imprtefactura = imprtefactura;
	}
	public Date getFechafactura() {
		return fechafactura;
	}
	public void setFechafactura(Date fechafactura) {
		this.fechafactura = fechafactura;
	}
	public Date getFechatasaCAmbio() {
		return fechatasaCAmbio;
	}
	public void setFechatasaCAmbio(Date fechatasaCAmbio) {
		this.fechatasaCAmbio = fechatasaCAmbio;
	}
	public float getTasaCAmbio() {
		return tasaCAmbio;
	}
	public void setTasaCAmbio(float tasaCAmbio) {
		this.tasaCAmbio = tasaCAmbio;
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
	
	public TransportacionTerrestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransportacionTerrestre(int id_transportacion,
			String nombreproveedor, String numerofactura, String moneda,
			float imprtefactura, Date fechafactura, Date fechatasaCAmbio,
			float tasaCAmbio, float importeconvertido, float costounitario,
			float cantidadtrans) {
		super();
		this.id_transportacion = id_transportacion;
		this.nombreproveedor = nombreproveedor;
		this.numerofactura = numerofactura;
		this.moneda = moneda;
		this.imprtefactura = imprtefactura;
		this.fechafactura = fechafactura;
		this.fechatasaCAmbio = fechatasaCAmbio;
		this.tasaCAmbio = tasaCAmbio;
		this.importeconvertido = importeconvertido;
		this.costounitario = costounitario;
		this.cantidadtrans = cantidadtrans;
	}
	
	

}
