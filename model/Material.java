package model;

import java.util.Date;

public class Material {
	private int id_material;
	private String origen;
	private String materiales;
	private String descripcion;
	private float costounitario;
	private String factura;
	private Date fecha;
	private String proveedor;
	private String unidad;
	private float cantidadcomprada;
	private float cantdadconvertida;
	private String moneda;
	private float importecompre;
	private float precioadquisicion;
	private Date fechatasaconversionEURaUSD;
	private float tasaconversionEURaUSD;
	private float precioadqusicionconvertidoEURaUSD;
	private Date fechatasacambioDOPaUSD;
	private float tasacambioDOPaUSD;
	private float precioadquisicionconvertidoDOPaUSD;
	private float CsotosMolde;
	private float cantidadtotalfacturada;
	private float precioAdquisicionUSDconMolde;
	private float precioAdquisicionconvertidoEURaUSDconMolde;
	private float precioadquisicionDOPaUSDconMolde;
	private float gastosvarios;
	private float precioAdquisicionUSDconGAStos;
	private float precioAdqusicionconvertidoEURaUSDconGastos;
	private float PrecioAdquisicionConvertidoDOPaUSDconGAstos;
	private float costounitariologistica;
	private String tipomaterial;
	
	
	public Material(int id_material, String origen, String materiales,
			String descripcion, float costounitario, String factura,
			Date fecha, String proveedor, String unidad,
			float cantidadcomprada, float cantdadconvertida, String moneda,
			float importecompre, float precioadquisicion,
			Date fechatasaconversionEURaUSD, float tasaconversionEURaUSD,
			float precioadqusicionconvertidoEURaUSD,
			Date fechatasacambioDOPaUSD, float tasacambioDOPaUSD,
			float precioadquisicionconvertidoDOPaUSD, float csotosMolde,
			float cantidadtotalfacturada, float precioAdquisicionUSDconMolde,
			float precioAdquisicionconvertidoEURaUSDconMolde,
			float precioadquisicionDOPaUSDconMolde, float gastosvarios,
			float precioAdquisicionUSDconGAStos,
			float precioAdqusicionconvertidoEURaUSDconGastos,
			float precioAdquisicionConvertidoDOPaUSDconGAstos,
			float costounitariologistica, String tipomaterial) {
		super();
		this.id_material = id_material;
		this.origen = origen;
		this.materiales = materiales;
		this.descripcion = descripcion;
		this.costounitario = costounitario;
		this.factura = factura;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.unidad = unidad;
		this.cantidadcomprada = cantidadcomprada;
		this.cantdadconvertida = cantdadconvertida;
		this.moneda = moneda;
		this.importecompre = importecompre;
		this.precioadquisicion = precioadquisicion;
		this.fechatasaconversionEURaUSD = fechatasaconversionEURaUSD;
		this.tasaconversionEURaUSD = tasaconversionEURaUSD;
		this.precioadqusicionconvertidoEURaUSD = precioadqusicionconvertidoEURaUSD;
		this.fechatasacambioDOPaUSD = fechatasacambioDOPaUSD;
		this.tasacambioDOPaUSD = tasacambioDOPaUSD;
		this.precioadquisicionconvertidoDOPaUSD = precioadquisicionconvertidoDOPaUSD;
		CsotosMolde = csotosMolde;
		this.cantidadtotalfacturada = cantidadtotalfacturada;
		this.precioAdquisicionUSDconMolde = precioAdquisicionUSDconMolde;
		this.precioAdquisicionconvertidoEURaUSDconMolde = precioAdquisicionconvertidoEURaUSDconMolde;
		this.precioadquisicionDOPaUSDconMolde = precioadquisicionDOPaUSDconMolde;
		this.gastosvarios = gastosvarios;
		this.precioAdquisicionUSDconGAStos = precioAdquisicionUSDconGAStos;
		this.precioAdqusicionconvertidoEURaUSDconGastos = precioAdqusicionconvertidoEURaUSDconGastos;
		PrecioAdquisicionConvertidoDOPaUSDconGAstos = precioAdquisicionConvertidoDOPaUSDconGAstos;
		this.costounitariologistica = costounitariologistica;
		this.tipomaterial = tipomaterial;
	}
	public float getCostounitariologistica() {
		return costounitariologistica;
	}
	public void setCostounitariologistica(float costounitariologistica) {
		this.costounitariologistica = costounitariologistica;
	}

	
	public String getTipomaterial() {
		return tipomaterial;
	}
	public void setTipomaterial(String tipomaterial) {
		this.tipomaterial = tipomaterial;
	}
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_material() {
		return id_material;
	}
	public void setId_material(int id_material) {
		this.id_material = id_material;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getMateriales() {
		return materiales;
	}
	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getCostounitario() {
		return costounitario;
	}
	public void setCostounitario(float costounitario) {
		this.costounitario = costounitario;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public float getCantidadcomprada() {
		return cantidadcomprada;
	}
	public void setCantidadcomprada(float cantidadcomprada) {
		this.cantidadcomprada = cantidadcomprada;
	}
	public float getCantdadconvertida() {
		return cantdadconvertida;
	}
	public void setCantdadconvertida(float cantdadconvertida) {
		this.cantdadconvertida = cantdadconvertida;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public float getImportecompre() {
		return importecompre;
	}
	public void setImportecompre(float importecompre) {
		this.importecompre = importecompre;
	}
	public float getPrecioadquisicion() {
		return precioadquisicion;
	}
	public void setPrecioadquisicion(float precioadquisicion) {
		this.precioadquisicion = precioadquisicion;
	}
	public Date getFechatasaconversionEURaUSD() {
		return fechatasaconversionEURaUSD;
	}
	public void setFechatasaconversionEURaUSD(Date fechatasaconversionEURaUSD) {
		this.fechatasaconversionEURaUSD = fechatasaconversionEURaUSD;
	}
	public float getTasaconversionEURaUSD() {
		return tasaconversionEURaUSD;
	}
	public void setTasaconversionEURaUSD(float tasaconversionEURaUSD) {
		this.tasaconversionEURaUSD = tasaconversionEURaUSD;
	}
	public float getPrecioadqusicionconvertidoEURaUSD() {
		return precioadqusicionconvertidoEURaUSD;
	}
	public void setPrecioadqusicionconvertidoEURaUSD(
			float precioadqusicionconvertidoEURaUSD) {
		this.precioadqusicionconvertidoEURaUSD = precioadqusicionconvertidoEURaUSD;
	}
	public Date getFechatasacambioDOPaUSD() {
		return fechatasacambioDOPaUSD;
	}
	public void setFechatasacambioDOPaUSD(Date fechatasacambioDOPaUSD) {
		this.fechatasacambioDOPaUSD = fechatasacambioDOPaUSD;
	}
	public float getTasacambioDOPaUSD() {
		return tasacambioDOPaUSD;
	}
	public void setTasacambioDOPaUSD(float tasacambioDOPaUSD) {
		this.tasacambioDOPaUSD = tasacambioDOPaUSD;
	}
	public float getPrecioadquisicionconvertidoDOPaUSD() {
		return precioadquisicionconvertidoDOPaUSD;
	}
	public void setPrecioadquisicionconvertidoDOPaUSD(
			float precioadquisicionconvertidoDOPaUSD) {
		this.precioadquisicionconvertidoDOPaUSD = precioadquisicionconvertidoDOPaUSD;
	}
	public float getCsotosMolde() {
		return CsotosMolde;
	}
	public void setCsotosMolde(float csotosMolde) {
		CsotosMolde = csotosMolde;
	}
	public float getCantidadtotalfacturada() {
		return cantidadtotalfacturada;
	}
	public void setCantidadtotalfacturada(float cantidadtotalfacturada) {
		this.cantidadtotalfacturada = cantidadtotalfacturada;
	}
	public float getPrecioAdquisicionUSDconMolde() {
		return precioAdquisicionUSDconMolde;
	}
	public void setPrecioAdquisicionUSDconMolde(float precioAdquisicionUSDconMolde) {
		this.precioAdquisicionUSDconMolde = precioAdquisicionUSDconMolde;
	}
	public float getPrecioAdquisicionconvertidoEURaUSDconMolde() {
		return precioAdquisicionconvertidoEURaUSDconMolde;
	}
	public void setPrecioAdquisicionconvertidoEURaUSDconMolde(
			float precioAdquisicionconvertidoEURaUSDconMolde) {
		this.precioAdquisicionconvertidoEURaUSDconMolde = precioAdquisicionconvertidoEURaUSDconMolde;
	}
	public float getPrecioadquisicionDOPaUSDconMolde() {
		return precioadquisicionDOPaUSDconMolde;
	}
	public void setPrecioadquisicionDOPaUSDconMolde(
			float precioadquisicionDOPaUSDconMolde) {
		this.precioadquisicionDOPaUSDconMolde = precioadquisicionDOPaUSDconMolde;
	}
	public float getGastosvarios() {
		return gastosvarios;
	}
	public void setGastosvarios(float gastosvarios) {
		this.gastosvarios = gastosvarios;
	}
	public float getPrecioAdquisicionUSDconGAStos() {
		return precioAdquisicionUSDconGAStos;
	}
	public void setPrecioAdquisicionUSDconGAStos(float precioAdquisicionUSDconGAStos) {
		this.precioAdquisicionUSDconGAStos = precioAdquisicionUSDconGAStos;
	}
	public float getPrecioAdqusicionconvertidoEURaUSDconGastos() {
		return precioAdqusicionconvertidoEURaUSDconGastos;
	}
	public void setPrecioAdqusicionconvertidoEURaUSDconGastos(
			float precioAdqusicionconvertidoEURaUSDconGastos) {
		this.precioAdqusicionconvertidoEURaUSDconGastos = precioAdqusicionconvertidoEURaUSDconGastos;
	}
	public float getPrecioAdquisicionConvertidoDOPaUSDconGAstos() {
		return PrecioAdquisicionConvertidoDOPaUSDconGAstos;
	}
	public void setPrecioAdquisicionConvertidoDOPaUSDconGAstos(
			float precioAdquisicionConvertidoDOPaUSDconGAstos) {
		PrecioAdquisicionConvertidoDOPaUSDconGAstos = precioAdquisicionConvertidoDOPaUSDconGAstos;
	}
	
	

}
