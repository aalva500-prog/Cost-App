package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Desaduanizacion;
import Utils.ConnectionBD;

public class ServicioDesaduanizacion {
	
	public static Desaduanizacion getDesaduanizacion (Integer materia){
		Desaduanizacion a = new Desaduanizacion();
		String sentence = " SELECT \"public\".\"Desaduanizacion\".\"id_desaduanizacion\",\"public\".\"Desaduanizacion\".\"nombreproveedor\",\"public\".\"Desaduanizacion\".\"numerofactura\",\"public\".\"Desaduanizacion\".\"fechafactura\"," +
				"\"public\".\"Desaduanizacion\".\"canttidadtransportada\",\"public\".\"Desaduanizacion\".\"importefactura\",\"public\".\"Desaduanizacion\".\"fechatasacambioDOPaUSD\"," +
				"\"public\".\"Desaduanizacion\".\"tasacambioDOPaUSD\",\"public\".\"Desaduanizacion\".\"importefacturaconvertidoDOPaUSD\",\"public\".\"Desaduanizacion\".\"costoUnitarioDesaduanizacion\",\"public\".\"Tipo\".\"tipo\"" +
		"FROM  \"public\".\"Desaduanizacion\",\"public\".\"Tipo\" WHERE \"public\".\"Desaduanizacion\".\"id_materiaprima\" = ? and \"public\".\"Tipo\".\"id_tipo\"=\"public\".\"Desaduanizacion\".\"tipodesaduanizacion\" " ;
		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_desaduanizacion(result.getInt(1));
				a.setNombreproveedor(result.getString(2));	
				a.setNumerofactura(result.getString(3));
				a.setFechafactura(result.getDate(4));
				a.setCantidadtransportada(result.getFloat(5));
				a.setImportefactura(result.getFloat(6));
				a.setFechatasacambio(result.getDate(7));
				a.setTasacambio(result.getFloat(8));
				a.setImportefacturaconvertido(result.getFloat(9));
				a.setCostounitario(result.getFloat(10));
				a.setTipodesaduanizacion(result.getString(11));
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

	public static Desaduanizacion getDesaduanizacionMaterial (Integer materia){
		Desaduanizacion a = new Desaduanizacion();
		String sentence = " SELECT \"public\".\"Desaduanizacion\".\"id_desaduanizacion\",\"public\".\"Desaduanizacion\".\"nombreproveedor\",\"public\".\"Desaduanizacion\".\"numerofactura\",\"public\".\"Desaduanizacion\".\"fechafactura\"," +
				"\"public\".\"Desaduanizacion\".\"canttidadtransportada\",\"public\".\"Desaduanizacion\".\"importefactura\",\"public\".\"Desaduanizacion\".\"fechatasacambioDOPaUSD\"," +
				"\"public\".\"Desaduanizacion\".\"tasacambioDOPaUSD\",\"public\".\"Desaduanizacion\".\"importefacturaconvertidoDOPaUSD\",\"public\".\"Desaduanizacion\".\"costoUnitarioDesaduanizacion\",\"public\".\"Tipo\".\"tipo\"" +
		"FROM  \"public\".\"Desaduanizacion\",\"public\".\"Tipo\" WHERE \"public\".\"Desaduanizacion\".\"id_material\" = ? and \"public\".\"Tipo\".\"id_tipo\"=\"public\".\"Desaduanizacion\".\"tipodesaduanizacion\"  " ;
		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_desaduanizacion(result.getInt(1));
				a.setNombreproveedor(result.getString(2));	
				a.setNumerofactura(result.getString(3));
				a.setFechafactura(result.getDate(4));
				a.setCantidadtransportada(result.getFloat(5));
				a.setImportefactura(result.getFloat(6));
				a.setFechatasacambio(result.getDate(7));
				a.setTasacambio(result.getFloat(8));
				a.setImportefacturaconvertido(result.getFloat(9));
				a.setCostounitario(result.getFloat(10));
				a.setTipodesaduanizacion(result.getString(11));
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
	
	public static void insertarDesaduanizacionMateriaPrima(String proveedor,String factura,Date fech,int moneda,float importe,Date fechcambio,float tasa,float imprteconvertido,float costo,int materia,int tipo ,float canttransportada) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarDesaduanizacionMateriaPrima\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
		prepararCons.setInt(11, tipo);
		prepararCons.setFloat(12, canttransportada);
		prepararCons.execute();
	}
	
	public static void insertarDesaduanizacionMaterial(String proveedor,String factura,Date fech,int moneda,float importe,Date fechcambio,float tasa,float imprteconvertido,float costo,int materia,int tipo ,float canttransportada) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarDesaduanizacionMaterial\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
		prepararCons.setInt(11, tipo);
		prepararCons.setFloat(12, canttransportada);
		prepararCons.execute();
	}
	
	public static void EliminarDesaduanizacionMateriaPrima(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarDesaduanizacioMateriaPrima\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void EliminarDesaduanizacionMaterial(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarDesaduanizacionMaterial\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void ModificarDesadunaizacionMateriaPrima(int materia,float importe,Date fechcambio,float tasa,float imprteconvertido,float canttransportada,float costo,String proveedor,String factura,Date fech,int moneda,int tipo ) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarDesadunaizacionMateriaPrima\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
	
	public static void ModificarDesadunaizacionMaterial(int materia,float importe,Date fechcambio,float tasa,float imprteconvertido,float canttransportada,float costo,String proveedor,String factura,Date fech,int moneda,int tipo ) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarDesaduanizacionMaterial\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
