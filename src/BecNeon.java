public class BecNeon extends Becuri {
	
	private static final long serialVersionUID = 1L;
	private static final int autonomie = 6000;
	private static final String model = "Neon";
	private static final String lumina = "rece";
	private static final int putere = 18;
	
	public BecNeon(int id,String prod, double pret, String dist) {
		super(id,prod,model,lumina,putere,autonomie,pret, dist);
	}

	public BecNeon() {
		super();
		this.setModel(model);
		this.setAutonomie(autonomie);
		this.setLumina(lumina);
		this.setPutere(putere);
	}
	
	public BecNeon(Becuri c) {
		super(c);
	}
}