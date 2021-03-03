package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.TipoMoneda;
import Utils.ConnectionBD;

public class ServicioMoneda {
	
	public static LinkedList<TipoMoneda> getUnidades() throws SQLException, ClassNotFoundException{
		LinkedList<TipoMoneda> listRol = new LinkedList<TipoMoneda>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"TipoMoneda\".\"id_tipomoneda\",\"public\".\"TipoMoneda\".\"moneda\" " +
		"FROM  \"public\".\"TipoMoneda\" " +
		"WHERE \"public\".\"TipoMoneda\".\"id_tipomoneda\"=1 OR \"public\".\"TipoMoneda\".\"id_tipomoneda\"=2";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			TipoMoneda rol = new TipoMoneda();
			rol.setId_tipomoneda(resultado.getInt(1));
			rol.setDescripcion(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}
	
	public static LinkedList<TipoMoneda> getMonedasInternacionales() throws SQLException, ClassNotFoundException{
		LinkedList<TipoMoneda> listRol = new LinkedList<TipoMoneda>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"TipoMoneda\".\"id_tipomoneda\",\"public\".\"TipoMoneda\".\"moneda\" " +
		"FROM  \"public\".\"TipoMoneda\" " +
		"WHERE \"public\".\"TipoMoneda\".\"id_tipomoneda\"=2 OR \"public\".\"TipoMoneda\".\"id_tipomoneda\"=3";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			TipoMoneda rol = new TipoMoneda();
			rol.setId_tipomoneda(resultado.getInt(1));
			rol.setDescripcion(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}
	
	
	

}
