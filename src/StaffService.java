import java.util.HashMap;

public class StaffService {
    HashMap<Integer, Staff> empIdVSStaff;
    StaffService(){
        empIdVSStaff = new HashMap<>();
    }
    public Staff addStaff(int employeeId, String firstName, String lastName, int deptId, int managerId, String specialization){
        Staff staff = new Staff(employeeId, firstName,lastName,deptId,managerId,specialization);
        empIdVSStaff.put(employeeId, staff);
        return staff;
    }

    public void removeStaff(int employeeId){
        empIdVSStaff.remove(employeeId);
    }


}
