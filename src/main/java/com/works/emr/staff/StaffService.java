package com.works.emr.staff;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

	public StaffEntity createStaff(StaffEntity staff) {
        staff.setUuid(UUID.randomUUID());
		return staffRepository.save(staff);
	}

	public StaffEntity updateStaff( StaffEntity staff, Long id) {
        StaffEntity staffInDB = staffRepository.findById(id).get();

        if (!staff.getName().isEmpty()) {
            staffInDB.setName(staff.getName());
        }

        return staffRepository.save(staffInDB);
	}

    public StaffEntity getStaff(String uuid) {
        return staffRepository.findByUuid(uuid);
	}
}