package enums;

public enum UserType {
	USER("User"), ADMIN("Admin"), SUPERADMIN("Super-Admin");

	private String type;

	UserType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
