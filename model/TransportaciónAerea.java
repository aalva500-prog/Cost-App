package model;

import java.util.Date;

public class TransportaciónAerea {
	private int id_transportacion;
	private String nombreproveedor;
	private String numerofactura;
	private Date fechfactura;
	private float cantidadtransportada;
	private String moneda;
	private float importefactura;
	private Date fechaConversionEURaUSD;
	private float tasaconversion;
	private  float importefacturaconvertidoEURaUSD;
	private float costounitario;
	private int materiaprima;
	private int material;
	private String tipotransportacion;
	
	
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
	public Date getFechfactura() {
		return fechfactura;
	}
	public void setFechfactura(Date fechfactura) {
		this.fechfactura = fechfactura;
	}
	public float getCantidadtransportada() {
		return cantidadtransportada;
	}
	public void setCantidadtransportada(float cantidadtransportada) {
		this.cantidadtransportada = cantidadtransportada;
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
	public Date getFechaConversionEURaUSD() {
		return fechaConversionEURaUSD;
	}
	public void setFechaConversionEURaUSD(Date fechaConversionEURaUSD) {
		this.fechaConversionEURaUSD = fechaConversionEURaUSD;
	}
	public float getTasaconversion() {
		return tasaconversion;
	}
	public void setTasaconversion(float f) {
		this.tasaconversion = f;
	}
	public float getImportefacturaconvertidoEURaUSD() {
		return importefacturaconvertidoEURaUSD;
	}
	public void setImportefacturaconvertidoEURaUSD(
			float importefacturaconvertidoEURaUSD) {
		this.importefacturaconvertidoEURaUSD = importefacturaconvertidoEURaUSD;
	}
	public float getCostounitario() {
		return costounitario;
	}
	public void setCostounitario(float costounitario) {
		this.costounitario = costounitario;
	}
	public int getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(int materiaprima) {
		this.materiaprima = materiaprima;
	}
	public int getMaterial() {
		return material;
	}
	public void setMaterial(int material) {
		this.material = material;
	}
	public String getTipotransportacion() {
		return tipotransportacion;
	}
	public void setTipotransportacion(String tipotransportacion) {
		this.tipotransportacion = tipotransportacion;
	}
	public TransportaciónAerea(int id_transportacion, String nombreproveedor,
			String numerofactura, Date fechfactura, float cantidadtransportada,
			String moneda, float importefactura, Date fechaConversionEURaUSD,
			float tasaconversion, float importefacturaconvertidoEURaUSD,
			float costounitario, int materiaprima, int material,
			String tipotransportacion) {
		super();
		this.id_transportacion = id_transportacion;
		this.nombreproveedor = nombreproveedor;
		this.numerofactura = numerofactura;
		this.fechfactura = fechfactura;
		this.cantidadtransportada = cantidadtransportada;
		this.moneda = moneda;
		this.importefactura = importefactura;
		this.fechaConversionEURaUSD = fechaConversionEURaUSD;
		this.tasaconversion = tasaconversion;
		this.importefacturaconvertidoEURaUSD = importefacturaconvertidoEURaUSD;
		this.costounitario = costounitario;
		this.materiaprima = materiaprima;
		this.material = material;
		this.tipotransportacion = tipotransportacion;
	}
	
	
	public TransportaciónAerea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
