package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.MateriaPrima;
import Utils.ConnectionBD;

public class ServicioMateriaPrima {
	
	//Metodos de Materias Primas Nacionales
	//Listado de MAterias Primas de Origen Nacional
	public static LinkedList<MateriaPrima> getMateriasPrimasNacionales() throws SQLException, ClassNotFoundException{
		LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materiaprima\",\"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\"," +
				"\"public\".\"MateriaPrima\".\"numerofactura\",\"public\".\"MateriaPrima\".\"fechafactura\",\"public\".\"MateriaPrima\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
				"\"public\".\"MateriaPrima\".\"cantidadcomprada\",\"public\".\"MateriaPrima\".\"cantidadconvertidagalon\",\"public\".\"TipoMoneda\".\"moneda\"," +
				"\"public\".\"MateriaPrima\".\"importecompra\",\"public\".\"MateriaPrima\".\"precioadquisicion\",\"public\".\"MateriaPrima\".\"cantidadtotalfacturada\",\"public\".\"MateriaPrima\".\"gastosvarios\"," +
				"\"public\".\"MateriaPrima\".\"precioadquisicionUSDyGastos\"," +
				"\"public\".\"MateriaPrima\".\"precioadquisicionDOPaUSD\"," +
				"\"public\".\"MateriaPrima\".\"fechaconversionDOPaUSD\",\"public\".\"MateriaPrima\".\"tasacambiodeDOPaUSD\"," +
				"\"public\".\"MateriaPrima\".\"precioadqusisicionDOPyGastos\",\"public\".\"MateriaPrima\".\"costounitario\",\"public\".\"MateriaPrima\".\"costounitariologistica\"" +
				"FROM  \"public\".\"MateriaPrima\",\"public\".\"TipoMateriaPrima\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\"" +
				"WHERE  \"public\".\"MateriaPrima\".\"tipomateriaprima\" = \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\" and \"public\".\"MateriaPrima\".\"unidadmedida\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
				"and \"public\".\"MateriaPrima\".\"tipomoneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"MateriaPrima\".\"origen\"=1" +
				"ORDER BY \"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\",\"public\".\"MateriaPrima\".\"fechafactura\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			MateriaPrima user = new MateriaPrima();
			user.setId_Materia(resultado.getInt(1));
			user.setTipomateriaprima(resultado.getString(2));
			user.setNombreproveedor(resultado.getString(3));
			user.setNumerofactura(resultado.getString(4));
			user.setFechafactura(resultado.getDate(5));
			user.setDescripcion(resultado.getString(6));
			user.setUnidadmedida(resultado.getString(7));
			user.setCantcomprada(resultado.getFloat(8));
			user.setCantconvertgalon(resultado.getFloat(9));
			user.setTipomoneda(resultado.getString(10));
			user.setImportecompra(resultado.getFloat(11));
			user.setPrecioadquisisonUSD(resultado.getFloat(12));
			user.setCantidadtotalfacturada(resultado.getFloat(13));
			user.setGastosvarios(resultado.getFloat(14));
			user.setPrecioadquisicionUSDyGastos(resultado.getFloat(15));
			user.setPrecioadquisicionDOPaUSD(resultado.getFloat(16));
			user.setFechaconversionDOPaUSD(resultado.getDate(17));
			user.setTasacambioDOPaUSD(resultado.getFloat(18));
			user.setPrecioadquisicionDOPyGastos(resultado.getFloat(19));
			user.setCostounitario(resultado.getFloat(20));
			user.setCostounitariologistica(resultado.getFloat(21));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	//Listado de MAterias Primas de Origen Nacional Alcoholicas
		public static LinkedList<MateriaPrima> getMateriasPrimasNacionalesAlcoholicas() throws SQLException, ClassNotFoundException{
			LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
			Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materiaprima\",\"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\"," +
					"\"public\".\"MateriaPrima\".\"numerofactura\",\"public\".\"MateriaPrima\".\"fechafactura\",\"public\".\"MateriaPrima\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
					"\"public\".\"MateriaPrima\".\"cantidadcomprada\",\"public\".\"MateriaPrima\".\"cantidadconvertidagalon\",\"public\".\"TipoMoneda\".\"moneda\"," +
					"\"public\".\"MateriaPrima\".\"importecompra\",\"public\".\"MateriaPrima\".\"precioadquisicion\",\"public\".\"MateriaPrima\".\"cantidadtotalfacturada\",\"public\".\"MateriaPrima\".\"gastosvarios\"," +
					"\"public\".\"MateriaPrima\".\"precioadquisicionUSDyGastos\"," +
					"\"public\".\"MateriaPrima\".\"precioadquisicionDOPaUSD\"," +
					"\"public\".\"MateriaPrima\".\"fechaconversionDOPaUSD\",\"public\".\"MateriaPrima\".\"tasacambiodeDOPaUSD\"," +
					"\"public\".\"MateriaPrima\".\"precioadqusisicionDOPyGastos\",\"public\".\"MateriaPrima\".\"costounitario\",\"public\".\"MateriaPrima\".\"costounitariologistica\"" +
					"FROM  \"public\".\"MateriaPrima\",\"public\".\"TipoMateriaPrima\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\"" +
					"WHERE  \"public\".\"MateriaPrima\".\"tipomateriaprima\" = \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\" and \"public\".\"MateriaPrima\".\"unidadmedida\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
					"and \"public\".\"MateriaPrima\".\"tipomoneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"MateriaPrima\".\"origen\"=1 and \"public\".\"MateriaPrima\".\"tipomateriaprima\" =1" +
					"ORDER BY \"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\",\"public\".\"MateriaPrima\".\"fechafactura\"";
			ResultSet resultado = consulta.executeQuery(sqlSentenc);
			while (resultado.next()) {
				MateriaPrima user = new MateriaPrima();
				user.setId_Materia(resultado.getInt(1));
				user.setTipomateriaprima(resultado.getString(2));
				user.setNombreproveedor(resultado.getString(3));
				user.setNumerofactura(resultado.getString(4));
				user.setFechafactura(resultado.getDate(5));
				user.setDescripcion(resultado.getString(6));
				user.setUnidadmedida(resultado.getString(7));
				user.setCantcomprada(resultado.getFloat(8));
				user.setCantconvertgalon(resultado.getFloat(9));
				user.setTipomoneda(resultado.getString(10));
				user.setImportecompra(resultado.getFloat(11));
				user.setPrecioadquisisonUSD(resultado.getFloat(12));
				user.setCantidadtotalfacturada(resultado.getFloat(13));
				user.setGastosvarios(resultado.getFloat(14));
				user.setPrecioadquisicionUSDyGastos(resultado.getFloat(15));
				user.setPrecioadquisicionDOPaUSD(resultado.getFloat(16));
				user.setFechaconversionDOPaUSD(resultado.getDate(17));
				user.setTasacambioDOPaUSD(resultado.getFloat(18));
				user.setPrecioadquisicionDOPyGastos(resultado.getFloat(19));
				user.setCostounitario(resultado.getFloat(20));
				user.setCostounitariologistica(resultado.getFloat(21));
				listUsuarios.add(user);
			}
			return listUsuarios;
		}
		
		
		//Listado de MAterias Primas de Origen Nacional Alcoholicas
				public static LinkedList<MateriaPrima> getMateriasPrimasNacionalesNoAlcoholicas() throws SQLException, ClassNotFoundException{
					LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materiaprima\",\"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\"," +
							"\"public\".\"MateriaPrima\".\"numerofactura\",\"public\".\"MateriaPrima\".\"fechafactura\",\"public\".\"MateriaPrima\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"MateriaPrima\".\"cantidadcomprada\",\"public\".\"MateriaPrima\".\"cantidadconvertidagalon\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"MateriaPrima\".\"importecompra\",\"public\".\"MateriaPrima\".\"precioadquisicion\",\"public\".\"MateriaPrima\".\"cantidadtotalfacturada\",\"public\".\"MateriaPrima\".\"gastosvarios\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionUSDyGastos\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionDOPaUSD\"," +
							"\"public\".\"MateriaPrima\".\"fechaconversionDOPaUSD\",\"public\".\"MateriaPrima\".\"tasacambiodeDOPaUSD\"," +
							"\"public\".\"MateriaPrima\".\"precioadqusisicionDOPyGastos\",\"public\".\"MateriaPrima\".\"costounitario\",\"public\".\"MateriaPrima\".\"costounitariologistica\"" +
							"FROM  \"public\".\"MateriaPrima\",\"public\".\"TipoMateriaPrima\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\"" +
							"WHERE  \"public\".\"MateriaPrima\".\"tipomateriaprima\" = \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\" and \"public\".\"MateriaPrima\".\"unidadmedida\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"MateriaPrima\".\"tipomoneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"MateriaPrima\".\"origen\"=1 and \"public\".\"MateriaPrima\".\"tipomateriaprima\" =2" +
							"ORDER BY \"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\",\"public\".\"MateriaPrima\".\"fechafactura\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						MateriaPrima user = new MateriaPrima();
						user.setId_Materia(resultado.getInt(1));
						user.setTipomateriaprima(resultado.getString(2));
						user.setNombreproveedor(resultado.getString(3));
						user.setNumerofactura(resultado.getString(4));
						user.setFechafactura(resultado.getDate(5));
						user.setDescripcion(resultado.getString(6));
						user.setUnidadmedida(resultado.getString(7));
						user.setCantcomprada(resultado.getFloat(8));
						user.setCantconvertgalon(resultado.getFloat(9));
						user.setTipomoneda(resultado.getString(10));
						user.setImportecompra(resultado.getFloat(11));
						user.setPrecioadquisisonUSD(resultado.getFloat(12));
						user.setCantidadtotalfacturada(resultado.getFloat(13));
						user.setGastosvarios(resultado.getFloat(14));
						user.setPrecioadquisicionUSDyGastos(resultado.getFloat(15));
						user.setPrecioadquisicionDOPaUSD(resultado.getFloat(16));
						user.setFechaconversionDOPaUSD(resultado.getDate(17));
						user.setTasacambioDOPaUSD(resultado.getFloat(18));
						user.setPrecioadquisicionDOPyGastos(resultado.getFloat(19));
						user.setCostounitario(resultado.getFloat(20));
						user.setCostounitariologistica(resultado.getFloat(21));
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
		
	//Listado de MAterias Primas Importadas
		public static LinkedList<MateriaPrima> getMateriasPrimasExtranjeras() throws SQLException, ClassNotFoundException{
			LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
			Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materiaprima\",\"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\"," +
					"\"public\".\"MateriaPrima\".\"numerofactura\",\"public\".\"MateriaPrima\".\"fechafactura\",\"public\".\"MateriaPrima\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
					"\"public\".\"MateriaPrima\".\"cantidadcomprada\",\"public\".\"MateriaPrima\".\"cantidadconvertidagalon\",\"public\".\"TipoMoneda\".\"moneda\"," +
					"\"public\".\"MateriaPrima\".\"importecompra\",\"public\".\"MateriaPrima\".\"precioadquisicion\",\"public\".\"MateriaPrima\".\"cantidadtotalfacturada\",\"public\".\"MateriaPrima\".\"gastosvarios\"," +
					"\"public\".\"MateriaPrima\".\"precioadquisicionUSDyGastos\"," +
					"\"public\".\"MateriaPrima\".\"precioadquisicionEUROaUSD\"," +
					"\"public\".\"MateriaPrima\".\"fechaconversionEURaUSD\",\"public\".\"MateriaPrima\".\"tasaconversionEURaUSD\"," +
					"\"public\".\"MateriaPrima\".\"precioadquisicionEURyGastos\"," +
					"\"public\".\"MateriaPrima\".\"costounitario\",\"public\".\"MateriaPrima\".\"costounitariologistica\"" +					
					"FROM  \"public\".\"MateriaPrima\",\"public\".\"TipoMateriaPrima\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\"" +
					"WHERE  \"public\".\"MateriaPrima\".\"tipomateriaprima\" = \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\" and \"public\".\"MateriaPrima\".\"unidadmedida\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
					"and \"public\".\"MateriaPrima\".\"tipomoneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"MateriaPrima\".\"origen\"=2" +
					"ORDER BY \"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\",\"public\".\"MateriaPrima\".\"fechafactura\"";
			ResultSet resultado = consulta.executeQuery(sqlSentenc);
			while (resultado.next()) {
				MateriaPrima user = new MateriaPrima();
				user.setId_Materia(resultado.getInt(1));
				user.setTipomateriaprima(resultado.getString(2));
				user.setNombreproveedor(resultado.getString(3));
				user.setNumerofactura(resultado.getString(4));
				user.setFechafactura(resultado.getDate(5));
				user.setDescripcion(resultado.getString(6));
				user.setUnidadmedida(resultado.getString(7));
				user.setCantcomprada(resultado.getFloat(8));
				user.setCantconvertgalon(resultado.getFloat(9));
				user.setTipomoneda(resultado.getString(10));
				user.setImportecompra(resultado.getFloat(11));
				user.setPrecioadquisisonUSD(resultado.getFloat(12));
				user.setCantidadtotalfacturada(resultado.getFloat(13));
				user.setGastosvarios(resultado.getFloat(14));
				user.setPrecioadquisicionUSDyGastos(resultado.getFloat(15));
				user.setPrecioadquisicioEUROaUSD(resultado.getFloat(16));
				user.setFechaconversionEURaUSD(resultado.getDate(17));
				user.setTasaconversionEURaUSD(resultado.getFloat(18));
				user.setPrecioadquisicionEURyGastos(resultado.getFloat(19));
				user.setCostounitario(resultado.getFloat(20));
				user.setCostounitariologistica(resultado.getFloat(21));				
				listUsuarios.add(user);
			}
			return listUsuarios;
		}
		
		//Listado de MAterias Primas Importadas Alcoholicas
				public static LinkedList<MateriaPrima> getMateriasPrimasExtranjerasAlcoholicas() throws SQLException, ClassNotFoundException{
					LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materiaprima\",\"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\"," +
							"\"public\".\"MateriaPrima\".\"numerofactura\",\"public\".\"MateriaPrima\".\"fechafactura\",\"public\".\"MateriaPrima\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"MateriaPrima\".\"cantidadcomprada\",\"public\".\"MateriaPrima\".\"cantidadconvertidagalon\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"MateriaPrima\".\"importecompra\",\"public\".\"MateriaPrima\".\"precioadquisicion\",\"public\".\"MateriaPrima\".\"cantidadtotalfacturada\",\"public\".\"MateriaPrima\".\"gastosvarios\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionUSDyGastos\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionEUROaUSD\"," +
							"\"public\".\"MateriaPrima\".\"fechaconversionEURaUSD\",\"public\".\"MateriaPrima\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionEURyGastos\"," +
							"\"public\".\"MateriaPrima\".\"costounitario\",\"public\".\"MateriaPrima\".\"costounitariologistica\"" +					
							"FROM  \"public\".\"MateriaPrima\",\"public\".\"TipoMateriaPrima\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\"" +
							"WHERE  \"public\".\"MateriaPrima\".\"tipomateriaprima\" = \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\" and \"public\".\"MateriaPrima\".\"unidadmedida\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"MateriaPrima\".\"tipomoneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"MateriaPrima\".\"origen\"=2 and \"public\".\"MateriaPrima\".\"tipomateriaprima\"=1" +
							"ORDER BY \"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\",\"public\".\"MateriaPrima\".\"fechafactura\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						MateriaPrima user = new MateriaPrima();
						user.setId_Materia(resultado.getInt(1));
						user.setTipomateriaprima(resultado.getString(2));
						user.setNombreproveedor(resultado.getString(3));
						user.setNumerofactura(resultado.getString(4));
						user.setFechafactura(resultado.getDate(5));
						user.setDescripcion(resultado.getString(6));
						user.setUnidadmedida(resultado.getString(7));
						user.setCantcomprada(resultado.getFloat(8));
						user.setCantconvertgalon(resultado.getFloat(9));
						user.setTipomoneda(resultado.getString(10));
						user.setImportecompra(resultado.getFloat(11));
						user.setPrecioadquisisonUSD(resultado.getFloat(12));
						user.setCantidadtotalfacturada(resultado.getFloat(13));
						user.setGastosvarios(resultado.getFloat(14));
						user.setPrecioadquisicionUSDyGastos(resultado.getFloat(15));
						user.setPrecioadquisicioEUROaUSD(resultado.getFloat(16));
						user.setFechaconversionEURaUSD(resultado.getDate(17));
						user.setTasaconversionEURaUSD(resultado.getFloat(18));
						user.setPrecioadquisicionEURyGastos(resultado.getFloat(19));
						user.setCostounitario(resultado.getFloat(20));
						user.setCostounitariologistica(resultado.getFloat(21));				
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
	
				
				//Listado de MAterias Primas Importadas No Alcoholicas 
				public static LinkedList<MateriaPrima> getMateriasPrimasExtranjerasNoAlcoholicas() throws SQLException, ClassNotFoundException{
					LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
					Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materiaprima\",\"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\"," +
							"\"public\".\"MateriaPrima\".\"numerofactura\",\"public\".\"MateriaPrima\".\"fechafactura\",\"public\".\"MateriaPrima\".\"descripcion\",\"public\".\"UnidadMedida\".\"unidad\"," +
							"\"public\".\"MateriaPrima\".\"cantidadcomprada\",\"public\".\"MateriaPrima\".\"cantidadconvertidagalon\",\"public\".\"TipoMoneda\".\"moneda\"," +
							"\"public\".\"MateriaPrima\".\"importecompra\",\"public\".\"MateriaPrima\".\"precioadquisicion\",\"public\".\"MateriaPrima\".\"cantidadtotalfacturada\",\"public\".\"MateriaPrima\".\"gastosvarios\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionUSDyGastos\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionEUROaUSD\"," +
							"\"public\".\"MateriaPrima\".\"fechaconversionEURaUSD\",\"public\".\"MateriaPrima\".\"tasaconversionEURaUSD\"," +
							"\"public\".\"MateriaPrima\".\"precioadquisicionEURyGastos\"," +
							"\"public\".\"MateriaPrima\".\"costounitario\",\"public\".\"MateriaPrima\".\"costounitariologistica\"" +					
							"FROM  \"public\".\"MateriaPrima\",\"public\".\"TipoMateriaPrima\",\"public\".\"UnidadMedida\",\"public\".\"TipoMoneda\"" +
							"WHERE  \"public\".\"MateriaPrima\".\"tipomateriaprima\" = \"public\".\"TipoMateriaPrima\".\"id_tipoproducto\" and \"public\".\"MateriaPrima\".\"unidadmedida\" = \"public\".\"UnidadMedida\".\"id_unidad\"" +
							"and \"public\".\"MateriaPrima\".\"tipomoneda\" = \"public\".\"TipoMoneda\".\"id_tipomoneda\" and \"public\".\"MateriaPrima\".\"origen\"=2 and \"public\".\"MateriaPrima\".\"tipomateriaprima\"=2" +
							"ORDER BY \"public\".\"TipoMateriaPrima\".\"tipomateria\",\"public\".\"MateriaPrima\".\"nombreproveedor\",\"public\".\"MateriaPrima\".\"fechafactura\"";
					ResultSet resultado = consulta.executeQuery(sqlSentenc);
					while (resultado.next()) {
						MateriaPrima user = new MateriaPrima();
						user.setId_Materia(resultado.getInt(1));
						user.setTipomateriaprima(resultado.getString(2));
						user.setNombreproveedor(resultado.getString(3));
						user.setNumerofactura(resultado.getString(4));
						user.setFechafactura(resultado.getDate(5));
						user.setDescripcion(resultado.getString(6));
						user.setUnidadmedida(resultado.getString(7));
						user.setCantcomprada(resultado.getFloat(8));
						user.setCantconvertgalon(resultado.getFloat(9));
						user.setTipomoneda(resultado.getString(10));
						user.setImportecompra(resultado.getFloat(11));
						user.setPrecioadquisisonUSD(resultado.getFloat(12));
						user.setCantidadtotalfacturada(resultado.getFloat(13));
						user.setGastosvarios(resultado.getFloat(14));
						user.setPrecioadquisicionUSDyGastos(resultado.getFloat(15));
						user.setPrecioadquisicioEUROaUSD(resultado.getFloat(16));
						user.setFechaconversionEURaUSD(resultado.getDate(17));
						user.setTasaconversionEURaUSD(resultado.getFloat(18));
						user.setPrecioadquisicionEURyGastos(resultado.getFloat(19));
						user.setCostounitario(resultado.getFloat(20));
						user.setCostounitariologistica(resultado.getFloat(21));				
						listUsuarios.add(user);
					}
					return listUsuarios;
				}
	public static void EliminarMateriaPrima(int id_materia) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"EliminarMateriaPrima\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, id_materia);
		prepararCons.execute();
	}
	
	
	
	public static void  ModificarMateriaPrima(int id_materia,int tipomateria,String nombreproveedor,String factura,Date fechfactura,String descripcion,int unidad,float cantcomprada,float cantconvertida,int moneda,
			float importe,float precioadquisicion,float cantfacturada,float gastosvarios,float precioadquisicionconGastos,float precioadqusiscionDOPaUSD,Date fechaconversion,float tasaconversion,
			float precionadquisiscionDOPyGastos,float costounitario,float logistica) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarMateriaPrimaNacional\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_materia); 
		prepararCons.setInt(2,tipomateria); 
		prepararCons.setString(3,nombreproveedor);
		prepararCons.setString(4, factura);
		prepararCons.setDate(5, fechfactura);
		prepararCons.setString(6, descripcion);
		prepararCons.setInt(7, unidad);
		prepararCons.setFloat(8, cantcomprada);
		prepararCons.setFloat(9, cantconvertida);
		prepararCons.setInt(10, moneda);
		prepararCons.setFloat(11, importe);
		prepararCons.setFloat(12, precioadquisicion);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, gastosvarios);
		prepararCons.setFloat(15, precioadquisicionconGastos);
		prepararCons.setFloat(16, precioadqusiscionDOPaUSD);
		prepararCons.setDate(17, fechaconversion);
		prepararCons.setFloat(18, tasaconversion);
		prepararCons.setFloat(19, precionadquisiscionDOPyGastos);
		prepararCons.setFloat(20, costounitario);
		prepararCons.setFloat(21, logistica);
		prepararCons.execute();
		
	}
	
	public static void  ModificarMateriaPrimaNacionalsinLogistica(int id_materia,int tipomateria,String nombreproveedor,String factura,Date fechfactura,String descripcion,int unidad,float cantcomprada,float cantconvertida,int moneda,
			float importe,float precioadquisicion,float cantfacturada,float gastosvarios,float precioadquisicionconGastos,float precioadqusiscionDOPaUSD,Date fechaconversion,float tasaconversion,
			float precionadquisiscionDOPyGastos,float costounitario) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarMateriaPrimaNacionalsinLogistica\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_materia); 
		prepararCons.setInt(2,tipomateria); 
		prepararCons.setString(3,nombreproveedor);
		prepararCons.setString(4, factura);
		prepararCons.setDate(5, fechfactura);
		prepararCons.setString(6, descripcion);
		prepararCons.setInt(7, unidad);
		prepararCons.setFloat(8, cantcomprada);
		prepararCons.setFloat(9, cantconvertida);
		prepararCons.setInt(10, moneda);
		prepararCons.setFloat(11, importe);
		prepararCons.setFloat(12, precioadquisicion);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, gastosvarios);
		prepararCons.setFloat(15, precioadquisicionconGastos);
		prepararCons.setFloat(16, precioadqusiscionDOPaUSD);
		prepararCons.setDate(17, fechaconversion);
		prepararCons.setFloat(18, tasaconversion);
		prepararCons.setFloat(19, precionadquisiscionDOPyGastos);
		prepararCons.setFloat(20, costounitario);
		prepararCons.execute();
		
	}
	public static void  ModificarMateriaPrimaExtranjera(int id_materia,int tipomateria,String nombreproveedor,String factura,Date fechfactura,String descripcion,int unidad,float cantcomprada,float cantconvertida,int moneda,
			float importe,float precioadquisicion,float cantfacturada,float gastosvarios,float precioadquisicionconGastos,float precioadqusiscionEURaUSD,Date fechaconversion,float tasaconversion,
			float precionadquisiscionEURyGastos) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarMateriaPrimaExtranjera\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_materia); 
		prepararCons.setInt(2,tipomateria); 
		prepararCons.setString(3,nombreproveedor);
		prepararCons.setString(4, factura);
		prepararCons.setDate(5, fechfactura);
		prepararCons.setString(6, descripcion);
		prepararCons.setInt(7, unidad);
		prepararCons.setFloat(8, cantcomprada);
		prepararCons.setFloat(9, cantconvertida);
		prepararCons.setInt(10, moneda);
		prepararCons.setFloat(11, importe);
		prepararCons.setFloat(12, precioadquisicion);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, gastosvarios);
		prepararCons.setFloat(15, precioadquisicionconGastos);
		prepararCons.setFloat(16, precioadqusiscionEURaUSD);
		prepararCons.setDate(17, fechaconversion);
		prepararCons.setFloat(18, tasaconversion);
		prepararCons.setFloat(19, precionadquisiscionEURyGastos);
		prepararCons.execute();
		
	}
	
	//Metodos de Materias Primas Nacionales en USD
	public static void insertarMateriaNacionalUSDsinGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalUSDsinGalon\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaNacionalUSDsinGalonyConLogistica(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float logistica) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalsinGalonyConLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, logistica);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalUSDconGalony(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalUSDconGalon\" (?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, galon);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaNacionalUSDconGAstos(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaUSDconGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, gastos);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, precioconGastos);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaNacionalUSDconGAstosyLogistica(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,float log) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalUSDconGastosylogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, gastos);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, precioconGastos);
		prepararCons.setFloat(15, log);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalUSDconGalonyLogistica(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float galon,float log) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaconGAlonyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, galon);
		prepararCons.setFloat(13, log);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalUSDconGAstosyGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalUSDconGalonyGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, gastos);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, precioconGastos);
		prepararCons.setFloat(15, galon);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalUSDconGAstosGalonyLOg(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,float gastos,float cantfacturada,float precioconGastos,float log,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsetarMateriaNAcionalUSDconGAstosLogisticayGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setFloat(12, gastos);
		prepararCons.setFloat(13, cantfacturada);
		prepararCons.setFloat(14, precioconGastos);
		prepararCons.setFloat(15, log);
		prepararCons.setFloat(16, galon);
		prepararCons.execute();
	}
	
	//Metodos de Materias Primas Nacionales en DOP
	public static void insertarMateriaNacionalDOP(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsetarMateriaNacionalDOP\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalDOPyGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, galon);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaNacionalDOPyLogistica(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float logistica) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPconLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, logistica);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalDOPyGastos(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPconGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, gastos);
		prepararCons.setFloat(16, cantfacturada);
		prepararCons.setFloat(17, precioDOP);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalDOPyGalonconLogistica(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float galon,float log) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPconGalonyLogistica\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, galon);
		prepararCons.setFloat(16, log);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalDOPyGastosconGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPconGAlonyGAstos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, gastos);
		prepararCons.setFloat(16, cantfacturada);
		prepararCons.setFloat(17, precioDOP);
		prepararCons.setFloat(18, galon);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalDOPyGastosconLogistica(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float log) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPconLogisticayGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, gastos);
		prepararCons.setFloat(16, cantfacturada);
		prepararCons.setFloat(17, precioDOP);
		prepararCons.setFloat(18, log);
		prepararCons.execute();
	}
	
	public static void insertarMateriaNacionalDOPyGastosconLogisticayGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float costo,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float log,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaNacionalDOPconGAstosLogisticayGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, costo);
		prepararCons.setDate(12, fechcambio);
		prepararCons.setFloat(13, tasa);
		prepararCons.setFloat(14, preciocambio);
		prepararCons.setFloat(15, gastos);
		prepararCons.setFloat(16, cantfacturada);
		prepararCons.setFloat(17, precioDOP);
		prepararCons.setFloat(18, log);
		prepararCons.setFloat(19, galon);
		prepararCons.execute();
	}
	
	//Metodos de las Materias Primas Importadas
	public static void insertarMateriaPrimaImportadaUSD(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImportadaUSD\" (?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaImportadaUSDconGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImportadaUSDyGalon\" (?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, galon);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaImportadaUSDconGAstos(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float gastos,float cantfacturada,float precioconGastos) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaIMportadaUSDconGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, gastos);
		prepararCons.setFloat(12, cantfacturada);
		prepararCons.setFloat(13, precioconGastos);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaImportadaUSDconGAstosyGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,float gastos,float cantfacturada,float precioconGastos,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImportadaUSDconGastosyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setFloat(11, gastos);
		prepararCons.setFloat(12, cantfacturada);
		prepararCons.setFloat(13, precioconGastos);
		prepararCons.setFloat(14, galon);
		prepararCons.execute();
	}
	
	
	//Metodos de MAterias Primas Importadas en EUR
	public static void insertarMateriaIMportadEUR(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImportadaEUR\" (?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setDate(11, fechcambio);
		prepararCons.setFloat(12, tasa);
		prepararCons.setFloat(13, preciocambio);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaImportadaEURyGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImportadaEURyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setDate(11, fechcambio);
		prepararCons.setFloat(12, tasa);
		prepararCons.setFloat(13, preciocambio);
		prepararCons.setFloat(14, galon);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaImportadaEURyGastos(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImprtadaEURyGastos\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setDate(11, fechcambio);
		prepararCons.setFloat(12, tasa);
		prepararCons.setFloat(13, preciocambio);
		prepararCons.setFloat(14, gastos);
		prepararCons.setFloat(15, cantfacturada);
		prepararCons.setFloat(16, precioDOP);
		prepararCons.execute();
	}
	
	
	public static void insertarMateriaImportadaEURyGastosconGalon(int tipomateria,String proveedor,String factura,Date fech, String descrip,int unidad,float cantcomprada,int moneda,float importe,float precio,Date fechcambio,float tasa,float preciocambio,float gastos,float cantfacturada,float precioDOP,float galon) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrimaImportadaEURcpmGastosyGalon\" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, tipomateria);
		prepararCons.setString(2, proveedor);
		prepararCons.setString(3, factura);
		prepararCons.setDate(4, fech);
		prepararCons.setString(5, descrip);
		prepararCons.setInt(6, unidad);
		prepararCons.setFloat(7, cantcomprada);
		prepararCons.setInt(8, moneda);
		prepararCons.setFloat(9, importe);
		prepararCons.setFloat(10, precio);
		prepararCons.setDate(11, fechcambio);
		prepararCons.setFloat(12, tasa);
		prepararCons.setFloat(13, preciocambio);
		prepararCons.setFloat(14, gastos);
		prepararCons.setFloat(15, cantfacturada);
		prepararCons.setFloat(16, precioDOP);
		prepararCons.setFloat(17, galon);
		prepararCons.execute();
	}
	
	
	public static void  InsertarCostoMateriaPrimaImportada(int id_materia,float costounitario,float logistica) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"InsertarCostoUnitarioMateriaPrimaExtranjera\"(?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_materia); 
		prepararCons.setFloat(2, costounitario);
		prepararCons.setFloat(3, logistica);
		prepararCons.execute();		
	}
	
	
	public static void  InsertarCostoMateriaPrimaImportadasinLogistica(int id_materia,float costounitario) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"InsertarCostoUnitariosinLogisticaMateriaPrimaImportada\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_materia); 
		prepararCons.setFloat(2, costounitario);
		prepararCons.execute();		
	}
}
