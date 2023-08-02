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
public class Doctor {	
	
	private Long employeeId;

	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@Email(message = "email format accepted")
	private String email;
	
	private Department department;
	
	private Boolean status;
	
	private List<Patient> patients;
	
	private String createdBy;
	
	private Timestamp createdAt;
	
	private String changedBy;
	
	private Timestamp changedAt;

	@Override
	public String toString() {
		return "Doctor [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", status="
				+ status + ", patients=" + patients + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", changedBy=" + changedBy + ", changedAt=" + changedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changedAt == null) ? 0 : changedAt.hashCode());
		result = prime * result + ((changedBy == null) ? 0 : changedBy.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patients == null) ? 0 : patients.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Doctor other = (Doctor) obj;
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
		if (department != other.department)
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patients == null) {
			if (other.patients != null)
				return false;
		} else if (!patients.equals(other.patients))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
