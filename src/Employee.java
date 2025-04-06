import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {

    int empId;
    String firstName;
    String lastName;
    int deptId;
    int managerId;
    Timestamp createdAt;
    String specialization;

    public Employee(){

    }

    public Employee(int empId, String firstName, String lastName, int deptId, int managerId, String specialization) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptId = deptId;
        this.managerId = managerId;
        this.specialization = specialization;
        Date date = new java.util.Date();
        this.createdAt = new Timestamp(date.getTime());
    }
}
