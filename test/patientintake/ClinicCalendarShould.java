package patientintake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;

class ClinicCalendarShould {

	@Test
	public void allowEntryofAppointment() {
		ClinicCalendar calender = new ClinicCalendar(LocalDate.now());
		calender.addAppointment("Jim", "Weaver", "avery", "9/1/2020 08:00 pm");
		List<PatientAppointment> appointments = calender.getAppointments();

		// Testing if the list is not empty
		assertNotNull(appointments);

		// Testing if there is only one appointment in the list
		assertEquals(1, appointments.size());

		// get the data of the first entry in the List
		PatientAppointment enteredAppointment = appointments.get(0);

		// Testing if the first name of the patient is equal to the expected first name
		assertEquals("Jim", enteredAppointment.getPatientFirstName());

		// Testing if the last name of patient is equal to the expected last name
		assertEquals("Weaver", enteredAppointment.getPatientLastName());

		// Testing if the doctor of the patient is equal to the expected doctor
		// assertSame will verify that the objects mentioned are pointing to the same
		// allocation in the memory
		assertSame(Doctor.avery, enteredAppointment.getDoctor());

		assertEquals("9/1/2020 08:00 pm",
				enteredAppointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));

	}

	@Test
	public void returnTrueForHasAppointmentsIfThereAreAppointments() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		calendar.addAppointment("Jim", "Weaver", "avery", "09/02/2020 02:00 pm");
		assertTrue(calendar.hasAppointment(LocalDate.of(2020, 9, 2)));

	}

	@Test
	public void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		assertFalse(calendar.hasAppointment(LocalDate.of(2020, 9, 2)));

	}

	@Test
	public void returnCurrentDaysAppointments() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		calendar.addAppointment("Jim", "Weaver", "avery", "04/23/2021 02:00 pm");
		calendar.addAppointment("Muhammad", "Saad", "Johnson", "04/23/2021 02:00 pm");
		calendar.addAppointment("Jimmy", "Weaver", "avery", "04/23/2021 02:00 pm");
		assertEquals(3, calendar.getTodayAppointments().size());
	}

}
