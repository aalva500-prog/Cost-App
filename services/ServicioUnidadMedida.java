package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.UnidadMedida;
import Utils.ConnectionBD;

public class ServicioUnidadMedida {
	
	public static LinkedList<UnidadMedida> getUnidades() throws SQLException, ClassNotFoundException{

		LinkedList<UnidadMedida> listRol = new LinkedList<UnidadMedida>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"UnidadMedida\".\"id_unidad\",\"public\".\"UnidadMedida\".\"unidad\" " +
		"FROM  \"public\".\"UnidadMedida\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			UnidadMedida rol = new UnidadMedida();
			rol.setId_unidad(resultado.getInt(1));
			rol.setTipo(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}

}
