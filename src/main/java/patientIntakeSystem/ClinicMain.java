package patientIntakeSystem;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {


    private static ClinicCalendar calendar;

    public static void main(String[] args) throws IOException{
        calendar = new ClinicCalendar();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to patient intake computer system!\n\n");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu(sc);

        }
        System.out.println("Exiting system...\n");

    }

    private static String displayMenu(Scanner sc) throws IOException{
        System.out.println("Please select an option: ");
        System.out.println("1. Enter a patient appointment");
        System.out.println("2. View all appointments");
        System.out.println("X. Exit system.");
        System.out.println("Options: ");
        String option = sc.next();
        switch(option) {
            case "1": performPatientEntry(sc);
            return option;
            case "2": performAllAppointments(sc);
            return option;
            default:
                System.out.println("Invalid Option, please re-enter.");
                return option;
        }
    }

    private static void performPatientEntry(Scanner sc) {
        sc.nextLine();

        System.out.println("Please enter appointment info: ");
        System.out.println("Patient last name: ");
        String lastName = sc.nextLine();
        System.out.println("Patient first name: ");
        String firstName = sc.nextLine();
        System.out.println("Appointment date (M/d/yyyy h:mm a): ");
        String when = sc.nextLine();
        System.out.println("Doctor Name: ");
        String doc = sc.nextLine();
        try {
            calendar.addAppointment(firstName, lastName, doc, when);
        }catch (Exception ex) {
            System.out.println("Error:" +ex.getMessage());
            return;
        }
        System.out.println("Patient details entered successfully.\n\n");
    }

    private static void performAllAppointments(Scanner sc) throws IOException {
        System.out.println("Appointments in system: ");
        for (PatientAppointment appointment : calendar.getAppointments()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a");
            String appTime = formatter.format(appointment.getAppointmentDateTime());
            System.out.println(String.format("%s: %s, %s\t\tDoctor: %s", appTime, appointment.getPatientFirstName(), appointment.getPatientLastName(), appointment.getDoctor().getName()));
        }
        System.out.println("Press any key to continue...");
        System.in.read();
        System.out.println("\n\n");
    }

}
