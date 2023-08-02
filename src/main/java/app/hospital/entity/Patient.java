package app.hospital.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {

	private Long patientId;
	
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@Email(message = "email format accepted")
	private String email;
	
	private List<Doctor> linkedDoctors;
	
	private String createdBy;
	
	private Timestamp createdAt;
	
	private String changedBy;
	
	private Timestamp changedAt;

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", linkedDoctors=" + linkedDoctors
				+ ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", changedBy=" + changedBy + ", changedAt="
				+ changedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changedAt == null) ? 0 : changedAt.hashCode());
		result = prime * result + ((changedBy == null) ? 0 : changedBy.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((linkedDoctors == null) ? 0 : linkedDoctors.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (changedAt == null) {
			if (other.changedAt != null)
				return false;
		} else if (!changedAt.equals(other.changedAt))
			return false;
		if (changedBy == null) {
			if (other.changedBy != null)
				return false;
		} else if (!changedBy.equals(other.changedBy))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (linkedDoctors == null) {
			if (other.linkedDoctors != null)
				return false;
		} else if (!linkedDoctors.equals(other.linkedDoctors))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}
	
}
