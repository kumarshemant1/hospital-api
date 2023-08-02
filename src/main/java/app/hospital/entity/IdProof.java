package app.hospital.entity;

public enum IdProof {

	AADHAR("AADHAR"),
	PAN("PAN"),
	PASSPORT("PASSPORT");
	
	public final String label;
	
	private IdProof(final String label) {
		this.label = label;
	}
	
}
