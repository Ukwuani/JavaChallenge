package com.works.emr.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository < StaffEntity, Long > {

    StaffEntity findByUuid(String uuid);
}