package com.works.emr.patient;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;



@Entity(name = "patient")
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private Date last_visit_date;

	public PatientEntity(){}

	public PatientEntity(
		@Nullable Long id,
		String name,
		int age,
		Date last_visit_date
	) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.last_visit_date = last_visit_date;
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Date getLastVisitDate() {
		return last_visit_date;
	}

	public static String getKeysAsCommaSeperatedString() {
		return "id, name, age, last_visit_date\n";
	}

	public String getValuesAsCommaSeperatedString() {
		return String.format("%1$s, %2$s, %3$s, %4$s\n", id, name, age, last_visit_date);
	}
	
} 
