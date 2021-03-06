package com.works.emr.patient;

import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	/*
	 * endpoint: Fetch all patients profile  :: requires validation
	 * endpoint: download a patient profile as csv :: requires validation
	 * endpoint: delete multiple patients profile between data:: requires validation
	 * 
	 *
	 */

	public List<PatientEntity> getPatients(Integer minAge) {
		//TODO:: effect pagination
		//Got confused here, don't know if the 2years is age of patient or age of record
		// LocalDate date = LocalDate.now().minusYears(yearsAgo);
		List<PatientEntity> patients = patientRepository.findByAgeGreaterThanEqual(minAge);
		return patients;
	}
	
	public void downloadPatientProfile(PrintWriter writer, Long id) throws NoSuchElementException {
		
		PatientEntity patientInDB = patientRepository.findById(id).get();
		writer.write(PatientEntity.getKeysAsCommaSeperatedString());
		writer.write(patientInDB.getValuesAsCommaSeperatedString());
		
	}

	@Transactional
	public String deletePatients(Date from, Date to) {
		patientRepository.deleteInBulkByLast_visit_dateBetween(from, to);
		return String.format("deleted patients successfully");
	}

}