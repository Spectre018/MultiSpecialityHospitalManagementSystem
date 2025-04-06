import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppointmentService {
    HashMap<Integer, List<Appointment>> doctorsAppointment;
    HashMap<Integer, List<Appointment>> patientsAppointment;

    public AppointmentService() {
        doctorsAppointment = new HashMap<>();
        patientsAppointment = new HashMap<>();
    }

    public void bookAppointment(int patientUUID, Doctor doctor, int day, int slot){
        boolean isSlotFree = doctor.slots[day][slot];
        if(!isSlotFree){
            System.out.println("Slit is full for "+day+"th day");
        }else{
            // add to doc map
            doctor.slots[day][slot] = false;

            List<Appointment> docAppontmentList = doctorsAppointment.getOrDefault(doctor.empId, new ArrayList<>());
            docAppontmentList.add(new Appointment(day, slot));
            doctorsAppointment.put(doctor.empId, docAppontmentList);

            // add to patient map
            List<Appointment> patientAppointmentList = patientsAppointment.getOrDefault(patientUUID,new ArrayList<Appointment>());
            patientAppointmentList.add(new Appointment(day, slot));
            patientsAppointment.put(patientUUID, patientAppointmentList);
            System.out.println("Appointment fixed successfully");
        }
    }
}
