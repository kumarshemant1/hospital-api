package app.hospital.entity;

public enum Department {

	PHYSICIAN("PHYSICIAN"),
	EYES("EYES"),
	ENT("ENT"),
	DENTAL("DENTAL"),
	ORTHOPEDIC("ORTHOPEDIC"),
	CARDIOLOGY("CARDIOLOGY"),
	HEMATOLOGY("HEMATOLOGY"),
	NEUROLOGY("HEMATOLOGY"),
	PATHOLOGY("PATHOLOGY");
	
	public final String label;
	
	private Department(final String label) {
		this.label = label;
	}
}
