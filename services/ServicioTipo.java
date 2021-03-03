package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Tipo;
import Utils.ConnectionBD;

public class ServicioTipo {
	
	public static LinkedList<Tipo> getUnidades() throws SQLException, ClassNotFoundException{

		LinkedList<Tipo> listRol = new LinkedList<Tipo>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"Tipo\".\"id_tipo\",\"public\".\"Tipo\".\"tipo\" " +
		"FROM  \"public\".\"Tipo\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Tipo rol = new Tipo();
			rol.setId_tipo(resultado.getInt(1));
			rol.setTipo(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}

}
