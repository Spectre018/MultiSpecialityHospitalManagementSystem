import javax.print.Doc;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Doctor extends Employee{
    boolean[][] slots;

    public Doctor(int empId, String firstName, String lastName, int deptId, int managerId, String specialization){
        super(empId, firstName,lastName,deptId,managerId,specialization);
        slots = new boolean[30][20]; // docs can take appoint for next 30 days and each day will have 20 slots
        for(int i=0;i<30;i++){
            Arrays.fill(slots[i],true);
        }
    }



}


