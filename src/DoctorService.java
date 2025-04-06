import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {
    int employeeId;
    HashMap<Integer, Doctor> empIdVSDoctor;
    DoctorService(){
        empIdVSDoctor = new HashMap<>();
    }
    public Doctor addDoctor(int employeeId, String firstName, String lastName, int deptId, int managerId, String specialization){
        Doctor doc = new Doctor(employeeId, firstName,lastName,deptId,managerId,specialization);
        empIdVSDoctor.put(employeeId, doc);
        return doc;
    }

    public void removeDoctor(int employeeId){
        empIdVSDoctor.remove(employeeId);
    }

    public List<Doctor> getDoctorsByDepartment(int deptId){
        System.out.println("from doc service size of hashmap = "+empIdVSDoctor.size());
        return empIdVSDoctor.values().stream().filter(doc -> doc.deptId == deptId).collect(Collectors.toList());
    }

    public List<Appointment> getAvailableSlotsByDay(Doctor doctor, int day){
        boolean[][] slots = doctor.slots;
        List<Appointment> availableAppointments = new ArrayList<>();
        for(int i=0;i<20;i++){
            if(slots[day][i]){
                availableAppointments.add(new Appointment(day,i));
            }
        }
        return availableAppointments;
    }


}
