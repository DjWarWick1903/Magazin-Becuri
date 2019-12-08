public class BecClasic extends Becuri {
	
	private static final long serialVersionUID = 1L;
	private static final int autonomie = 30000;
	private static final String model = "Clasic";
	private static final String lumina = "calda";
	private static final int putere = 25;
	
	public BecClasic(int id, String prod, double pret, String dist) {
		super(id, prod, model,lumina, putere, autonomie, pret, dist);
	}

	public BecClasic() {
		super();
		this.setModel(model);
		this.setAutonomie(autonomie);
		this.setLumina(lumina);
		this.setPutere(putere);
	}
	
	public BecClasic(Becuri c) {
		super(c);
	}
}