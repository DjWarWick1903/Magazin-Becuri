public class BecEconomic extends Becuri {
	
	private static final long serialVersionUID = 1L;
	private static final int autonomie = 30000;
	private static final String model = "Economic";
	private static final String lumina = "rece";
	private static final int putere = 30;
	
	public BecEconomic(int id, String prod, double pret, String distr) {
		super(id, prod, model, lumina, putere, autonomie, pret, distr);
	}

	public BecEconomic() {
		super();
		this.setModel(model);
		this.setAutonomie(autonomie);
		this.setLumina(lumina);
		this.setPutere(putere);
	}

	public BecEconomic(Becuri c) {
		super(c);
	}
}