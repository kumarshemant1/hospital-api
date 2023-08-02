package app.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.hospital.entity.Department;
import app.hospital.entity.Doctor;
import app.hospital.exception.HospitalException;
import app.hospital.service.DoctorService;

@RestController
@Validated
@RequestMapping(path = "/hospital/doctor", produces = {MediaType.APPLICATION_JSON_VALUE}) 
public class DoctorController {
	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	DoctorService doctorService;
	
//	@RequestMapping(value = "/fetch/{employeeId}", method = RequestMethod.GET)
	@GetMapping(path = "/fetch/{employeeId}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Doctor> getDoctor(@PathVariable Long employeeId) {
		Doctor value = doctorService.getDoctor(employeeId);
		return value!=null ? new ResponseEntity<>(value, HttpStatus.OK) : new ResponseEntity<Doctor>(value, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/fetchAll/{departments}")
	public ResponseEntity<List<Doctor>> getDoctors(@PathVariable List<Department> departments) {
		return new ResponseEntity<>(doctorService.getDoctors(departments), HttpStatus.OK);
	}
	
	@GetMapping()
	public String getByPage(@RequestParam(value = "page", defaultValue = "2") int page,
							@RequestParam(value = "limit", required = false) Integer limit) {
		logger.info("inside getByPage method");
		logger.debug("------------------------");
		return "Values are Page : " + page + ", Limit : " + limit;
	}
	
	@PostMapping(path = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Doctor> saveDoctor(@RequestBody @Valid Doctor doctor) {
		return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<>(doctorService.updateDoctor(doctor), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete/{employeeIds}")
	public ResponseEntity<Integer> deleteDoctor(@PathVariable List<Long> employeeIds) {
		return new ResponseEntity<>(doctorService.deleteDoctors(employeeIds), HttpStatus.OK);
	}
}
