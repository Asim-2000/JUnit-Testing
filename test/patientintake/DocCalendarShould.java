package patientintake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.*;

class DocCalendarShould {

	private DocCalendar calender;

	@BeforeAll
	static void testClassSetup(){
		System.out.println("Before All...");
	}

	//before each executes before each test method
	@BeforeEach
	void init(){
		System.out.println("Before Each ...");
		//field declared in Class
		//Initializing the ClinicCalender Object before each test method as it is a repeatitive action
		calender = new DocCalendar(LocalDate.of(2021,4,23));
	}

	@Test
	public void allowEntryofAppointment() {
		calender.addAppointment("Jim", "Weaver", "avery", "9/1/2020 08:00 pm");
		List<Appointments> appointments = calender.getAppointments();

		// Testing if the list is not empty
		assertNotNull(appointments);

		// Testing if there is only one appointment in the list
		assertEquals(1, appointments.size());

		// get the data of the first entry in the List
		Appointments enteredAppointment = appointments.get(0);

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
		calender.addAppointment("Jim", "Weaver", "avery", "09/02/2020 02:00 pm");
		assertTrue(calender.hasAppointment(LocalDate.of(2020, 9, 2)));

	}

	@Test
	public void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
		assertFalse(calender.hasAppointment(LocalDate.of(2020, 9, 2)));

	}

	@Test
	public void returnCurrentDaysAppointments() {

		calender.addAppointment("Jim", "Weaver", "avery", "today 02:00 pm");
		calender.addAppointment("Muhammad", "Saad", "Johnson", "today 02:00 pm");
		calender.addAppointment("Jimmy", "Weaver", "avery", "today 02:00 pm");
		assertEquals(3, calender.getTodayAppointments().size());
		assertIterableEquals(calender.getTodayAppointments(), calender.getAppointments());
	}

	@AfterEach
	void TearDownEachTest(){
		System.out.println("After Each ...");
	}

	@AfterAll
	static void TearDownTestClass(){
		System.out.print("After All ...");
	}
}
