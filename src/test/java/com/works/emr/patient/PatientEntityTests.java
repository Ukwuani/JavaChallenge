package com.works.emr.patient;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PatientEntityTests {
	

	@Test
	void should_Return_Comma_Seperated_String() throws Exception {
		Date date = new Date();
		assertEquals(new PatientEntity(
			1L,
			"Hope John",
			3,
			date
		).getValuesAsCommaSeperatedString(),
		String.format("1, Hope John, 3, %1$s\n", date)
		);
	}
}
