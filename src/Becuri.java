import java.io.Serializable;

class Becuri implements Serializable {
	private static final long serialVersionUID = 1L;
	private String producator, model, lumina, distribuitor;
	private int autonomie, putere;
	private double pret;
	private int id;

	//constructor cu toti parametrii
	public Becuri(int id,String prod, String mod, String lum, int putere, int autonomie, double pret, String distr) {
		this.id = id;
		this.producator = prod;
		this.model = mod;
		this.lumina = lum;
		this.autonomie = autonomie;
		this.pret = pret;
		this.putere = putere;
		this.distribuitor = distr;
	}

	//constructor fara parametri
	public Becuri() {
		this.id = 0;
		this.producator = "Necunoscut";
		this.model = "Necunoscut";
		this.lumina = "Necunoscuta";
		this.autonomie = 0;
		this.pret = 0;
		this.putere = 0;
		this.distribuitor = "Necunoscut";
	}

	//constructor de copiere
	public Becuri(Becuri c) {
		id = c.id;
		producator = c.producator;
		model = c.model;
		lumina = c.lumina;
		autonomie = c.autonomie;
		pret = c.pret;
		putere = c.putere;
		distribuitor = c.distribuitor;
	}
	
	int getID() {
		return id;
	}
	
	String getAfisare() {
		return "Bec " + this.model + " " + this.producator + " - " + this.distribuitor;
	}
	
	String getDescriere() {
		return "Acesta este un bec " + this.model + ". Are o lumina " + this.lumina + " si o putere de " + this.putere + "W, cu o autonomie de " + this.autonomie + " ore. Distribuit de " + this.distribuitor
				+ " cu un pret de " + this.pret + " lei.";
	}

	double getPret() {
		return this.pret;
	}

	int getAutonomie() {
		return this.autonomie;
	}

	int getPutere() {
		return this.putere;
	}

	String getProducator() {
		return this.producator;
	}

	String getModel() {
		return this.model;
	}

	String getLumina() {
		return this.lumina;
	}
	
	String getDist() {
		return this.distribuitor;
	}
	
	protected void setID(int id) {
		this.id = id;
	}
	
	protected void setPret(double pret) {
		this.pret = pret;
	}

	protected void setAutonomie(int aut) {
		this.autonomie = aut;
	}

	protected void setPutere(int putere) {
		this.putere = putere;
	}

	protected void setProducator(String prod) {
		this.producator = prod;
	}

	protected void setModel(String mod) {
		this.model = mod;
	}

	protected void setLumina(String lum) {
		this.lumina = lum;
	}
	
	protected void setDist(String dist) {
		this.distribuitor = dist;
	}
}
