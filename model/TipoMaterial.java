package model;

public class TipoMaterial {
	private int id_tipomaterial;
	private String tipomaterial;
	
	
	public TipoMaterial(int id_tipomaterial, String tipomaterial) {
		super();
		this.id_tipomaterial = id_tipomaterial;
		this.tipomaterial = tipomaterial;
	}


	public TipoMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_tipomaterial() {
		return id_tipomaterial;
	}


	public void setId_tipomaterial(int id_tipomaterial) {
		this.id_tipomaterial = id_tipomaterial;
	}


	public String getTipomaterial() {
		return tipomaterial;
	}


	public void setTipomaterial(String tipomaterial) {
		this.tipomaterial = tipomaterial;
	}


	@Override
	public String toString() {
		return this.tipomaterial;
	}
	
	

}
