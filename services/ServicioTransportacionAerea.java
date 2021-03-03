package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TransportaciónAerea;
import Utils.ConnectionBD;

public class ServicioTransportacionAerea {
	
	public static void insertarTransportacionAereaMateriaPrima(String proveedor,String factura,Date fech, float canttransportada,int moneda,float importe,Date fechcambio,float tasa,float imprteconvertido,float costo,int materia,int tipo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTransportacioAereaMateriaPrima\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setFloat(4, canttransportada);
		prepararCons.setInt(5, moneda);
		prepararCons.setFloat(6, importe);
		prepararCons.setDate(7, fechcambio);
		prepararCons.setFloat(8, tasa);
		prepararCons.setFloat(9, imprteconvertido);
		prepararCons.setFloat(10, costo);
		prepararCons.setInt(11, materia);
		prepararCons.setInt(12, tipo);
		prepararCons.execute();
	}
	
	public static void insertarTransportacionAereaMaterial(String proveedor,String factura,Date fech, float canttransportada,int moneda,float importe,Date fechcambio,float tasa,float imprteconvertido,float costo,int materia,int tipo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTransportacionAereaMaterial\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);
		prepararCons.setFloat(4, canttransportada);
		prepararCons.setInt(5, moneda);
		prepararCons.setFloat(6, importe);
		prepararCons.setDate(7, fechcambio);
		prepararCons.setFloat(8, tasa);
		prepararCons.setFloat(9, imprteconvertido);
		prepararCons.setFloat(10, costo);
		prepararCons.setInt(11, materia);
		prepararCons.setInt(12, tipo);
		prepararCons.execute();
	}
	
	
	public static TransportaciónAerea getTransportacionMateria (Integer materia){
		TransportaciónAerea a = new TransportaciónAerea();
		String sentence = " SELECT \"public\".\"TransportacionAerea\".\"id_transportacion\",\"public\".\"TransportacionAerea\".\"nombreproveedor\",\"public\".\"TransportacionAerea\".\"numerofactura\",\"public\".\"TransportacionAerea\".\"fechafactura\"," +
				"\"public\".\"TransportacionAerea\".\"cantidadtransportada\",\"public\".\"TransportacionAerea\".\"importefactura\",\"public\".\"TransportacionAerea\".\"fechatasaconversionEURaUSD\"," +
				"\"public\".\"TransportacionAerea\".\"tasaconversiondeEURaUSD\",\"public\".\"TransportacionAerea\".\"importefacturaconvertidoEURaUSD\",\"public\".\"TransportacionAerea\".\"costoUnitarioAerea\",\"public\".\"Tipo\".\"tipo\"" +
		"FROM  \"public\".\"TransportacionAerea\",\"public\".\"Tipo\" WHERE \"public\".\"TransportacionAerea\".\"id_materiaprima\" = ? and \"public\".\"Tipo\".\"id_tipo\"=\"public\".\"TransportacionAerea\".\"tipotransportacion\"" ;
		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_transportacion(result.getInt(1));
				a.setNombreproveedor(result.getString(2));	
				a.setNumerofactura(result.getString(3));
				a.setFechfactura(result.getDate(4));
				a.setCantidadtransportada(result.getFloat(5));
				a.setImportefactura(result.getFloat(6));
				a.setFechaConversionEURaUSD(result.getDate(7));
				a.setTasaconversion(result.getFloat(8));
				a.setImportefacturaconvertidoEURaUSD(result.getFloat(9));
				a.setCostounitario(result.getFloat(10));
				a.setTipotransportacion(result.getString(11));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public static TransportaciónAerea getTransportacionMaterial (Integer materia){
		TransportaciónAerea a = new TransportaciónAerea();
		String sentence = " SELECT \"public\".\"TransportacionAerea\".\"id_transportacion\",\"public\".\"TransportacionAerea\".\"nombreproveedor\",\"public\".\"TransportacionAerea\".\"numerofactura\",\"public\".\"TransportacionAerea\".\"fechafactura\"," +
				"\"public\".\"TransportacionAerea\".\"cantidadtransportada\",\"public\".\"TransportacionAerea\".\"importefactura\",\"public\".\"TransportacionAerea\".\"fechatasaconversionEURaUSD\"," +
				"\"public\".\"TransportacionAerea\".\"tasaconversiondeEURaUSD\",\"public\".\"TransportacionAerea\".\"importefacturaconvertidoEURaUSD\",\"public\".\"TransportacionAerea\".\"costoUnitarioAerea\",\"public\".\"Tipo\".\"tipo\"" +
		"FROM  \"public\".\"TransportacionAerea\",\"public\".\"Tipo\" WHERE \"public\".\"TransportacionAerea\".\"id_material\" = ? and \"public\".\"Tipo\".\"id_tipo\"=\"public\".\"TransportacionAerea\".\"tipotransportacion\"" ;
		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_transportacion(result.getInt(1));
				a.setNombreproveedor(result.getString(2));	
				a.setNumerofactura(result.getString(3));
				a.setFechfactura(result.getDate(4));
				a.setCantidadtransportada(result.getFloat(5));
				a.setImportefactura(result.getFloat(6));
				a.setFechaConversionEURaUSD(result.getDate(7));
				a.setTasaconversion(result.getFloat(8));
				a.setImportefacturaconvertidoEURaUSD(result.getFloat(9));
				a.setCostounitario(result.getFloat(10));
				a.setTipotransportacion(result.getString(11));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	
	public static void EliminarTransportacionAereaMateriaPrima(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarTransportacionAereaMateriaPrima\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}

	public static void EliminarTransportacionAereaMaterial(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarTransportacionAereaMaterial\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void ModificarTransporteAereoMateriaPrima(int materia,float importe,Date fechcambio,float tasa,float imprteconvertido,float canttransportada,float costo,String proveedor,String factura,Date fech,int moneda,int tipo ) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarTransportacionAereaMateriaPrima\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, materia);
		prepararCons.setFloat(2, importe);
		prepararCons.setDate(3, fechcambio);
		prepararCons.setFloat(4, tasa);
		prepararCons.setFloat(5, imprteconvertido);
		prepararCons.setFloat(6, canttransportada);
		prepararCons.setFloat(7, costo);		
		prepararCons.setString(8, proveedor);
		prepararCons.setString(9, factura);
		prepararCons.setDate(10, fech);		
		prepararCons.setInt(11, moneda);		
		prepararCons.setInt(12, tipo);		
		prepararCons.execute();
	}
	
	public static void ModificarTransporteAereoMaterial(int materia,float importe,Date fechcambio,float tasa,float imprteconvertido,float canttransportada,float costo,String proveedor,String factura,Date fech,int moneda,int tipo ) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarTransportacionAereaMaterial\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, materia);
		prepararCons.setFloat(2, importe);
		prepararCons.setDate(3, fechcambio);
		prepararCons.setFloat(4, tasa);
		prepararCons.setFloat(5, imprteconvertido);
		prepararCons.setFloat(6, canttransportada);
		prepararCons.setFloat(7, costo);		
		prepararCons.setString(8, proveedor);
		prepararCons.setString(9, factura);
		prepararCons.setDate(10, fech);		
		prepararCons.setInt(11, moneda);		
		prepararCons.setInt(12, tipo);		
		prepararCons.execute();
	}
	
}
