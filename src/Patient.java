import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
    int uuid;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String Address;
    String history;
    Timestamp createdAt;
    List<Appointment> activeAppointments;
    List<Appointment> pastAppointments;

    public Patient(){
        activeAppointments = new ArrayList<>();
        pastAppointments = new ArrayList<>();
    }

    public Patient(int uuid, String firstName, String lastName, String phoneNumber, String email, String address, String history) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        Address = address;
        this.history = history;
        Date date = new Date();
        this.createdAt = new Timestamp(date.getTime());
    }
}
