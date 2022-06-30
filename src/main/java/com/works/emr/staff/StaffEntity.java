package com.works.emr.staff;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "staff")
@Table(name = "staff")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    @Column(unique = true)
	private String uuid;
	private Date registration_date;

	public StaffEntity() {}

	public StaffEntity(
		Long id,
		String name,
		UUID uuid,
		Date registration_date
	) {
		this.id = id;
		this.name = name;
		this.uuid = uuid.toString();
		this.registration_date = registration_date;
	}

    public void setName(String name) {
        this.name = name;
    }

	public void setUuid(UUID uuid) {
		this.uuid = uuid.toString();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public UUID getUuid() {
		return UUID.fromString(uuid);
	}

	public Date getRegistration_date() {
		return registration_date;
	}
} 
