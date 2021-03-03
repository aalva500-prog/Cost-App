package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aduana;
import Utils.ConnectionBD;

public class ServicioAduana {

	public static void insertarAduanaMateriaPrima(float importe,Date fecha,float tasa,float imprteconvertido,float canttransportada,float costo,int materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarAduanaMateriaPrima\" (?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setFloat(1, importe);
		prepararCons.setDate(2, fecha);
		prepararCons.setFloat(3, tasa);
		prepararCons.setFloat(4, imprteconvertido);
		prepararCons.setFloat(5, canttransportada);
		prepararCons.setFloat(6, costo);
		prepararCons.setInt(7, materia);		
		prepararCons.execute();
	}
	
	public static void insertarAduanaMaterial(float importe,Date fecha,float tasa,float imprteconvertido,float canttransportada,float costo,int materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarAduanaZonaFrancaMaterial\" (?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setFloat(1, importe);
		prepararCons.setDate(2, fecha);
		prepararCons.setFloat(3, tasa);
		prepararCons.setFloat(4, imprteconvertido);
		prepararCons.setFloat(5, canttransportada);
		prepararCons.setFloat(6, costo);
		prepararCons.setInt(7, materia);		
		prepararCons.execute();
	}
	
	public static Aduana getAduanaMateriaPrima (Integer materia){
		Aduana a = new Aduana();
		String sentence = " SELECT \"public\".\"Aduana\".\"id_aduana\",\"public\".\"Aduana\".\"importepagadoDOP\",\"public\".\"Aduana\".\"fechatasacambioDOPaUSD\",\"public\".\"Aduana\".\"tasacmbioDOPaUSD\"," +
				"\"public\".\"Aduana\".\"importepagadoconvertidoDOPaUSD\",\"public\".\"Aduana\".\"cantidadtransportada\",\"public\".\"Aduana\".\"costoUnitarioAduana\"" +
				"FROM  \"public\".\"Aduana\" WHERE \"public\".\"Aduana\".\"id_materiaprima\" = ? " ;		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_aduana(result.getInt(1));
				a.setImprteDOP(result.getFloat(2));	
				a.setFecha(result.getDate(3));
				a.setTasacambio(result.getFloat(4));
				a.setImporteconvertido(result.getFloat(5));
				a.setCantidadtransportada(result.getFloat(6));
				a.setCostounitario(result.getFloat(7));
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
	
	public static Aduana getAduanaMaterial (Integer materia){
		Aduana a = new Aduana();
		String sentence = " SELECT \"public\".\"Aduana\".\"id_aduana\",\"public\".\"Aduana\".\"importepagadoDOP\",\"public\".\"Aduana\".\"fechatasacambioDOPaUSD\",\"public\".\"Aduana\".\"tasacmbioDOPaUSD\"," +
				"\"public\".\"Aduana\".\"importepagadoconvertidoDOPaUSD\",\"public\".\"Aduana\".\"cantidadtransportada\",\"public\".\"Aduana\".\"costoUnitarioAduana\"" +
				"FROM  \"public\".\"Aduana\" WHERE \"public\".\"Aduana\".\"id_material\" = ? " ;		
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, materia);
			stat.execute();
			ResultSet result = stat.getResultSet();
			while (result.next()) {				
				a.setId_aduana(result.getInt(1));
				a.setImprteDOP(result.getFloat(2));	
				a.setFecha(result.getDate(3));
				a.setTasacambio(result.getFloat(4));
				a.setImporteconvertido(result.getFloat(5));
				a.setCantidadtransportada(result.getFloat(6));
				a.setCostounitario(result.getFloat(7));
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
	
	
	public static void EliminarAduanaMateriaPrima(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarAduanaMAteriaPrima\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void EliminarAduanaMaterial(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarAduanaMaterial\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	public static void ModificarAduanaMateriaPrima(int materia,float importe,Date fecha,float tasa,float imprteconvertido,float canttransportada,float costo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarAduanaMateriaPrima\" (?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, materia);	
		prepararCons.setFloat(2, importe);
		prepararCons.setDate(3, fecha);
		prepararCons.setFloat(4, tasa);
		prepararCons.setFloat(5, imprteconvertido);
		prepararCons.setFloat(6, canttransportada);
		prepararCons.setFloat(7, costo);			
		prepararCons.execute();
	}
	
	public static void ModificarAduanaMaterial(int materia,float importe,Date fecha,float tasa,float imprteconvertido,float canttransportada,float costo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"ModificarAduanaMaterial\" (?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, materia);	
		prepararCons.setFloat(2, importe);
		prepararCons.setDate(3, fecha);
		prepararCons.setFloat(4, tasa);
		prepararCons.setFloat(5, imprteconvertido);
		prepararCons.setFloat(6, canttransportada);
		prepararCons.setFloat(7, costo);			
		prepararCons.execute();
	}
	
}
