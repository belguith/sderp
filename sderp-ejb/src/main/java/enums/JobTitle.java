package enums;

public enum JobTitle {
	NONE("---"), 
	OUVRIER("Ouvrier"), 
	C_ATELIER("Chef Atelier"), 
	AG_COMMERCIAL("Ag. Commercial"), 
	DIR_COMMERCIAL("Dir. Commercial"), 
	SERETARY("Sercertaire"),
	TRANSPORTER("Chauffeur"),
	DIR_RH("Dir. RH"), 
	DIR_GEN("Dir. General");

	private String title;

	JobTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.title;
	}

}
