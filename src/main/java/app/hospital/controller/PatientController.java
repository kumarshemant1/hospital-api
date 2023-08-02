package app.hospital.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.hospital.entity.Patient;

@RestController
@RequestMapping("/hospital/patient")
public class PatientController {
	
	@GetMapping(path = "/fetch/{patientId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Patient getPatient(@PathVariable Long patientId) {
		return null;
	}
	
	@PostMapping(path = "/add", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Patient savePatient(@RequestBody Patient patient) {
		return null;
	}
	
	@DeleteMapping(path = "/delete/{patientId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Integer deletePatient(@PathVariable Long patientId) {
		return null;
	}
}
