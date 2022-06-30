package com.works.emr.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value ="v1/api/staff")
@RestController
class StaffController {
	@Autowired
	private StaffService staffService;
	/*
	Todo 
	 * endpoint: Add new staff and autogenerate uuid ~/
	 * endpoint: Update staff :: requires validation ~/
	 * 
	 * Validation middleware: Check if staff UUID exists
	 */

	@PostMapping
	public ResponseEntity<StaffEntity> createStaff(@RequestBody StaffEntity staff) {
		//todo extent to a service class
		StaffEntity newStaff = staffService.createStaff(staff);
		return new ResponseEntity<StaffEntity>(newStaff, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<StaffEntity> updateStaff(@RequestBody StaffEntity staff, @PathVariable Long id) {
		StaffEntity updatedStaff = staffService.updateStaff(staff, id);
		return new ResponseEntity<StaffEntity>(updatedStaff, HttpStatus.OK);
	}
	
}