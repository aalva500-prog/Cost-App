package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.TipoMaterial;
import Utils.ConnectionBD;

public class ServicioTipoMaterial {
	
	public static LinkedList<TipoMaterial> getRoles() throws SQLException, ClassNotFoundException{

		LinkedList<TipoMaterial> listRol = new LinkedList<TipoMaterial>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"TipoMaterial\".\"id_tipomaterial\",\"public\".\"TipoMaterial\".\"tipomaterial\" " +
		"FROM  \"public\".\"TipoMaterial\"" +
		"ORDER BY \"public\".\"TipoMaterial\".\"tipomaterial\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			TipoMaterial rol = new TipoMaterial();
			rol.setId_tipomaterial(resultado.getInt(1));
			rol.setTipomaterial(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}


}
