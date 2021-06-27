package patientIntakeSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClinicCalendar {

    List<PatientAppointment> appointments;

    public ClinicCalendar() {
        this.appointments = new ArrayList<>();
    }

    public ClinicCalendar(LocalDate now) {
    }

    public void addAppointment(String firstName, String lastName, String doc, String dateTime) {
        Doctor d = Doctor.valueOf(doc.toLowerCase());
        LocalDateTime localDateTime;
        try{
            localDateTime = LocalDateTime.parse(dateTime.toUpperCase(), DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));

        }catch (Exception ex) {
            throw new RuntimeException("Unable to create date time from: [" + dateTime.toUpperCase() + "], please enter with format [M/d/yyy h:mm a]");
        }
        PatientAppointment appointment = new PatientAppointment(firstName, lastName, localDateTime, d);
        appointments.add(appointment);
    }

    public List<PatientAppointment> getAppointments() {
        return appointments;
    }

    public boolean hasAppointment(LocalDate date) {
        return appointments.stream()
                .anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
    }
}
