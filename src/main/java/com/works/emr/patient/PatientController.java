package com.works.emr.patient;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.works.emr.utils.Response;


@Component
@RequestMapping(value ="v1/api/patient")
@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	/*
	 * endpoint: Fetch all patients profile  :: requires validation
	 * endpoint: download a patient profiel as csv :: requires validation
	 * endpoint: delete multiple patients profile between data:: requires validation
	 * 
	 *
	 */

	@GetMapping
	public ResponseEntity<List<PatientEntity>> getPatients(@RequestParam(value = "minAge", defaultValue ="0") Integer minAge) {
		return new ResponseEntity<List<PatientEntity>>(patientService.getPatients(minAge), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public void downloadPatientProfile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		String filename = "patients.csv";
		response.setContentType("text/csv; charset=utf-8");
		response.setHeader("Conent-Disposition", "attachment; filename=\""+ filename + "\"");
		patientService.downloadPatientProfile(response.getWriter(), id);	
	}


	@DeleteMapping
	public ResponseEntity<Response> deletePatients(@RequestParam Date from, @RequestParam Date to) {
		String deletePatientsMsg = patientService.deletePatients(from, to);
		return new ResponseEntity<Response>(new Response(deletePatientsMsg), HttpStatus.OK);
	}
}