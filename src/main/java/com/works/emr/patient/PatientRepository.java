package com.works.emr.patient;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository < PatientEntity, Long > {

    List<PatientEntity> findByAgeGreaterThanEqual(int age);
    

    @Modifying
    @Query("delete from patient p where last_visit_date BETWEEN ?1 AND ?2")
    void deleteInBulkByLast_visit_dateBetween(Date from, Date to);
}