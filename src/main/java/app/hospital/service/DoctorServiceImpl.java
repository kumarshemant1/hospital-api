package app.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.istack.NotNull;

import app.hospital.entity.Department;
import app.hospital.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Override
	public Doctor getDoctor(@NotNull Long id) {
		return new Doctor();
	}
	
	@Override
	public List<Doctor> getDoctors(@NotNull List<Department> departments) {
		return null;
	}

	@Override
	public Doctor saveDoctor(@NotNull Doctor doctor) {
		return doctor;
	}

	@Override
	public Doctor updateDoctor(@NotNull Doctor doctor) {
		return doctor;
	}

	@Override
	public Integer deleteDoctors(@NotNull List<Long> employeeIds) {
		return 1;
	}
}
