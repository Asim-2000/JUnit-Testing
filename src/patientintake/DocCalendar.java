package patientintake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DocCalendar {

	private List<Appointments> appointments;
	private LocalDate today;

	public DocCalendar(LocalDate today) {
		this.appointments = new ArrayList<>();
		this.today = today;
	}

	public void addAppointment(String patientFirstName, String patientLastName, String doctorKey, String dateTime) {
		Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
		LocalDateTime localDateTime = ConversionDateTime.convertStringToDate(dateTime,today);
		Appointments appointment = new Appointments(patientFirstName, patientLastName, localDateTime, doc);
		appointments.add(appointment);
	}

//	private LocalDateTime convertToDateFromString(String dateTime) {
//
//	}

	public List<Appointments> getAppointments() {
		return this.appointments;
	}

	public List<Appointments> getTodayAppointments() {
		return appointments.stream().filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(today))
				.collect(Collectors.toList());
	}

	public boolean hasAppointment(LocalDate date) {
		return appointments.stream().anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
	}

}
