package model;

import java.util.Date;

public class MateriaPrima {
	public Integer getId_Materia() {
		return id_Materia;
	}

	public void setId_Materia(Integer id_Materia) {
		this.id_Materia = id_Materia;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getTipomateriaprima() {
		return tipomateriaprima;
	}

	public void setTipomateriaprima(String tipomateriaprima) {
		this.tipomateriaprima = tipomateriaprima;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public float getCantcomprada() {
		return cantcomprada;
	}

	public void setCantcomprada(float cantcomprada) {
		this.cantcomprada = cantcomprada;
	}

	public float getCantconvertgalon() {
		return cantconvertgalon;
	}

	public void setCantconvertgalon(float cantconvertgalon) {
		this.cantconvertgalon = cantconvertgalon;
	}

	public String getTipomoneda() {
		return tipomoneda;
	}

	public void setTipomoneda(String tipomoneda) {
		this.tipomoneda = tipomoneda;
	}

	public float getImportecompra() {
		return importecompra;
	}

	public void setImportecompra(float importecompra) {
		this.importecompra = importecompra;
	}

	public float getPrecioadquisisonUSD() {
		return precioadquisisonUSD;
	}

	public void setPrecioadquisisonUSD(float precioadquisisonUSD) {
		this.precioadquisisonUSD = precioadquisisonUSD;
	}

	public float getCantidadtotalfacturada() {
		return cantidadtotalfacturada;
	}

	public void setCantidadtotalfacturada(float cantidadtotalfacturada) {
		this.cantidadtotalfacturada = cantidadtotalfacturada;
	}

	public float getGastosvarios() {
		return gastosvarios;
	}

	public void setGastosvarios(float gastosvarios) {
		this.gastosvarios = gastosvarios;
	}

	public float getPrecioadquisicionUSDyGastos() {
		return precioadquisicionUSDyGastos;
	}

	public void setPrecioadquisicionUSDyGastos(float precioadquisicionUSDyGastos) {
		this.precioadquisicionUSDyGastos = precioadquisicionUSDyGastos;
	}

	public float getPrecioadquisicioEUROaUSD() {
		return precioadquisicioEUROaUSD;
	}

	public void setPrecioadquisicioEUROaUSD(float precioadquisicioEUROaUSD) {
		this.precioadquisicioEUROaUSD = precioadquisicioEUROaUSD;
	}

	public float getPrecioadquisicionDOPaUSD() {
		return precioadquisicionDOPaUSD;
	}

	public void setPrecioadquisicionDOPaUSD(float precioadquisicionDOPaUSD) {
		this.precioadquisicionDOPaUSD = precioadquisicionDOPaUSD;
	}

	public Date getFechaconversionEURaUSD() {
		return fechaconversionEURaUSD;
	}

	public void setFechaconversionEURaUSD(Date fechaconversionEURaUSD) {
		this.fechaconversionEURaUSD = fechaconversionEURaUSD;
	}

	public Date getFechaconversionDOPaUSD() {
		return fechaconversionDOPaUSD;
	}

	public void setFechaconversionDOPaUSD(Date fechaconversionDOPaUSD) {
		this.fechaconversionDOPaUSD = fechaconversionDOPaUSD;
	}

	public float getTasaconversionEURaUSD() {
		return tasaconversionEURaUSD;
	}

	public void setTasaconversionEURaUSD(float tasaconversionEURaUSD) {
		this.tasaconversionEURaUSD = tasaconversionEURaUSD;
	}

	public float getTasacambioDOPaUSD() {
		return tasacambioDOPaUSD;
	}

	public void setTasacambioDOPaUSD(float tasacambioDOPaUSD) {
		this.tasacambioDOPaUSD = tasacambioDOPaUSD;
	}

	public float getPrecioadquisicionEURyGastos() {
		return precioadquisicionEURyGastos;
	}

	public void setPrecioadquisicionEURyGastos(float precioadquisicionEURyGastos) {
		this.precioadquisicionEURyGastos = precioadquisicionEURyGastos;
	}

	public float getPrecioadquisicionDOPyGastos() {
		return precioadquisicionDOPyGastos;
	}

	public void setPrecioadquisicionDOPyGastos(float precioadquisicionDOPyGastos) {
		this.precioadquisicionDOPyGastos = precioadquisicionDOPyGastos;
	}

	private Integer id_Materia;
	private String origen;
	private String tipomateriaprima;
	private String nombreproveedor;
	private String numerofactura;
	private Date fechafactura;
	private String descripcion;
	private String unidadmedida;
	private float cantcomprada;
	private float cantconvertgalon;
	private String tipomoneda;
	private float importecompra;
	private float precioadquisisonUSD;
	private float cantidadtotalfacturada;
	private float gastosvarios;
	private float precioadquisicionUSDyGastos;
	private float precioadquisicioEUROaUSD;
	private float precioadquisicionDOPaUSD;
	private Date fechaconversionEURaUSD;
	private Date fechaconversionDOPaUSD;
	private float tasaconversionEURaUSD;
	private float tasacambioDOPaUSD;
	private float precioadquisicionEURyGastos;
	private float precioadquisicionDOPyGastos;
	private float costounitario;
	private float costounitariologistica;
	private float costotransporteAereo;
	private float costodesaduanizacion;
	private float costotransporteterrestre;
	private float costoaduana;
	
	public float getCostotransporteAereo() {
		return costotransporteAereo;
	}

	public void setCostotransporteAereo(float costotransporteAereo) {
		this.costotransporteAereo = costotransporteAereo;
	}

	public float getCostodesaduanizacion() {
		return costodesaduanizacion;
	}

	public void setCostodesaduanizacion(float costodesaduanizacion) {
		this.costodesaduanizacion = costodesaduanizacion;
	}

	public float getCostotransporteterrestre() {
		return costotransporteterrestre;
	}

	public void setCostotransporteterrestre(float costotransporteterrestre) {
		this.costotransporteterrestre = costotransporteterrestre;
	}

	public float getCostoaduana() {
		return costoaduana;
	}

	public void setCostoaduana(float costoaduana) {
		this.costoaduana = costoaduana;
	}

	public float getCostounitario() {
		return costounitario;
	}

	public void setCostounitario(float costounitario) {
		this.costounitario = costounitario;
	}

	public float getCostounitariologistica() {
		return costounitariologistica;
	}

	public void setCostounitariologistica(float costounitariologistica) {
		this.costounitariologistica = costounitariologistica;
	}

	


	public MateriaPrima(Integer id_Materia, String origen,
			String tipomateriaprima, String nombreproveedor,
			String numerofactura, Date fechafactura, String descripcion,
			String unidadmedida, float cantcomprada, float cantconvertgalon,
			String tipomoneda, float importecompra, float precioadquisisonUSD,
			float cantidadtotalfacturada, float gastosvarios,
			float precioadquisicionUSDyGastos, float precioadquisicioEUROaUSD,
			float precioadquisicionDOPaUSD, Date fechaconversionEURaUSD,
			Date fechaconversionDOPaUSD, float tasaconversionEURaUSD,
			float tasacambioDOPaUSD, float precioadquisicionEURyGastos,
			float precioadquisicionDOPyGastos, float costounitario,
			float costounitariologistica, float costotransporteAereo,
			float costodesaduanizacion, float costotransporteterrestre,
			float costoaduana) {
		super();
		this.id_Materia = id_Materia;
		this.origen = origen;
		this.tipomateriaprima = tipomateriaprima;
		this.nombreproveedor = nombreproveedor;
		this.numerofactura = numerofactura;
		this.fechafactura = fechafactura;
		this.descripcion = descripcion;
		this.unidadmedida = unidadmedida;
		this.cantcomprada = cantcomprada;
		this.cantconvertgalon = cantconvertgalon;
		this.tipomoneda = tipomoneda;
		this.importecompra = importecompra;
		this.precioadquisisonUSD = precioadquisisonUSD;
		this.cantidadtotalfacturada = cantidadtotalfacturada;
		this.gastosvarios = gastosvarios;
		this.precioadquisicionUSDyGastos = precioadquisicionUSDyGastos;
		this.precioadquisicioEUROaUSD = precioadquisicioEUROaUSD;
		this.precioadquisicionDOPaUSD = precioadquisicionDOPaUSD;
		this.fechaconversionEURaUSD = fechaconversionEURaUSD;
		this.fechaconversionDOPaUSD = fechaconversionDOPaUSD;
		this.tasaconversionEURaUSD = tasaconversionEURaUSD;
		this.tasacambioDOPaUSD = tasacambioDOPaUSD;
		this.precioadquisicionEURyGastos = precioadquisicionEURyGastos;
		this.precioadquisicionDOPyGastos = precioadquisicionDOPyGastos;
		this.costounitario = costounitario;
		this.costounitariologistica = costounitariologistica;
		this.costotransporteAereo = costotransporteAereo;
		this.costodesaduanizacion = costodesaduanizacion;
		this.costotransporteterrestre = costotransporteterrestre;
		this.costoaduana = costoaduana;
	}

	public MateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
