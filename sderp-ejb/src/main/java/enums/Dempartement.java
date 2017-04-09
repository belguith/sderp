package enums;

public enum Dempartement {

	
	ATELIER("Atelier"),DIR_GEN("Dir. General"),DIR_RH("Dir. RH"),DIR_COMM("Dir. Commercial");


	private String name;

	Dempartement(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
