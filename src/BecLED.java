public class BecLED extends Becuri {
	
	private static final long serialVersionUID = 1L;
	private static final int autonomie = 30000;
	private static final String model = "LED";
	private static final String lumina = "neutra";
	private static final int putere = 50;
	
	public BecLED(int id, String prod, double pret, String dist) {
		super(id, prod, model, lumina, putere, autonomie, pret, dist);
	}

	public BecLED() {
		super();
		this.setModel(model);
		this.setAutonomie(autonomie);
		this.setLumina(lumina);
		this.setPutere(putere);
	}
	
	public BecLED(Becuri c) {
		super(c);
	}
}