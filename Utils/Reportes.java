package Utils;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;


public class Reportes {

	
	
	private java.sql.Connection myConnection = null;
       static  Reportes report;
	
	public Reportes() {
		super();
		try {
			this.myConnection = ConnectionBD.connect.getConnection();
			Class.forName("org.postgresql.Driver");
			 myConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/costo", "postgres", "postgres");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static Reportes getR()
	{
		if(report == null)
		{
			report = new Reportes();
		}
		return report;
			
	}
	//Reporte Materiales
	public void ImprimirMaterial(int material) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", material);
		JasperFillManager.fillReportToFile("reportes/ReporteMaterial.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMaterial.jrprint", false,false);
	
}
public void ImprimirMaterialUSDImportado(int material) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", material);
		JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoUSD.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMaterialImportadoUSD.jrprint", false,false);
	
}
	
public void ImprimirMaterialconLogistica(int material) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", material);
		JasperFillManager.fillReportToFile("reportes/ReporteMaterialconLogistica.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMaterialconLogistica.jrprint", false,false);
	
}

public void ImprimirMaterialconGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialconGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialconGalon.jrprint", false,false);

}

public void ImprimirMaterialconGalonImportadoUSD(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoUSDconGAlon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoUSDconGAlon.jrprint", false,false);

}

public void ImprimirMaterialconGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialconGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialconGastos.jrprint", false,false);

}

public void ImprimirMaterialconGastosUSDImportado(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialUSDImportadoconGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialUSDImportadoconGastos.jrprint", false,false);

}


public void ImprimirMaterialconGalonyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialconGalonyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialconGalonyLogistica.jrprint", false,false);

}

public void ImprimirMaterialconUSDconGastosyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialconGalonyGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialconGalonyGastos.jrprint", false,false);

}

public void ImprimirMaterialconUSDconGastosyGalonImportado(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialUSDImportadoconGAlonyGAstos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialUSDImportadoconGAlonyGAstos.jrprint", false,false);

}


public void ImprimirMaterialNAcionalconGastosylogisticayGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialconGalonyGastosyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialconGalonyGastosyLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalconMolde(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMatrialNacionalUSDconMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMatrialNacionalUSDconMolde.jrprint", false,false);

}

public void ImprimirMaterialImportadoconMolde(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoUSDconMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoUSDconMolde.jrprint", false,false);

}

public void ImprimirMaterialNAcionalconMoldeyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialUSDconMoldeyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialUSDconMoldeyGalon.jrprint", false,false);

}

public void ImprimirMaterialImportadoconMoldeyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialImportadoconMoldeyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialImportadoconMoldeyGalon.jrprint", false,false);

}



public void ImprimirMaterialNAcionalconMoldeyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialconMoldeyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialconMoldeyLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalconMoldeygastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialNacionalUSDconGAstosyMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialNacionalUSDconGAstosyMolde.jrprint", false,false);

}


public void ImprimirMaterialImportadoconMoldeygastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoUSDconMoldeyGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoUSDconMoldeyGastos.jrprint", false,false);

}


public void ImprimirMaterialNAcionalconMoldeygastosyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialUSDNAcionalconGastosyMoldeyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialUSDNAcionalconGastosyMoldeyGalon.jrprint", false,false);

}

public void ImprimirMaterialImportadoconMoldeygastosyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialImportadoUSDconMoldeyGAstosyGAlon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialImportadoUSDconMoldeyGAstosyGAlon.jrprint", false,false);

}


public void ImprimirMaterialNAcionalconMoldeyGalonconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialconMoldeNAcionalUSDyVGalonconLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialconMoldeNAcionalUSDyVGalonconLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalconMoldeyGastosconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialUSDNAcionalconMoldeyGAstosyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialUSDNAcionalconMoldeyGAstosyLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalUSDCOmpleto(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialNAcionalUSDCompleto.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialNAcionalUSDCompleto.jrprint", false,false);

}

public void ImprimirMaterialNAcionalDOP(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialNacionalDOP.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialNacionalDOP.jrprint", false,false);

}

public void ImprimirMaterialImportadoEUR(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialIMportadoEUR.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialIMportadoEUR.jrprint", false,false);

}



public void ImprimirMaterialNAcionalDOPconGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialNacionalDOPconGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialNacionalDOPconGalon.jrprint", false,false);

}

public void ImprimirMaterialImportadoEURconGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialIMportadoconGAlonyEUR.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialIMportadoconGAlonyEUR.jrprint", false,false);

}


public void ImprimirMaterialDOPconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReportematerialDOPconLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReportematerialDOPconLogistica.jrprint", false,false);

}

public void ImprimirMaterialDOPconGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconGAstos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconGAstos.jrprint", false,false);

}

public void ImprimirMaterialEURconGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoEURconGAstos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoEURconGAstos.jrprint", false,false);

}



public void ImprimirMaterialDOPconLogisticayGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconGalonyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconGalonyLogistica.jrprint", false,false);

}

public void ImprimirMaterialDOPconGastosyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialDOPconGAstosyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialDOPconGAstosyGalon.jrprint", false,false);

}

public void ImprimirMaterialEURconGastosyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialEURconGastosyGAlon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialEURconGastosyGAlon.jrprint", false,false);

}


public void ImprimirMaterialDOPconGastosyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconGAstosyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconGAstosyLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalDOPconGAstosyLogisticayGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconGAstosyLogisticayGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconGAstosyLogisticayGalon.jrprint", false,false);

}

public void ImprimirMaterialNAcionalDOPconmolde(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconMolde.jrprint", false,false);

}

public void ImprimirMaterialImportadoEURconmolde(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoERUconMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoERUconMolde.jrprint", false,false);

}


public void ImprimirMaterialNAcionalDOPconmoldeyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconMoldeyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconMoldeyGalon.jrprint", false,false);

}

public void ImprimirMaterialImporteEURconmoldeyGalon(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoEURconMoldeyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoEURconMoldeyGalon.jrprint", false,false);
}


public void ImprimirMaterialNAcionalDOPconmoldeyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconMoldeyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconMoldeyLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalDOPconmoldeyGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconMoldeyGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconMoldeyGastos.jrprint", false,false);

}

public void ImprimirMaterialImportadaEURconmoldeyGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialImportadoEURconGAstosyMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialImportadoEURconGAstosyMolde.jrprint", false,false);

}


public void ImprimirMaterialNAcionalDOPconmoldeyGastosyGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconMoldeyGastosyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconMoldeyGastosyGalon.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportado(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialImportadoUSD.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialImportadoUSD.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialImportadoUSDconLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialImportadoUSDconLogistica.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialUSDImportadoconGAstos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialUSDImportadoconGAstos.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconMolde(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialUSDImportadoconMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialUSDImportadoconMolde.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconMoldeyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialUSDImportadoconMoldeyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialUSDImportadoconMoldeyLogistica.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconMoldeyGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialImportadoUSDconMoldeyGAstos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialImportadoUSDconMoldeyGAstos.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconGastosyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialUSDImportadoconGastosyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialUSDImportadoconGastosyLogistica.jrprint", false,false);

}

public void ImprimirMaterialCostoUSDImportadoconGastosyLogisticayMolde(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialUSD.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialUSD.jrprint", false,false);

}

public void ImprimirMaterialCostoEURImportado(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialEURImportado.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialEURImportado.jrprint", false,false);

}

public void ImprimirMaterialCostoEURImportadoconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialEURImportadoconLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialEURImportadoconLogistica.jrprint", false,false);

}

public void ImprimirMaterialCostoEURImportadoconGAstos(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialImportadoEURconGAstos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialImportadoEURconGAstos.jrprint", false,false);
}

public void ImprimirMaterialCostoEURImportadoconGAstosyLogistica(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialEURimportadoconLogisticayGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialEURimportadoconLogisticayGastos.jrprint", false,false);
}

public void ImprimirMaterialCostoEURImportadoconMolde(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMaterialEURImportadoconMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMaterialEURImportadoconMolde.jrprint", false,false);
}

public void ImprimirMaterialCostoEURImportadoconMoldeyLogistica(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialImportadoEURconMoldeyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialImportadoEURconMoldeyLogistica.jrprint", false,false);
}

public void ImprimirMaterialCostoEURImportadoconMoldeyGastos(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialImportadoEURconGAstosyMolde.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialImportadoEURconGAstosyMolde.jrprint", false,false);
}

public void ImprimirMaterialCostoEURImportadoconMoldeyGastosyLogistica(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMaterialEURIMportado.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMaterialEURIMportado.jrprint", false,false);
}

public void ImprimirMaterialImportadoEURconmoldeyGastosyGalon(int material) throws JRException{	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/reporteMaterialIMportadoenEURconMoldeyGAstosyGalon.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteMaterialIMportadoenEURconMoldeyGAstosyGalon.jrprint", false,false);
}


public void ImprimirMaterialNAcionalDOPconmoldeyLogisticayGalon(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOP.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOP.jrprint", false,false);

}

public void ImprimirMaterialNAcionalDOPconmoldeyLogisticayGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPconGastosMoldeyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPconGastosMoldeyLogistica.jrprint", false,false);

}

public void ImprimirMaterialNAcionalDOPCompleto(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("material", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMaterialDOPCompleto.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMaterialDOPCompleto.jrprint", false,false);

}


	//Reportes de Materias Primas 	
public void ImprimirMateriaPrimaCostoUSDImportado(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMateriaPrimaIMportadaUSD.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMateriaPrimaIMportadaUSD.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoUSDImportadoconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMateriaPrimaImportadaconLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMateriaPrimaImportadaconLogistica.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoUSDImportadoconGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMateriaPrimaImportadaUSDconGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMateriaPrimaImportadaUSDconGastos.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoUSDImportadoconGastosyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/reporteCostoMateriaPrimaUSDconGastosyLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteCostoMateriaPrimaUSDconGastosyLogistica.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoEUR(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMateriaPrimaEURImportada.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMateriaPrimaEURImportada.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoEURconLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMateriaPrimaUSDImportadaconLogistica.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMateriaPrimaUSDImportadaconLogistica.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoEURconGastos(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteMatriaPrimaEURImportadaconGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteMatriaPrimaEURImportadaconGastos.jrprint", false,false);

}

public void ImprimirMateriaPrimaCostoEURconGastosyLogistica(int material) throws JRException{
	
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("materia", material);
	JasperFillManager.fillReportToFile("reportes/ReporteCostoMateriaPrimaEURImportadoconLogisticayGastos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteCostoMateriaPrimaEURImportadoconLogisticayGastos.jrprint", false,false);

}


	public void ImprimirMateriaPrima(int materia) throws JRException{
		
			HashMap<String, Object> mypara = new HashMap <String, Object> ();
			mypara.put("materia", materia);
			JasperFillManager.fillReportToFile("reportes/reportemateriaprima.jasper", mypara, myConnection);
			JasperViewer.viewReport("reportes/reportemateriaprima.jrprint", false,false);
		
	}
	
	public void ImprimirMateriaPrimaImportadaUSD(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/ReporteMateriaPrimaImportadaEUR.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMateriaPrimaImportadaEUR.jrprint", false,false);
	
}
	
	public void ImprimirMateriaPrimaconLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprima1.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprima1.jrprint", false,false);
	
}

	
    public void ImprimirMateriaPrimaconGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateria2.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateria2.jrprint", false,false);
	
}

 public void ImprimirMateriaPrimaconUSDGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/ReporteMateriaPrimaImportadaUSDconGalon.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMateriaPrimaImportadaUSDconGalon.jrprint", false,false);
	
}
    
    
 public void ImprimirMateriaPrimaconGastos(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprima2.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprima2.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaconGastosUSD(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/ReporteMateriaPrimaImportadaUSDconGAstos.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMateriaPrimaImportadaUSDconGAstos.jrprint", false,false);
	
}
 
 
 public void ImprimirMateriaPrimaconGastosyLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaUSD.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaUSD.jrprint", false,false);
	
}
	
 public void ImprimirMateriaPrimaconGalonyLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaUSD1.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaUSD1.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaconUSDconGastosyGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprimaNacionalUSD.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprimaNacionalUSD.jrprint", false,false);
	
}
	
 public void ImprimirMateriaPrimaconUSDconGastosyGalonImportada(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/ReporteMateriaPrimaImportadaUSDconGalonyGAstos.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMateriaPrimaImportadaUSDconGalonyGAstos.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalUSDCompleto(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaNAcionalUSDCompleto.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaNAcionalUSDCompleto.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalDOP(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprimaDOPNAcional.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprimaDOPNAcional.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaImportadaEUR(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprimaEURImportada.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprimaEURImportada.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalDOPconGalo(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprimaDOPNacional1.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprimaDOPNacional1.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaImpoprtadaEURconGalo(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprimaEURIMportada1.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprimaEURIMportada1.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalDOPconLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaNacionalDOP2.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaNacionalDOP2.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaImportadaEURconLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaImportadaEUR2.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaImportadaEUR2.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalDOPconGastos(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaPrimaNacionalDOP3.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaPrimaNacionalDOP3.jrprint", false,false);
	
}
 
 
 public void ImprimirMateriaPrimaImportadaEURconGastos(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaPrimaImportadaEUR3.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaPrimaImportadaEUR3.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalDOPconLogisticayGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reporteMateriaNacionalDOP4.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reporteMateriaNacionalDOP4.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaImportadaEURconLogisticayGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaprimaImportadaEURconGalonyLogistica.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaprimaImportadaEURconGalonyLogistica.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaNAcionalDOPconGastosyGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reporteMateriaPrimaNacionalDOP5.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reporteMateriaPrimaNacionalDOP5.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaImportadaEURconGastosyGalon(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaPrimaImportadaEurconGalonyGastos.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaPrimaImportadaEurconGalonyGastos.jrprint", false,false);
	
}
 
 
 public void ImprimirMateriaPrimaNAcionalDOPconGastosyLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportemateriaPrimaNacionalDOP6.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportemateriaPrimaNacionalDOP6.jrprint", false,false);
	
}
 
 public void ImprimirMateriaPrimaImportadaEURconGastosyLogistica(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reportametraiPrimaImportadaconGastosyLogistica.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reportametraiPrimaImportadaconGastosyLogistica.jrprint", false,false);
	
}
 
 
 public void ImprimirMateriaPrimaNAcionalDOPCOmpleto(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/reporteMateriaDOPcompleto.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reporteMateriaDOPcompleto.jrprint", false,false);
	
}
 
 
 public void ImprimirMateriaPrimaImportadaEURCOmpleto(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/ReporteMateriaPrimaEURImportadaCompleto.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMateriaPrimaEURImportadaCompleto.jrprint", false,false);
	
}
 //Reportes Listados de Materias Primas
 public void ListadoMateriasPrimasAlcoholicas() throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MateriasPrimsAlcohólicas.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MateriasPrimsAlcohólicas.jrprint", false,false);
	
}
 
 public void ListadoMateriasPrimasAlcoholicasImportadas() throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MateriasPrimasAlcoholicasImportadas.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MateriasPrimasAlcoholicasImportadas.jrprint", false,false);
	
}
 
 public void ListadoMateriasPrimasAlcoholicasdeOrigenNAcional() throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MateriasPrimasAlcoholicasdeOrigenNAcional.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MateriasPrimasAlcoholicasdeOrigenNAcional.jrprint", false,false);
	
}
 
 public void ListadoMateriasPrimasNoAlcoholicas() throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MateriasPrimasNoAlcoholicas.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MateriasPrimasNoAlcoholicas.jrprint", false,false);
	
}
 
 public void ListadoMateriasPrimasNoAlcoholicasImportadas() throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MateriasPrimasNoAlcoholicasImportadas.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MateriasPrimasNoAlcoholicasImportadas.jrprint", false,false);
	
}
 
 public void ListadoMateriasPrimasNoAlcoholicasdeOrigenNAcional() throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MateriasPrimasNoAlcoholicasdeOrigenNacional.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MateriasPrimasNoAlcoholicasdeOrigenNacional.jrprint", false,false);
	
}
 
 
 //Reportes Transportación Aérea o Marítima
 public void ImprimirTransportaciónAéreaoMarítima(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/TransportacionUSD.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/TransportacionUSD.jrprint", false,false);
	
}
 
 public void ImprimirTransportaciónAéreaoMarítimaMaterial(int materia) throws JRException{
		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/TransportacionMaterialUSD.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/TransportacionMaterialUSD.jrprint", false,false);
	
}
 
 public void ImprimirTransportaciónAéreaoMarítimaEUR(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/ReporteTransportacionEUR.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteTransportacionEUR.jrprint", false,false);
	
}
 
 public void ImprimirTransportaciónAéreaoMarítimaEURMaterial(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/reporteTransportacionEURMaterial.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/reporteTransportacionEURMaterial.jrprint", false,false);
	
}
 
 //Reporte Aduana Zona Franca
 public void ImprimirAduanaZonaFranca(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/AduanaZonaFranca.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/AduanaZonaFranca.jrprint", false,false);
	
}
 
 public void ImprimirAduanaZonaFrancaMaterial(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/AduanaZonaFrancaMaterial.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/AduanaZonaFrancaMaterial.jrprint", false,false);
	
}
 
 
 //Reportes Desaduanizacion
 public void ImprimirDesaduanizacionUSD(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/DesaduanizacionUSD.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/DesaduanizacionUSD.jrprint", false,false);
	
}
 
 public void ImprimirDesaduanizacionUSDMaterial(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/DesaduanizacionUSDMaterial.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/DesaduanizacionUSDMaterial.jrprint", false,false);
	
}
 
 public void ImprimirDesaduanizacionDOP(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/DesaduanizacionDOP.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/DesaduanizacionDOP.jrprint", false,false);
	
}
 
 public void ImprimirDesaduanizacionDOPMaterial(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/DesaduanizacionDOPMaterial.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/DesaduanizacionDOPMaterial.jrprint", false,false);
	
}
 
 //Reportes Transportación Terrestre
 public void ImprimirTransportaciónTerrestreUSD(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/TransporteTerrestre.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/TransporteTerrestre.jrprint", false,false);
	
}
 
 public void ImprimirTransportaciónTerrestreUSDMaterial(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/TransportaciónTerrestreUSDMaterial.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/TransportaciónTerrestreUSDMaterial.jrprint", false,false);
	
}
 
 public void ImprimirTransportaciónTerrestreDOP(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("materia", materia);
		JasperFillManager.fillReportToFile("reportes/TransporteTerrestreDOP.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/TransporteTerrestreDOP.jrprint", false,false);
	
}
 
 public void ImprimirTransportaciónTerrestreDOPMaterial(int materia) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("material", materia);
		JasperFillManager.fillReportToFile("reportes/TransportacionTerrestreDOP.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/TransportacionTerrestreDOP.jrprint", false,false);
	
}
 
 
 //Reporte Listados de Materiales
 public void MaterialesOrigenNacional() throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/MaterialesOrigenNAcional.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/MaterialesOrigenNAcional.jrprint", false,false);
	}
 
 public void MaterialesImportados() throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/ReporteMaterialesImportados.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMaterialesImportados.jrprint", false,false);
	}
 
 public void Materiales() throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		JasperFillManager.fillReportToFile("reportes/ReporteMateriales.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/ReporteMateriales.jrprint", false,false);
	}
 
	}
