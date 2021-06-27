package patientIntakeSystem;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
     void allowEntryOfAppointment(){
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Vivek", "Rawat", "soniya", "6/27/2021 6:30 pm");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        PatientAppointment appointment = appointments.get(0);
        assertEquals("Vivek", appointment.getPatientFirstName());
        assertEquals("Rawat", appointment.getPatientLastName());
        assertSame(Doctor.soniya, appointment.getDoctor());
        assertEquals("6/27/2021 6:30 PM", appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy h:mm a")));
    }

    @Test
    void returnTrueForHasAppointmentsIfThereAreAppointments() {
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Soniya", "Panwar", "vivek", "6/27/2021 6:30 PM");
        assertTrue(calendar.hasAppointment(LocalDate.of(2021, 6, 27)));
    }

    @Test
    void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        assertFalse(calendar.hasAppointment(LocalDate.of(2021, 6, 27)));
    }

}