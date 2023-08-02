package app.hospital.service;

import java.util.List;

import com.sun.istack.NotNull;

import app.hospital.entity.Department;
import app.hospital.entity.Doctor;

public interface DoctorService {

	Doctor getDoctor(@NotNull Long id);
	
	List<Doctor> getDoctors(@NotNull List<Department> departments);
	
	Doctor saveDoctor(@NotNull Doctor doctor);
	
	Doctor updateDoctor(@NotNull Doctor doctor);
	
	Integer deleteDoctors(@NotNull List<Long> employeeIds);
}
