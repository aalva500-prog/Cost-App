package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TransportacionTerrestre;
import Utils.ConnectionBD;

public class ServicioTerrestre {

	public static void insertarTransportacionTerrestreMateriaPrima(String proveedor,String factura,Date fech,int moneda ,float importe,Date fechcambio,float tasa,float imprteconvertido,float costo,int materia,float canttransportada) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTerrestreMateriaPrima\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);		
		prepararCons.setInt(4, moneda);
		prepararCons.setFloat(5, importe);
		prepararCons.setDate(6, fechcambio);
		prepararCons.setFloat(7, tasa);
		prepararCons.setFloat(8, imprteconvertido);
		prepararCons.setFloat(9, costo);
		prepararCons.setInt(10, materia);
		prepararCons.setFloat(11, canttransportada);
		prepararCons.execute();
	}
	
	public static void insertarTransportacionTerrestreMaterial(String proveedor,String factura,Date fech,int moneda ,float importe,Date fechcambio,float tasa,float imprteconvertido,float costo,int materia,float canttransportada) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTerrestreMaterial\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, proveedor);
		prepararCons.setString(2, factura);
		prepararCons.setDate(3, fech);		
		prepararCons.setInt(4, moneda);
		prepararCons.setFloat(5, importe);
		prepararCons.setDate(6, fechcambio);
		prepararCons.setFloat(7, tasa);
		prepararCons.setFloat(8, imprteconvertido);
		prepararCons.setFloat(9, costo);
		prepararCons.setInt(10, materia);
		prepararCons.setFloat(11, canttransportada);
		prepararCons.execute();
	}
	
	public static TransportacionTerrestre getTransportacionTerrestreMateria (Integer materia){
		TransportacionTerrestre a = new TransportacionTerrestre();
		String sentence = " SELECT \"public\".\"TransportacionTerrestre\".\"id_terrestre\",\"public\".\"TransportacionTerrestre\".\"nombreproveedor\",\"public\".\"TransportacionTerrestre\".\"numerofactura\",\"public\".\"TransportacionTerrestre\".\"fechafactura\"," +
				"\"public\".\"TransportacionTerrestre\".\"cantidadtransportada\",\"public\".\"TransportacionTerrestre\".\"importefactura\",\"public\".\"TransportacionTerrestre\".\"fechatasacambioDOPaUSD\"," +
				"\"public\".\"TransportacionTerrestre\".\"tasacambioDOPaUSD\",\"public\".\"TransportacionTerrestre\".\"importefacturaconvertidoDOPaUSD\",\"public\".\"TransportacionTerrestre\".\"costoUnitarioTerrestre\"" +
		"FROM  \"public\".\"TransportacionTerrestre\" WHERE \"public\".\"TransportacionTerrestre\".\"id_materiaprima\" = ? " ;
		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_transportacion(result.getInt(1));
				a.setNombreproveedor(result.getString(2));	
				a.setNumerofactura(result.getString(3));
				a.setFechafactura(result.getDate(4));
				a.setCantidadtrans(result.getFloat(5));
				a.setImprtefactura(result.getFloat(6));
				a.setFechatasaCAmbio(result.getDate(7));
				a.setTasaCAmbio(result.getFloat(8));
				a.setImporteconvertido(result.getFloat(9));
				a.setCostounitario(result.getFloat(10));
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
	
	public static TransportacionTerrestre getTransportacionTerrestreMaterial (Integer materia){
		TransportacionTerrestre a = new TransportacionTerrestre();
		String sentence = " SELECT \"public\".\"TransportacionTerrestre\".\"id_terrestre\",\"public\".\"TransportacionTerrestre\".\"nombreproveedor\",\"public\".\"TransportacionTerrestre\".\"numerofactura\",\"public\".\"TransportacionTerrestre\".\"fechafactura\"," +
				"\"public\".\"TransportacionTerrestre\".\"cantidadtransportada\",\"public\".\"TransportacionTerrestre\".\"importefactura\",\"public\".\"TransportacionTerrestre\".\"fechatasacambioDOPaUSD\"," +
				"\"public\".\"TransportacionTerrestre\".\"tasacambioDOPaUSD\",\"public\".\"TransportacionTerrestre\".\"importefacturaconvertidoDOPaUSD\",\"public\".\"TransportacionTerrestre\".\"costoUnitarioTerrestre\"" +
		"FROM  \"public\".\"TransportacionTerrestre\" WHERE \"public\".\"TransportacionTerrestre\".\"id_material\" = ? " ;
		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_transportacion(result.getInt(1));
				a.setNombreproveedor(result.getString(2));	
				a.setNumerofactura(result.getString(3));
				a.setFechafactura(result.getDate(4));
				a.setCantidadtrans(result.getFloat(5));
				a.setImprtefactura(result.getFloat(6));
				a.setFechatasaCAmbio(result.getDate(7));
				a.setTasaCAmbio(result.getFloat(8));
				a.setImporteconvertido(result.getFloat(9));
				a.setCostounitario(result.getFloat(10));
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
	
	
	public static void EliminarTransportacionTerrestreMateriaPrima(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarTransportacionTerrestre\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void EliminarTransportacionTerrestreMaterial(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarTransportacionTerrestreMaterial\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void ModificarTransporteTerrestreMateriaPrima(int materia,float importe,Date fechcambio,float tasa,float imprteconvertido,float canttransportada,float costo,String proveedor,String factura,Date fech,int moneda) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarTransporteTerrestreMateriaPrima\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
		prepararCons.execute();
	}
	
	public static void ModificarTransporteTerrestreMaterial(int materia,float importe,Date fechcambio,float tasa,float imprteconvertido,float canttransportada,float costo,String proveedor,String factura,Date fech,int moneda) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarTerrestreMaterial\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
		prepararCons.execute();
	}
	
	
}
