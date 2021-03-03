package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.TipoMateria;
import Utils.ConnectionBD;

public class ServicioTipoMateria {
	public static LinkedList<TipoMateria> getTiposMateria() throws SQLException, ClassNotFoundException{

		LinkedList<TipoMateria> listRol = new LinkedList<TipoMateria>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\",\"public\".\"TipoMateriaPrima\".\"tipomateria\" " +
		"FROM  \"public\".\"TipoMateriaPrima\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			TipoMateria rol = new TipoMateria();
			rol.setId_tipo(resultado.getInt(1));
			rol.setDescripcion(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}

}
