import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DepartmentService {

    AtomicInteger departmentId;
    int deptId;
    String deptName;
    HashMap<Integer, String> deptIdVsName;
    HashMap<String, Integer> nameVSDeptId;

    public DepartmentService(){
        departmentId = new AtomicInteger(0);
        deptIdVsName = new HashMap<>();
        nameVSDeptId = new HashMap<>();
    }
    public Department addDepartment(int deptId, String deptName){
        if(this.nameVSDeptId.containsKey(deptName)){
            throw new RuntimeException("this department already exists");
        }
        Department dept = new Department(this.generateDepartmentId(), deptName);
        deptIdVsName.put(deptId,deptName);
        nameVSDeptId.put(deptName, deptId);
        return dept;
    }

    public HashMap<Integer, String> getAllDepartments(){
        return deptIdVsName;
    }

    public int getDepartmentIdByName(String deptName){
        return nameVSDeptId.get(deptName);
    }

    private int generateDepartmentId(){
        return this.departmentId.incrementAndGet();
    }
}
