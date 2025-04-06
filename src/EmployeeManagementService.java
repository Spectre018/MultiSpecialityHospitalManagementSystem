import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeManagementService {
    AtomicInteger employeeId;
    HashMap<Integer, Employee> empIdVSEmployees;
    DoctorService doctorService;
    NurseService nurseService;
    StaffService staffService;


    EmployeeManagementService(){
        employeeId = new AtomicInteger(0);
        empIdVSEmployees = new HashMap<>();
        doctorService = new DoctorService();
        nurseService = new NurseService();
        staffService = new StaffService();
    }

    public Doctor addDoctor(String firstName, String lastName, int deptId, String specialization, int managerId){

        int employeeId = this.generateEmployeeId();
        Doctor doctor = doctorService.addDoctor(employeeId,firstName,lastName,deptId,managerId, specialization);
        empIdVSEmployees.put(employeeId, doctor);
        return doctor;
    }

    public Nurse addNurse(String firstName, String lastName, int deptId, String specialization, int managerId){
        int employeeId = this.generateEmployeeId();
        Nurse nurse = nurseService.addNurse(employeeId,firstName,lastName,deptId,managerId,specialization);
        empIdVSEmployees.put(employeeId, nurse);
        return nurse;
    }

    public Staff addStaff(String firstName, String lastName, int deptId, String specialization, int managerId){
        int employeeId = this.generateEmployeeId();
        Staff staff = staffService.addStaff(employeeId,firstName,lastName,deptId,managerId,specialization);
        empIdVSEmployees.put(employeeId, staff);
        return  staff;
    }

    public void removeDoctor(int employeeId){
        if(empIdVSEmployees.containsKey(employeeId)){
            empIdVSEmployees.remove(employeeId);
            this.doctorService.removeDoctor(employeeId);
            System.out.println("Doctor with employeeId "+employeeId+ " is removed");
        }
    }

    public void removeNurse(int employeeId){
        if(empIdVSEmployees.containsKey(employeeId)){
            empIdVSEmployees.remove(employeeId);
            this.nurseService.removeNurse(employeeId);
            System.out.println("Nurse with employeeId "+employeeId+ " is removed");
        }
    }

    public void removeStaff(int employeeId){
        if(empIdVSEmployees.containsKey(employeeId)){
            empIdVSEmployees.remove(employeeId);
            this.staffService.removeStaff(employeeId);
            System.out.println("Staff with employeeId "+employeeId+ " is removed");
        }
    }
    public int generateEmployeeId(){
        return employeeId.incrementAndGet();
    }


}
