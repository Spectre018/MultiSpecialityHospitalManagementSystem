import java.util.HashMap;
import java.util.Map;

public class NurseService {
    Map<Integer, Nurse> empIdVSNurse;
    NurseService(){
        empIdVSNurse = new HashMap<>();
    }
    public Nurse addNurse(int employeeId,String firstName, String lastName, int deptId, int managerId, String specialization){
        Nurse nurse =  new Nurse(employeeId, firstName,lastName,deptId,managerId,specialization);
        empIdVSNurse.put(employeeId, nurse);
        return nurse;
    }

    public void removeNurse(int employeeId){
        empIdVSNurse.remove(employeeId);
    }


}
