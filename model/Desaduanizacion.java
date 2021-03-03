package model;

import java.util.Date;

public class Desaduanizacion {
	private int id_desaduanizacion;
	private String nombreproveedor;
	private String numerofactura;
	private Date fechafactura;
	private String moneda;
	private float importefactura;
	private Date fechatasacambio;
	private float tasacambio;
	private float importefacturaconvertido;
	private float costounitario;
	private float cantidadtransportada;
	private String materiaprima;
	private String material;
	private String tipodesaduanizacion;
	
	public int getId_desaduanizacion() {
		return id_desaduanizacion;
	}
	public void setId_desaduanizacion(int id_desaduanizacion) {
		this.id_desaduanizacion = id_desaduanizacion;
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
	public Date getFechafactura() {
		return fechafactura;
	}
	public void setFechafactura(Date fechafactura) {
		this.fechafactura = fechafactura;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public float getImportefactura() {
		return importefactura;
	}
	public void setImportefactura(float importefactura) {
		this.importefactura = importefactura;
	}
	public Date getFechatasacambio() {
		return fechatasacambio;
	}
	public void setFechatasacambio(Date fechatasacambio) {
		this.fechatasacambio = fechatasacambio;
	}
	public float getTasacambio() {
		return tasacambio;
	}
	public void setTasacambio(float tasacambio) {
		this.tasacambio = tasacambio;
	}
	public float getImportefacturaconvertido() {
		return importefacturaconvertido;
	}
	public void setImportefacturaconvertido(float importefacturaconvertido) {
		this.importefacturaconvertido = importefacturaconvertido;
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
	public String getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(String materiaprima) {
		this.materiaprima = materiaprima;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTipodesaduanizacion() {
		return tipodesaduanizacion;
	}
	public void setTipodesaduanizacion(String tipodesaduanizacion) {
		this.tipodesaduanizacion = tipodesaduanizacion;
	}
	
	public Desaduanizacion(int id_desaduanizacion, String nombreproveedor,
			String numerofactura, Date fechafactura, String moneda,
			float importefactura, Date fechatasacambio, float tasacambio,
			float importefacturaconvertido, float costounitario,
			float cantidadtransportada, String materiaprima, String material,
			String tipodesaduanizacion) {
		super();
		this.id_desaduanizacion = id_desaduanizacion;
		this.nombreproveedor = nombreproveedor;
		this.numerofactura = numerofactura;
		this.fechafactura = fechafactura;
		this.moneda = moneda;
		this.importefactura = importefactura;
		this.fechatasacambio = fechatasacambio;
		this.tasacambio = tasacambio;
		this.importefacturaconvertido = importefacturaconvertido;
		this.costounitario = costounitario;
		this.cantidadtransportada = cantidadtransportada;
		this.materiaprima = materiaprima;
		this.material = material;
		this.tipodesaduanizacion = tipodesaduanizacion;
	}
	
	public Desaduanizacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
