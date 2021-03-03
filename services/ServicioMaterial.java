package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Material;
import Utils.ConnectionBD;

public class ServicioMaterial {
	
	public static void EliminarMaterial(int id_material) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarMaterial\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_material);
		prepararCons.execute();
	}
	

	public static void  ModificarMaterialNacionalsinLogisticayconMolde(int id_material,String nombreproveedor,String factura,Date fechfactura,String descripcion,int unidad,float cantcomprada,float cantconvertida,int moneda,
			float importe,float precioadquisicion,float cantfacturada,float gastosvarios,float precioadquisicionconGastos,float precioadqusiscionDOPaUSD,Date fechaconversion,float tasaconversion,
			float precionadquisiscionDOPyGastos,float costounitario,float costomolde,float preciomoldeUSD,float preciomoldeDOP,int tipo) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarMAterialNacionalconMoldeysinLogistica\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_material); 
		prepararCons.setString(2,nombreproveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fechfactura);
		prepararCons.setString(5, descripcion);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setFloat(8, cantconvertida);
		prepararCons.setInt(9, moneda);
		prepararCons.setFloat(10, importe);
		prepararCons.setFloat(11, precioadquisicion);
		prepararCons.setFloat(12, cantfacturada);
		prepararCons.setFloat(13, gastosvarios);
		prepararCons.setFloat(14, precioadquisicionconGastos);
		prepararCons.setFloat(15, precioadqusiscionDOPaUSD);
		prepararCons.setDate(16, fechaconversion);
		prepararCons.setFloat(17, tasaconversion);
		prepararCons.setFloat(18, precionadquisiscionDOPyGastos);
		prepararCons.setFloat(19, costounitario);
		prepararCons.setFloat(20, costomolde);
		prepararCons.setFloat(21, preciomoldeUSD);
		prepararCons.setFloat(22, preciomoldeDOP);
		prepararCons.setInt(23, tipo);
		prepararCons.execute();
		
	}
	
	public static void  ModificarMaterialImportado(int id_material,String nombreproveedor,String factura,Date fechfactura,String descripcion,int unidad,float cantcomprada,float cantconvertida,int moneda,
			float importe,float precioadquisicion,float cantfacturada,float gastosvarios,float precioadquisicionconGastos,float precioadqusiscionEURaUSD,Date fechaconversion,float tasaconversion,
			float precionadquisiscionEURyGastos,float costomolde,float preciomoldeUSD,float preciomoldeEUR,int tipo) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarMaterialImportado\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_material); 
		prepararCons.setString(2,nombreproveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fechfactura);
		prepararCons.setString(5, descripcion);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setFloat(8, cantconvertida);
		prepararCons.setInt(9, moneda);
		prepararCons.setFloat(10, importe);
		prepararCons.setFloat(11, precioadquisicion);
		prepararCons.setFloat(12, cantfacturada);
		prepararCons.setFloat(13, gastosvarios);
		prepararCons.setFloat(14, precioadquisicionconGastos);
		prepararCons.setFloat(15, precioadqusiscionEURaUSD);
		prepararCons.setDate(16, fechaconversion);
		prepararCons.setFloat(17, tasaconversion);
		prepararCons.setFloat(18, precionadquisiscionEURyGastos);
		prepararCons.setFloat(19, costomolde);
		prepararCons.setFloat(20, preciomoldeUSD);
		prepararCons.setFloat(21, preciomoldeEUR);
		prepararCons.setInt(22, tipo);
		prepararCons.execute();
		
	}
	public static void  ModificarMaterialconMoldeyLogistica(int id_material,String nombreproveedor,String factura,Date fechfactura,String descripcion,int unidad,float cantcomprada,float cantconvertida,int moneda,
			float importe,float precioadquisicion,float cantfacturada,float gastosvarios,float precioadquisicionconGastos,float precioadqusiscionDOPaUSD,Date fechaconversion,float tasaconversion,
			float precionadquisiscionDOPyGastos,float costounitario,float logistica,float costomolde,float preciomoldeUSD,float preciomoldeDOP,int tipo) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarMaterialNAcionalconMoldeyLogistica\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_material); 
		prepararCons.setString(2,nombreproveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fechfactura);
		prepararCons.setString(5, descripcion);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setFloat(8, cantconvertida);
		prepararCons.setInt(9, moneda);
		prepararCons.setFloat(10, importe);
		prepararCons.setFloat(11, precioadquisicion);
		prepararCons.setFloat(12, cantfacturada);
		prepararCons.setFloat(13, gastosvarios);
		prepararCons.setFloat(14, precioadquisicionconGastos);
		prepararCons.setFloat(15, precioadqusiscionDOPaUSD);
		prepararCons.setDate(16, fechaconversion);
		prepararCons.setFloat(17, tasaconversion);
		prepararCons.setFloat(18, precionadquisiscionDOPyGastos);
		prepararCons.setFloat(19, costounitario);
		prepararCons.setFloat(20, logistica);
		prepararCons.setFloat(21, costomolde);
		prepararCons.setFloat(22, preciomoldeUSD);
		prepararCons.setFloat(23, preciomoldeDOP);
		prepararCons.setInt(24, tipo);
		prepararCons.execute();
		
	}
	
	public static void insertarMaterialImportadoUSDconMolde(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float molde,float cantfacturada,float precioconMolde,int tipomaterial) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsetarMaterialImportadoUSDconMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, molde);
		prepararCons.setFloat(11, cantfacturada);
		prepararCons.setFloat(12, precioconMolde);
		prepararCons.setInt(13, tipomaterial);
		prepararCons.execute();
	}
	
	
	
	//Métodos de Materiales Importados en USD
	public static void insertarMaterialImportadoUSD(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,int tipomaterial) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoUSD\" (?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setInt(10, tipomaterial);
		prepararCons.execute();
	}
	
	public static void insertarMaterialImportadoUSDconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float galon,int tipomaterial) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialUSDImportadoconGalon\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, galon);
		prepararCons.setInt(11, tipomaterial);
		prepararCons.execute();
	}
	
	public static void insertarMaterialImportadoUSDconGAstos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float gastos,float cantfacturada,float precioconGastos,int tipomaterial) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoUSDconGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, gastos);
		prepararCons.setFloat(11, cantfacturada);
		prepararCons.setFloat(12, precioconGastos);
		prepararCons.setInt(13, tipomaterial);
		prepararCons.execute();
	}
	
	public static void insertarMaterialImportadaUSDconGAstosyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float gastos,float cantfacturada,float precioconGastos,float galon,int tipomaterial) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialUSDImportadoconGalonyGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, gastos);
		prepararCons.setFloat(11, cantfacturada);
		prepararCons.setFloat(12, precioconGastos);
		prepararCons.setFloat(13, galon);
		prepararCons.setInt(14, tipomaterial);
		prepararCons.execute();
	}
	
	public static void insertarMaterialImportadaUSDconMoldeyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float molde,float cantfacturada,float precioconMolde,float galon,int tipo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoUSDconMoldeyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, molde);
		prepararCons.setFloat(11, cantfacturada);
		prepararCons.setFloat(12, precioconMolde);
		prepararCons.setFloat(13, galon);
		prepararCons.setInt(14, tipo);
		prepararCons.execute();
	}
	
	public static void insertarMaterialImportadaUSDconMoldeyGastos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float molde,float cantfacturada,float precioconMolde,float gastos,float preciogastos,int tipo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoUSDconMoldeyGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, molde);
		prepararCons.setFloat(11, cantfacturada);
		prepararCons.setFloat(12, precioconMolde);
		prepararCons.setFloat(13, gastos);
		prepararCons.setFloat(14, preciogastos);
		prepararCons.setInt(15, tipo);
		prepararCons.execute();
	}
	
	public static void insertarMaterialImportadaUSDconMoldeyGastosGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float molde,float cantfacturada,float precioconMolde,float gastos,float preciogastos,float galon,int tipo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoUSDconGAlonyGastosyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setString(4, descrip);
		prepararCons.setInt(5, unidad);
		prepararCons.setFloat(6, cantcomprada);
		prepararCons.setInt(7, moneda);
		prepararCons.setFloat(8, importe);
		prepararCons.setFloat(9, precio);
		prepararCons.setFloat(10, molde);
		prepararCons.setFloat(11, cantfacturada);
		prepararCons.setFloat(12, precioconMolde);
		prepararCons.setFloat(13, gastos);
		prepararCons.setFloat(14, preciogastos);
		prepararCons.setFloat(15, galon);
		prepararCons.setInt(16, tipo);
		prepararCons.execute();
	}
	
	//Metodos de Materiales Nacionales en USD
		public static void insertarMaterialNacionalUSD(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalUSD\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setInt(11, tipo);
			prepararCons.execute();
		}

		public static void insertarMaterialNacionalUSDconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarmaterialNAcionalUSDyGAlon\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, galon);
			prepararCons.setInt(12, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDConLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float logistica, int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, logistica);
			prepararCons.setInt(12, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalUSDconGAstos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, gastos);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconGastos);
			prepararCons.setInt(14,tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconMolde(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setInt(14, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalUSDconMoldeyGastos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float gastos,float preciogastos,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalUSDconMoldeyGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, preciogastos);
			prepararCons.setInt(16, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconMoldeyGastosGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float gastos,float preciogastos,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconGalonGastosyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, preciogastos);
			prepararCons.setFloat(16, galon);
			prepararCons.setInt(17, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconMoldeyGastosyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float gastos,float preciogastos,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialUSDNAcionalLogisticayGastosyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, preciogastos);
			prepararCons.setFloat(16, galon);
			prepararCons.setInt(17, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalUSDCompleto(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float gastos,float preciogastos,float galon,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDCompleto\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, preciogastos);
			prepararCons.setFloat(16, galon);
			prepararCons.setFloat(17, log);
			prepararCons.setInt(18, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconMoldeyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconGalonyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, galon);
			prepararCons.setInt(15, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconMoldeyGalonyogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float galon,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialconGalonyLogisticayMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, galon);
			prepararCons.setFloat(15, log);
			prepararCons.setInt(16, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconMoldeyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float molde,float cantfacturada,float precioconMolde,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconLogisticayMoolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, molde);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconMolde);
			prepararCons.setFloat(14, galon);
			prepararCons.setInt(15, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconGalonyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float galon,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconGAlonyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, galon);
			prepararCons.setFloat(12, log);
			prepararCons.setInt(13, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalUSDconGAstosyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconGalonyGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, gastos);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconGastos);
			prepararCons.setFloat(14, galon);
			prepararCons.setInt(15, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalUSDconGAstosyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconLogisticayGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, gastos);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconGastos);
			prepararCons.setFloat(14, log);
			prepararCons.setInt(15, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalUSDconGAstosGalonyLOg(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,float log,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalUSDconLogisticayGalonyGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setFloat(11, gastos);
			prepararCons.setFloat(12, cantfacturada);
			prepararCons.setFloat(13, precioconGastos);
			prepararCons.setFloat(14, log);
			prepararCons.setFloat(15, galon);
			prepararCons.setInt(16, tipo);
			prepararCons.execute();
		}
		
		
		
		//Metodos de MAteriales Importados en EUR
		public static void insertarMaterialImportadoEUR(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio, int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoEUR\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setInt(13, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialImportadaEURyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialEURconGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, galon);
			prepararCons.setInt(14, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialEURyGastos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoEURconGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, gastos);
			prepararCons.setFloat(14, cantfacturada);
			prepararCons.setFloat(15, precioDOP);
			prepararCons.setInt(16, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialImportadoEURyGastosconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float gastos,float precioDOP,float cantfacturada,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialEURconGastosyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, gastos);
			prepararCons.setFloat(14, precioDOP);
			prepararCons.setFloat(15, cantfacturada);			
			prepararCons.setFloat(16, galon);
			prepararCons.setInt(17, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialImportadoEURconMolde(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoEURconMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, costoMolde);
			prepararCons.setFloat(14, cantfacturada);
			prepararCons.setFloat(15, precioMolde);
			prepararCons.setInt(16, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialImportadoEURconMoldeyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float costoMolde,float precioMolde,float cantfacturada,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialEURconmoldeyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, costoMolde);		
			prepararCons.setFloat(14, precioMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, galon);
			prepararCons.setInt(17, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialEURyGastosconMolde(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float gastos,float precioDOP,float cantfacturada,float molde,float precioMolde,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialImportadoEURconGastosyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, gastos);
			prepararCons.setFloat(14, precioDOP);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, molde);
			prepararCons.setFloat(17, precioMolde);
			prepararCons.setInt(18, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialEURCompleto(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float gastos,float precioDOP,float cantfacturada,float molde,float precioMolde,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMateriaImportadoEURCompleto\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setDate(10, fechcambio);
			prepararCons.setFloat(11, tasa);
			prepararCons.setFloat(12, preciocambio);
			prepararCons.setFloat(13, gastos);
			prepararCons.setFloat(14, precioDOP);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, molde);
			prepararCons.setFloat(17, precioMolde);
			prepararCons.setFloat(18, galon);
			prepararCons.setInt(19, tipo);
			prepararCons.execute();
		}
		
		//Metodos de Materiales Nacionales en DOP
		public static void insertarMaterialNacionalDOP(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialDOPNAcional\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setInt(14, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPconMolde(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialDOPNAcionalYMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setInt(17, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPconMoldeyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalDOPconMoldeyGAlon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, galon);
			prepararCons.setInt(18, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPconMoldeyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalDOPconMoldeyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, galon);
			prepararCons.setInt(18, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPconMoldeyLogisticayGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float galon,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMAterialNAcionalDOPconGAlonyLogisticayMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, galon);
			prepararCons.setFloat(18, log);
			prepararCons.setInt(19, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalDOPconMoldeyGAstos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float gastos,float preciogastos,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalDOPconGAstosyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, gastos);
			prepararCons.setFloat(18, preciogastos);
			prepararCons.setInt(19, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPconMoldeyGAstosyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float gastos,float preciogastos,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNacionalDOPconLogisticayGastosyMolde\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, gastos);
			prepararCons.setFloat(18, preciogastos);
			prepararCons.setFloat(19, log);
			prepararCons.setInt(20, tipo);
			prepararCons.execute();
		}

		public static void insertarMaterialNacionalDOPComleto(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float gastos,float preciogastos,float log,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionaLDOPCompleto\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, gastos);
			prepararCons.setFloat(18, preciogastos);
			prepararCons.setFloat(19, log);
			prepararCons.setFloat(20, galon);
			prepararCons.setInt(21, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPconMoldeyGAstosconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float costoMolde,float cantfacturada,float precioMolde,float gastos,float preciogastos,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialDOPconMOldeyGastosYGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, costoMolde);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioMolde);
			prepararCons.setFloat(17, gastos);
			prepararCons.setFloat(18, preciogastos);
			prepararCons.setFloat(19, galon);
			prepararCons.setInt(20, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalDOPyGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialDOPNacionalconGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, galon);
			prepararCons.setInt(15, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalDOPconLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, galon);
			prepararCons.setInt(15, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalDOPyLogisticaconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float galon,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalDOPconGAlonyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, galon);
			prepararCons.setFloat(15, log);
			prepararCons.setInt(16, tipo);
			prepararCons.execute();
		}
		
		
		public static void insertarMaterialNacionalDOPyGastos(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialDOPNAcionalconGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioDOP);
			prepararCons.setInt(17, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPyGastosyLogistica(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float log,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMAterialNAcionalDOPconGAstosyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioDOP);
			prepararCons.setFloat(17, log);
			prepararCons.setInt(18,tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPyGastosyLogisticaconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float log,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMAterialNacionalDOPconGalonyGAstosyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioDOP);
			prepararCons.setFloat(17, log);
			prepararCons.setFloat(18, galon);
			prepararCons.setInt(19, tipo);
			prepararCons.execute();
		}
		
		public static void insertarMaterialNacionalDOPyGastosconGalon(String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float galon,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMaterialNAcionalDOPconGAlonyGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, proveedor);
			prepararCons.setString(2, factura);
			prepararCons.setDate(3, fech);
			prepararCons.setString(4, descrip);
			prepararCons.setInt(5, unidad);
			prepararCons.setFloat(6, cantcomprada);
			prepararCons.setInt(7, moneda);
			prepararCons.setFloat(8, importe);
			prepararCons.setFloat(9, precio);
			prepararCons.setFloat(10, costo);
			prepararCons.setDate(11, fechcambio);
			prepararCons.setFloat(12, tasa);
			prepararCons.setFloat(13, preciocambio);
			prepararCons.setFloat(14, gastos);
			prepararCons.setFloat(15, cantfacturada);
			prepararCons.setFloat(16, precioDOP);
			prepararCons.setFloat(17, galon);
			prepararCons.setInt(18, tipo);
			prepararCons.execute();
		}
		
	
		
		
		//Listado de MAteriales de Origen Nacional
		public static LinkedList<Material> getMaterialesNacionales() throws SQLException, ClassNotFoundException{
			LinkedList<Material> listUsuarios = new LinkedList<Material>();
			Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
					"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
					"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
					"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
					"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
					"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
					"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
					"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
					"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
					"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
					"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
					"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1" +
					"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
			ResultSet resultado = consulta.executeQuery(sqlSentenc);
			while (resultado.next()) {
				Material user = new Material();
				user.setId_material(resultado.getInt(1));
				user.setProveedor(resultado.getString(2));
				user.setFactura(resultado.getString(3));
				user.setFecha(resultado.getDate(4));
				user.setDescripcion(resultado.getString(5));
				user.setUnidad(resultado.getString(6));
				user.setCantidadcomprada(resultado.getFloat(7));
				user.setCantdadconvertida(resultado.getFloat(8));
				user.setMoneda(resultado.getString(9));
				user.setImportecompre(resultado.getFloat(10));
				user.setPrecioadquisicion(resultado.getFloat(11));
				user.setCantidadtotalfacturada(resultado.getFloat(12));
				user.setGastosvarios(resultado.getFloat(13));
				user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
				user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
				user.setFechatasacambioDOPaUSD(resultado.getDate(16));
				user.setTasacambioDOPaUSD(resultado.getFloat(17));
				user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
				user.setCostounitario(resultado.getFloat(19));
				user.setCostounitariologistica(resultado.getFloat(20));
				user.setCsotosMolde(resultado.getFloat(21));
				user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
				user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
				user.setTipomaterial(resultado.getString(24));
				listUsuarios.add(user);
			}
			return listUsuarios;
		}
		
		//Listado de MAteriales de Origen Nacional Botellas
				public static LinkedList<Material> getMaterialesNacionalesBotellas() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=9" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}

				//Listado de MAteriales de Origen Nacional Cajas
				public static LinkedList<Material> getMaterialesNacionalesCajas() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=8" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de MAteriales de Origen Nacional Cinturones
				public static LinkedList<Material> getMaterialesNacionalesCinturones() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=2" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de MAteriales de Origen Nacional Cordones
				public static LinkedList<Material> getMaterialesNacionalesCordones() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=6" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de MAteriales de Origen Nacional Estuches
				public static LinkedList<Material> getMaterialesNacionalesEstuches() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=3" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				//Listado de MAteriales de Origen Nacional Etiquetas
				public static LinkedList<Material> getMaterialesNacionalesEtiquetas() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=1" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de MAteriales de Origen Nacional Librito
				public static LinkedList<Material> getMaterialesNacionalesLibrito() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=5" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de MAteriales de Origen Nacional Madera
				public static LinkedList<Material> getMaterialesNacionalesMadera() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=4" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de MAteriales de Origen Nacional Separadores
				public static LinkedList<Material> getMaterialesNacionalesSeparadores() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadquisicionconvertidoDOPaUSD\"," +
							"\"public\".\"Material\".\"fechatasacambioDOPaUSD\",\"public\".\"Material\".\"tasacambioDOPaUSD\"," +
							"\"public\".\"Material\".\"PrecioAdquisicionConvertidoDOPaUSDconGAstos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioadquisicionDOPaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=1 and \"public\".\"Material\".\"tipomaterial\"=7" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadquisicionconvertidoDOPaUSD(resultado.getFloat(15));
						user.setFechatasacambioDOPaUSD(resultado.getDate(16));
						user.setTasacambioDOPaUSD(resultado.getFloat(17));
						user.setPrecioAdquisicionConvertidoDOPaUSDconGAstos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioadquisicionDOPaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
		//Listado de Materiales Importados
		public static LinkedList<Material> getMaterialesImportados() throws SQLException, ClassNotFoundException{
			LinkedList<Material> listUsuarios = new LinkedList<Material>();
			Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
					"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
					"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
					"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
					"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
					"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
					"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
					"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
					"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
					"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
					"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
					"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2" +
					"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
			ResultSet resultado = consulta.executeQuery(sqlSentenc);
			while (resultado.next()) {
				Material user = new Material();
				user.setId_material(resultado.getInt(1));
				user.setProveedor(resultado.getString(2));
				user.setFactura(resultado.getString(3));
				user.setFecha(resultado.getDate(4));
				user.setDescripcion(resultado.getString(5));
				user.setUnidad(resultado.getString(6));
				user.setCantidadcomprada(resultado.getFloat(7));
				user.setCantdadconvertida(resultado.getFloat(8));
				user.setMoneda(resultado.getString(9));
				user.setImportecompre(resultado.getFloat(10));
				user.setPrecioadquisicion(resultado.getFloat(11));
				user.setCantidadtotalfacturada(resultado.getFloat(12));
				user.setGastosvarios(resultado.getFloat(13));
				user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
				user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
				user.setFechatasaconversionEURaUSD(resultado.getDate(16));
				user.setTasaconversionEURaUSD(resultado.getFloat(17));
				user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
				user.setCostounitario(resultado.getFloat(19));
				user.setCostounitariologistica(resultado.getFloat(20));
				user.setCsotosMolde(resultado.getFloat(21));
				user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
				user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
				user.setTipomaterial(resultado.getString(24));
				listUsuarios.add(user);
			}
			return listUsuarios;
		}
		
		
		//Listado de Materiales Importados Etiquetas
				public static LinkedList<Material> getMaterialesImportadosEtiquetas() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 1" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
		
				//Listado de Materiales Importados Cinturones
				public static LinkedList<Material> getMaterialesImportadosCinturones() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 2" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de Materiales Importados Estuches
				public static LinkedList<Material> getMaterialesImportadosEstuches() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 3" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de Materiales Importados Madera
				public static LinkedList<Material> getMaterialesImportadosMadera() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 4" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
		
				
				//Listado de Materiales Importados Librito
				public static LinkedList<Material> getMaterialesImportadosLibrito() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 5" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				
				//Listado de Materiales Importados Cordones Plasticos
				public static LinkedList<Material> getMaterialesImportadosCordonesPlasticos() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 6" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				
				//Listado de Materiales Importados Separadores
				public static LinkedList<Material> getMaterialesImportadosSeparadores() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 7" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				//Listado de Materiales Importados Cajas
				public static LinkedList<Material> getMaterialesImportadosCajas() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 8" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
				
				//Listado de Materiales Importados Botellas
				public static LinkedList<Material> getMaterialesImportadosBotellas() throws SQLException, ClassNotFoundException{
					LinkedList<Material> listUsuarios = new LinkedList<Material>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"Material\".\"id_material\",\"public\".\"Material\".\"proveedor\"," +
							"\"public\".\"Material\".\"factura\",\"public\".\"Material\".\"fecha\",\"public\".\"Material\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"Material\".\"cantidadcomprada\",\"public\".\"Material\".\"cantidadconvertida\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"Material\".\"importecompra\",\"public\".\"Material\".\"precioadquisicion\",\"public\".\"Material\".\"cantidadtotalfacturada\",\"public\".\"Material\".\"gastosvarios\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconGAStos\"," +
							"\"public\".\"Material\".\"precioadqusicionconvertidoEURaUSD\"," +
							"\"public\".\"Material\".\"fechatasaconversionEURaUSD\",\"public\".\"Material\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"Material\".\"precioAdqusicionconvertidoEURaUSDconGastos\",\"public\".\"Material\".\"costounitario\",\"public\".\"Material\".\"costounitariologistica\",\"public\".\"Material\".\"CsotosMolde\"," +
							"\"public\".\"Material\".\"precioAdquisicionUSDconMolde\",\"public\".\"Material\".\"precioAdquisicionconvertidoEURaUSDconMolde\",\"public\".\"TipoMaterial\".\"tipomaterial\"" +
							"FROM  \"public\".\"Material\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\",\"public\".\"TipoMaterial\"" +
							"WHERE \"public\".\"Material\".\"unidad\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"Material\".\"moneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"Material\".\"tipomaterial\"= \"public\".\"TipoMaterial\".\"id_tipomaterial\" and \"public\".\"Material\".\"origen\"=2 and \"public\".\"Material\".\"tipomaterial\"= 9" +
							"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\",\"public\".\"Material\".\"proveedor\",\"public\".\"Material\".\"fecha\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						Material user = new Material();
						user.setId_material(resultado.getInt(1));
						user.setProveedor(resultado.getString(2));
						user.setFactura(resultado.getString(3));
						user.setFecha(resultado.getDate(4));
						user.setDescripcion(resultado.getString(5));
						user.setUnidad(resultado.getString(6));
						user.setCantidadcomprada(resultado.getFloat(7));
						user.setCantdadconvertida(resultado.getFloat(8));
						user.setMoneda(resultado.getString(9));
						user.setImportecompre(resultado.getFloat(10));
						user.setPrecioadquisicion(resultado.getFloat(11));
						user.setCantidadtotalfacturada(resultado.getFloat(12));
						user.setGastosvarios(resultado.getFloat(13));
						user.setPrecioAdquisicionUSDconGAStos(resultado.getFloat(14));
						user.setPrecioadqusicionconvertidoEURaUSD(resultado.getFloat(15));
						user.setFechatasaconversionEURaUSD(resultado.getDate(16));
						user.setTasaconversionEURaUSD(resultado.getFloat(17));
						user.setPrecioAdqusicionconvertidoEURaUSDconGastos(resultado.getFloat(18));
						user.setCostounitario(resultado.getFloat(19));
						user.setCostounitariologistica(resultado.getFloat(20));
						user.setCsotosMolde(resultado.getFloat(21));
						user.setPrecioAdquisicionUSDconMolde(resultado.getFloat(22));
						user.setPrecioAdquisicionconvertidoEURaUSDconMolde(resultado.getFloat(23));
						user.setTipomaterial(resultado.getString(24));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
				
		public static void  InsertarCostoMaterialImportado(int id_materia,float costounitario,float logistica) throws SQLException, ClassNotFoundException { 
			String sqlSentenc = "SELECT \"public\".\"InsertarCostoUnitarioMaterialImportado\"(?,?,?)"; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_materia); 
			prepararCons.setFloat(2, costounitario);
			prepararCons.setFloat(3, logistica);
			prepararCons.execute();		
		}
		
		
		public static void  InsertarCostoMaterialImportadosinLogistica(int id_materia,float costounitario) throws SQLException, ClassNotFoundException { 
			String sqlSentenc = "SELECT \"public\".\"InsertarCostoUnitarioMaterialImportadosinLogistica\"(?,?)"; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_materia); 
			prepararCons.setFloat(2, costounitario);
			prepararCons.execute();		
		}
}
